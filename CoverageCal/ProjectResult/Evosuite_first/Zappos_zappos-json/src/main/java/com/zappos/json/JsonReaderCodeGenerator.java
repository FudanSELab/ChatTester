/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *     http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.zappos.json;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import com.zappos.json.annot.JsonEnum.EnumValue;
import com.zappos.json.util.Reflections;
import com.zappos.json.util.Strings;
import com.zappos.json.util.TypeImpl;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonReaderCodeGenerator {

  private final Map<Class<?>, JsonReaderInvoker> JSON_READER_INVOKERS = new ConcurrentHashMap<>();
  
  private ZapposJson zapposJson;
  
  private JsonBeanIntrospector beanIntrospector;
  
  public JsonReaderCodeGenerator(ZapposJson zapposJson, JsonBeanIntrospector beanIntrospector){
    this.zapposJson = zapposJson;
    this.beanIntrospector = beanIntrospector;
  }
  
  protected JsonReaderInvoker getReader(Class<?> clazz){
    return JSON_READER_INVOKERS.get(clazz);
  }
  
  protected synchronized void deregisterAll(){
    JSON_READER_INVOKERS.clear();
  }
  
  protected void deregister(Class<?> clazz){
    synchronized(clazz){
      JSON_READER_INVOKERS.remove(clazz);
    }
  }
  
  protected JsonReaderInvoker registerReader(Class<?> clazz)
      throws Exception {
    synchronized(clazz){
      JsonReaderInvoker readerInvoker = JSON_READER_INVOKERS.get(clazz);
      if (readerInvoker != null) {
        return readerInvoker;
      }
  
      StringBuilder methodBody = new StringBuilder();
      methodBody.append("{\n");
      List<PathAndCode> pathAndCodes = generateJsonReaderBody(clazz);
  
      /*
       * Compiler will optimize if(String.equals) when the number of conditions <= 16
       */
      if (pathAndCodes.size() > 16
          && new HashSet<>(pathAndCodes).size() == pathAndCodes.size()) {
  
        methodBody.append("int pathHash = getPath($1).hashCode();\n");
        methodBody.append("switch(pathHash){\n");
        for (PathAndCode pathAndCode : pathAndCodes) {
          methodBody.append("case ")
              .append(String.valueOf(pathAndCode.getPath().hashCode()))
              .append(":\n{").append(pathAndCode.getCode()).append("\n}");
        }
        methodBody.append("}\n");
  
      } else {
  
        int i = 0;
        methodBody.append("String path = getPath($1);\n");
        for (PathAndCode pathAndCode : pathAndCodes) {
          if (i == 0) {
            methodBody.append("if");
          } else {
            methodBody.append("else if");
          }
          methodBody.append("(\"" + pathAndCode.getPath() + "\".equals(path)){\n");
          methodBody.append(pathAndCode.getCode());
          methodBody.append("}\n");
          i++;
        }
  
      }
      methodBody.append("return $2;\n}");
      zapposJson.debug("\nReader code for \"@\"\n=========\n@\n=========\n", clazz, methodBody);
      ClassPool classPool = ClassPool.getDefault();
      classPool.importPackage("java.util");
      classPool.importPackage("java.math");
      CtClass jsonCtClass = classPool.get(JsonReader.class.getName());
  
      String randomName = Strings.randomAlphabetic(16);
      jsonCtClass.setName(randomName + "_JSON_Reader");
      CtMethod ctMethod = jsonCtClass.getDeclaredMethod("createObject",
          new CtClass[] { classPool.get(int.class.getName()),
              classPool.get(Map.class.getName()) });
      ctMethod.setBody(methodBody.toString());
      readerInvoker = new JsonReaderInvoker(zapposJson, jsonCtClass.toClass());
      JSON_READER_INVOKERS.put(clazz, readerInvoker);
      
      return readerInvoker;
    }
  }
  
  
  private List<PathAndCode> generateJsonReaderBody(Class<?> clazz) throws Exception {

    List<PathAndCode> pathAndCodes = new ArrayList<>();
    Map<String, TypeInfo> typeInfos = new HashMap<>();

    traverseObjectTree(clazz, new String[JsonReader.MAX_OBJECT_TREE_DEEP], 1, typeInfos);

    for (Map.Entry<String, TypeInfo> entry : typeInfos.entrySet()) {

      zapposJson.debug("Path: @, Mapping: @", entry.getKey(), entry.getValue());

      String path = entry.getKey();
      TypeInfo typeInfo = entry.getValue();
      String typeName = typeInfo.getType().getName();

      String code = typeName + " __o = new " + typeName + "();\n";

      for (AttributeInfo attrInfo: typeInfo.getAttributeInfos()) {
        
        Method writeMethod = attrInfo.getDetail().getMethod();
        String jsonKey = attrInfo.getDetail().getJsonKey();
        String writeMethodName = writeMethod.getName();
        String valueName = Character.toLowerCase(writeMethodName.charAt(3))
            + writeMethodName.substring(4);
        String tmpValueName = "_" + valueName;
        Class<?> attrType = attrInfo.getAttributeType();
        code += "Object " + tmpValueName + " = $2.get(\"" + jsonKey + "\");\n";
        code += "if(" + tmpValueName + " != null){\n";

        if (attrType.isArray()
            || attrInfo.getArrayType() == 1) { /* native array type */
          /*
           * Note: javassist doesn't understand syntax after Java 1.4
           */
          Class<?> componentType = (attrInfo.getArrayType() == 1) ? attrType : attrType.getComponentType();
          if(componentType == byte.class){
            code += "byte "+valueName+"[] =  javax.xml.bind.DatatypeConverter.parseBase64Binary((String)"+tmpValueName+");\n";
          }else{
            code += generateArrayFromListCode(attrInfo.getDetail(), componentType, valueName, tmpValueName);
          }
        } else if (Iterable.class.isAssignableFrom(attrType)
            || attrInfo.getArrayType() == 2) { /* collection type */
          Class<?> collectionType = null;
          Class<?> componentType = null;
          if (attrInfo.getArrayType() == 2) {
            /* collection of object */
            componentType = attrType;
            collectionType = attrInfo.getCollectionType();
          } else {
            componentType = Reflections.getFirstGenericParameterType(writeMethod);
            collectionType = attrType;
          }
          code += generateCollectionCode(attrInfo.getDetail(), collectionType, componentType, valueName, tmpValueName);
          
        } else if (Map.class.isAssignableFrom(attrType)) { /* map type */
          
          Class<?> componentType = Reflections.getSecondGenericParameterType(writeMethod);
          if (componentType == null) {
            throw new RuntimeException("Cannot find type of Map");
          }
          
          Class<?> mapType = attrType;
          JsonType jsonType = JsonType.toJsonType(componentType);
          
          TypeImpl typeImpl = TypeImpl.getMapImpl(mapType);
          code += "Map " + tmpValueName + "_map = (Map)" + tmpValueName + ";\n";
          code += typeImpl.getInfClass().getName() + " " + valueName
                    + " = new " + typeImpl.getImplClass().getName() + "();\n";
          code += "Iterator " + tmpValueName + "_iter = " + tmpValueName + "_map.keySet().iterator();\n";
          code += "while(" + tmpValueName + "_iter.hasNext()){\n";
          code += "String _key = (String)" + tmpValueName + "_iter.next();\n";
          code += "Object _m1 = " + tmpValueName + "_map.get(_key);\n";
          if(jsonType == JsonType.OBJECT){
            //TODO: change this!!! it's bad...
            /* This one does the trick but it is going to be slow to convert json -> map -> json */
//            code += "System.out.println(\"=======>0:\"+zapposJson.toJson((Map)_m1));\n";
            code += "Object _m2 = zapposJson.fromJson(zapposJson.toJson((Map)_m1), "+componentType.getName()+".class);\n";
//            code += "System.out.println(\"=======>1:\"+_m1);\n";
//            code += "System.out.println(\"=======>2:\"+zapposJson.toJson((Map)_m1));\n";
          }else if(jsonType == JsonType.ARRAY){
            if(componentType.isArray()){
              componentType = componentType.getComponentType();
              code += generateArrayFromListCode(attrInfo.getDetail(), componentType, "_m2", "_m1");
            }else{
              throw new RuntimeException("Map of collection not support");
            }
          }else{
            code += generateTypeConversionCode(attrInfo.getDetail(), componentType, "_m2", "_m1");
          }
          code += valueName + ".put(_key, _m2);\n";
          code += "}\n";
          
        } else if(attrInfo.getDetail().getFormatterClass() != null){
            
            String formatterClassName = attrInfo.getDetail().getFormatterClass().getName();
            String formatterVar = Strings.randomAlphabetic(6)+"_fmt";
            code += formatterClassName + " " + formatterVar + " = new " + formatterClassName + "();\n";
            
            if(attrInfo.getDetail().getFormatterPattern() != null){
              code += formatterVar + ".setPattern(\"" + attrInfo.getDetail().getFormatterPattern() + "\");\n";
            }
            
            code += attrType.getName() + " " + valueName + " = (" + attrType.getName()
              + ")" + formatterVar + ".parse(zapposJson, String.valueOf(" + tmpValueName + "));\n";
            
        } else {
          
          code += generateTypeConversionCode(attrInfo.getDetail(), attrType, valueName, tmpValueName);
          
        }
        
        code += "__o." + writeMethodName + "(" + valueName + ");\n";
        code += "};\n";
        
      }

      code += "return __o;\n";

      pathAndCodes.add(new PathAndCode(path, code));
      
    }

    return pathAndCodes;

  }
  
  private void traverseObjectTree(Class<?> clazz, String paths[], int level,
      Map<String, TypeInfo> typeInfos) throws Exception {

    List<JsonBeanAttribute> attributes = beanIntrospector.getMutators(clazz);
    
    for (JsonBeanAttribute beanAttr: attributes) {

      Method writeMethod = beanAttr.getMethod();
      String jsonKey = beanAttr.getJsonKey();
      Class<?> attrType = writeMethod.getParameterTypes()[0];
      JsonType jsonType = JsonType.toJsonType(attrType);

      boolean arrayOfObject = false;
      if (attrType.isArray()) {
        if (JsonType.toJsonType(attrType.getComponentType()) == JsonType.OBJECT) {
          arrayOfObject = true;
          attrType = attrType.getComponentType();
        }
      }

      Class<?> collectionType = null;
      boolean collectionOfObject = false;
      if (Iterable.class.isAssignableFrom(attrType)) {
        Class<?> genericType = Reflections.getFirstGenericParameterType(writeMethod);
        if (genericType != null) {
          if (JsonType.toJsonType(genericType) == JsonType.OBJECT) {
            collectionType = attrType;
            collectionOfObject = true;
            attrType = genericType;
          }
        }else{
          throw new JsonException("Unknown type of collection");
        }
      }
 
      if (Map.class.isAssignableFrom(attrType)) {
        Class<?> genericTypes[] = Reflections.getGenericParameterTypes(writeMethod);
        if (genericTypes != null && genericTypes.length == 2) {
          if (genericTypes[0] != String.class) {
            throw new JsonException("Map key must be string");
          }
        }else{
          throw new JsonException("Unknown type of map");
        }
      }
      
      if ((jsonType == JsonType.OBJECT && !Map.class.isAssignableFrom(attrType)
          && zapposJson.getValueFormatter(attrType) == null) || arrayOfObject
          || collectionOfObject) {
        paths[level] = jsonKey;
        String path = getObjectAccessPath(paths, level);
        TypeInfo typeInfo = getTypeInfo(typeInfos, path, clazz);
        AttributeInfo attrInfo = typeInfo.addAttributeInfo(attrType, beanAttr);
        if (arrayOfObject) {
          attrInfo.setArrayType(1);
        } else if (collectionOfObject) {
          attrInfo.setArrayType(2).setCollectionType(collectionType);
        }
        traverseObjectTree(attrType, paths, level + 1, typeInfos);
      } else {
        String path = getObjectAccessPath(paths, level);
        TypeInfo typeInfo = getTypeInfo(typeInfos, path, clazz);
        typeInfo.addAttributeInfo(attrType, beanAttr);
      }
    }

  }

  /**
   * 
   * @param paths
   * @param level
   * @return
   */
  private String getObjectAccessPath(String paths[], int level) {

    if (level == 1)
      return "";
    String path = paths[1];
    for (int i = 2; i < level; i++) {
      path = path + "." + paths[i];
    }

    return path;

  }

  /**
   * Get the TypeInfo object from specified path or return the new one if it does not exist.
   * @param typeMaps
   * @param path
   * @param superType
   * @return
   */
  private TypeInfo getTypeInfo(Map<String, TypeInfo> typeMaps, String path, Class<?> superType) {

    TypeInfo typeInfo = typeMaps.get(path);
    if (typeInfo == null) {
      typeInfo = new TypeInfo(superType);
      typeMaps.put(path, typeInfo);
    }

    return typeInfo;

  }
  
  /**
   * 
   * @param collectionType
   * @param componentType
   * @param valueName
   * @param tmpValueName
   * @return
   */
  private String generateCollectionCode(JsonBeanAttribute beanAttr, Class<?> collectionType, Class<?> componentType,
      String valueName, String tmpValueName){
    
    if (componentType == null) {
      throw new RuntimeException("Cannot find type of Collection");
    }
    String code = "";
    TypeImpl typeImpl = TypeImpl.getIterableImpl(collectionType);
    code += "List " + tmpValueName + "_list = (List)" + tmpValueName + ";\n";
    code += typeImpl.getInfClass().getName() + " " + valueName
        + " = new " + typeImpl.getImplClass().getName() + "();\n";
    code += "for(int _i = 0; _i < " + tmpValueName + "_list.size(); _i++){\n";
    code += "Object _l1 = " + tmpValueName + "_list.get(_i);\n";
    code += generateTypeConversionCode(beanAttr, componentType, "_l2", "_l1");
    code += valueName + ".add(_l2);\n";
    code += "}\n";
    return code;
  }
  
  /**
   * 
   * @param attrType
   * @param valueName
   * @param tmpValueName
   * @return
   */
  private String generateArrayFromListCode(JsonBeanAttribute beanAttr, Class<?> attrType, 
      String valueName, String tmpValueName) {

    String code = "";
    code += "List " + tmpValueName + "_list = (List)" + tmpValueName + ";\n";
    code += attrType.getName() + " " + valueName + "[] = new "
            + attrType.getName() + "[" + tmpValueName + "_list.size()];\n";
    code += "for(int _i = 0; _i < " + tmpValueName + "_list.size(); _i++){\n";
    code += "Object _l1 = " + tmpValueName + "_list.get(_i);\n";
    code += generateTypeConversionCode(beanAttr, attrType, "_l2", "_l1");
    code += valueName + "[_i] = _l2;\n";
    code += "}\n";
    code += "";
    return code;

  }

  /**
   * 
   * @param attrType
   * @param valueName
   * @param tmpValueName
   * @return
   */
  private String generateTypeConversionCode(JsonBeanAttribute beanAttr, Class<?> attrType, 
      String valueName, String tmpValueName) {

    String valueDeclaration = null;

    if (attrType.isPrimitive()) {

      if (attrType == boolean.class) {
        valueDeclaration = "boolean @ = ((Boolean)@).booleanValue();\n";
      } else if (attrType == char.class) {
        valueDeclaration = "char @ = new Character((String)@).charValue();\n";
      } else if (attrType == byte.class) {
        valueDeclaration = "byte @ = Byte.parseByte((String)@);\n";
      } else if (attrType == short.class) {
        valueDeclaration = "short @ = Short.parseShort((String)@);\n";
      } else if (attrType == int.class) {
        valueDeclaration = "int @ = Integer.parseInt((String)@);\n";
      } else if (attrType == long.class) {
        valueDeclaration = "long @ = Long.parseLong((String)@);\n";
      } else if (attrType == float.class) {
        valueDeclaration = "float @ = Float.parseFloat((String)@);\n";
      } else if (attrType == double.class) {
        valueDeclaration = "double @ = Double.parseDouble((String)@);\n";
      }

    } else if (Number.class.isAssignableFrom(attrType)) {

      if (attrType == Byte.class || attrType == Short.class
          || attrType == Integer.class || attrType == Long.class
          || attrType == Float.class || attrType == Double.class
          || attrType == BigDecimal.class || attrType == BigInteger.class) {
        valueDeclaration = attrType.getName() + " @ = new " + attrType.getName() + "((String)@);\n";
      } else {
        // TODO: make it better
        valueDeclaration = attrType.getName() + " @ = (" + attrType.getName()
            + ")zapposJson.getValueFormatter(" + attrType.getName()
            + ".class).parse(zapposJson, (String)@);\n";
      }

    } else if (attrType == Boolean.class) {
      /* No need to parse. The type is already Boolean */
      valueDeclaration = "Boolean @ =  (Boolean)@;\n";

    } else if (attrType == Character.class) {
      valueDeclaration = "Character @ = new Character((String)@);\n";

    } else if (attrType == String.class) {
      /* No need to parse. The type is already String */
      valueDeclaration = "String @ =  (String)@;\n";
    } else if (attrType.isEnum()){
      valueDeclaration = attrType.getName() + " @ = " + attrType.getCanonicalName();
      if(beanAttr.getEnumValue() == null || beanAttr.getEnumValue() == EnumValue.STRING){ 
        valueDeclaration += ".valueOf(String.valueOf(@));\n";
      }else{
        valueDeclaration += ".values()[Integer.parseInt((String)@)];\n";
      }
    } else {
      // object?
      if (zapposJson.getValueFormatter(attrType) != null) {
        valueDeclaration = attrType.getName() + " @ = (" + attrType.getName()
            + ")zapposJson.getValueFormatter(" + attrType.getName()
            + ".class).parse(zapposJson, String.valueOf(@));\n";
      } else {
        valueDeclaration = attrType.getName() + " @ = (" + attrType.getName() + ")@;\n";
      }

    }

    return Strings.format(valueDeclaration, valueName, tmpValueName);
  }
  
  /**
   * POJO bean storing attribute path and generated Java code.
   * @author hussachai
   *
   */
  static class PathAndCode {
    
    /**
     * Attribute path. The nested property name that is separated by dot notation.
     */
    private String path;

    /**
     * Generated Java code for reading a value from JSON to a target type.
     */
    private String code;

    public PathAndCode(String path, String code) {
      this.path = path;
      this.code = code;
    }

    public String getPath() {
      return path;
    }

    public String getCode() {
      return code;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((path == null) ? 0 : path.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      PathAndCode other = (PathAndCode) obj;
      if (path == null) {
        if (other.path != null)
          return false;
      } else if (!path.equals(other.path))
        return false;
      return true;
    }

  }

  /**
   * 
   * @author hussachai
   *
   */
  static class TypeInfo {

    private Class<?> type;

    private List<AttributeInfo> attrInfos = new ArrayList<>();

    public TypeInfo(Class<?> type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return type.getSimpleName() + attrInfos;
    }

    public Class<?> getType() {
      return type;
    }

    public AttributeInfo addAttributeInfo(Class<?> type, JsonBeanAttribute detail) {
      AttributeInfo attrMapping = new AttributeInfo(type, detail);
      attrInfos.add(attrMapping);
      return attrMapping;
    }
    
    public List<AttributeInfo> getAttributeInfos() {
      return attrInfos;
    }

  }

  /**
   * 
   * @author hussachai
   *
   */
  static class AttributeInfo {

    private Class<?> attrType;

    /**
     * 0 for not an array, 1 for native, 2 for
     * collection
     */
    private int arrayType = 0; 
    
    private Class<?> collectionType;
    
    private JsonBeanAttribute detail;
    
    public AttributeInfo(Class<?> attrType, JsonBeanAttribute detail) {
      this.attrType = attrType;
      this.detail = detail;
    }

    @Override
    public String toString() {
      return attrType.getSimpleName() + "#" + detail.toString() + "->" + detail.getJsonKey();
    }

    public JsonBeanAttribute getDetail(){
      return detail;
    }
    
    public AttributeInfo setArrayType(int arrayType) {
      this.arrayType = arrayType;
      return this;
    }

    public int getArrayType() {
      return arrayType;
    }

    public AttributeInfo setCollectionType(Class<?> collectionType) {
      this.collectionType = collectionType;
      return this;
    }

    public Class<?> getCollectionType() {
      return collectionType;
    }

    public Class<?> getAttributeType() {
      return attrType;
    }
    
  }
}
