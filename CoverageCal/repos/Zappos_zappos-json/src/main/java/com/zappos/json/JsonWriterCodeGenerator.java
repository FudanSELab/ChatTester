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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.zappos.json.annot.JsonEnum.EnumValue;
import com.zappos.json.format.ValueFormatter;
import com.zappos.json.util.Reflections;
import com.zappos.json.util.Strings;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewMethod;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonWriterCodeGenerator {
  
  private final Map<Class<?>, JsonWriterInvoker> JSON_WRITER_INVOKERS = new ConcurrentHashMap<>();
  
  private ZapposJson zapposJson;
  
  private JsonBeanIntrospector beanIntrospector;
  
  public JsonWriterCodeGenerator(ZapposJson zapposJson, JsonBeanIntrospector beanIntrospector){
    this.zapposJson = zapposJson;
    this.beanIntrospector = beanIntrospector;
  }
  
  protected JsonWriterInvoker getWriter(Class<?> clazz){
    return JSON_WRITER_INVOKERS.get(clazz);
  }
  
  protected synchronized void deregisterAll(){
    JSON_WRITER_INVOKERS.clear();
  }
  
  protected void deregister(Class<?> clazz){
    synchronized(clazz){
      JSON_WRITER_INVOKERS.remove(clazz);
    }
  }
  
  protected JsonWriterInvoker registerWriter(Class<?> clazz)
      throws Exception {
    synchronized(clazz){
      JsonWriterInvoker writerInvoker = JSON_WRITER_INVOKERS.get(clazz);
      if (writerInvoker != null) {
        return writerInvoker;
      }
      ClassPool classPool = ClassPool.getDefault();
      classPool.importPackage("java.util");
      classPool.importPackage("java.math");
      CtClass jsonCtClass = classPool.get(JsonWriter.class.getName());
      String randomName = Strings.randomAlphabetic(16);
      jsonCtClass.setName("com.zappos.json."+randomName + "_JSON_Writer");
  
      Map<String, String> fieldVars = new HashMap<>();
      StringBuilder methodBody = new StringBuilder();
      methodBody.append("public void writeJson (").append(clazz.getName())
          .append(" __o, java.io.Writer writer) throws Exception {\n")
          .append("if(__o == null) return;\n");
      
      generateJsonWriterBody(clazz, methodBody, fieldVars);
      
      methodBody.append("}");
      for (Map.Entry<String, String> fieldEntry : fieldVars.entrySet()) {
        jsonCtClass.addField(
            CtField.make("public static final String " + fieldEntry.getKey()
                + " = " + fieldEntry.getValue() + ";", jsonCtClass));
      }
  
      zapposJson.debug("\nWriter code for \"@\"\n=========\n@\n=========\n", clazz, methodBody);
      jsonCtClass.addMethod(CtNewMethod.make(methodBody.toString(), jsonCtClass));
      Class<?> jsonClass = jsonCtClass.toClass();
      Object jsonWriter = jsonClass.getDeclaredConstructor(ZapposJson.class).newInstance(zapposJson);
      writerInvoker = new JsonWriterInvoker(clazz, jsonWriter);
      JSON_WRITER_INVOKERS.put(clazz, writerInvoker);
      
      return writerInvoker;
    }
  }
  
  private void generateJsonWriterBody(Class<?> clazz, StringBuilder methodBody,
      Map<String, String> fieldVars) throws Exception {
    
    methodBody.append("writer.write(CONST_OPEN_OBJECT);");

    List<JsonBeanAttribute> beanAttrs = beanIntrospector.getAccessors(clazz);
    
    int j = beanAttrs.size() - 1;
    for (int i = 0; i <= j; i++) {

      JsonBeanAttribute beanAttr = beanAttrs.get(i);
      Method method = beanAttr.getMethod();
      String methodName = method.getName();
      String jsonKey = beanAttr.getJsonKey();
      
      String jsonKeyField = "KEY_" + jsonKey;
      fieldVars.put(jsonKeyField, "\"\\\"" + jsonKey + "\\\":\"");
      /* we serialize from bean, no need to escape json key */
      methodBody.append("\nwriter.write(").append(jsonKeyField).append(");\n");
      
      Class<?> returnType = method.getReturnType();
      
      String varName = "__" + methodName;
      
      if(returnType.isArray()){
        methodBody.append(returnType.getComponentType().getName()).append(" ")
          .append(varName).append("[]");
      }else{
        methodBody.append(returnType.getName()).append(" ").append(varName);
      }
      
      methodBody.append(" = ").append("__o.").append(methodName).append("();\n");
      
      if(!returnType.isPrimitive()){
        methodBody.append("if(").append(varName).append(" != null){\n");
      }
      
      generateWriterCode(beanAttr, methodBody, returnType, varName);
      
      if(!returnType.isPrimitive()){
        methodBody.append("} else {\n");
        methodBody.append("writer.write(CONST_NULL);\n");
        methodBody.append("}\n");
      }
      
      if (i != j) methodBody.append("writer.write(CONST_COMMA);\n");
      
    }

    methodBody.append("writer.write(CONST_CLOSE_OBJECT);\n");

  }
  
  private void generateWriterCode(JsonBeanAttribute beanAttr, StringBuilder methodBody, Class<?> attrType, String varName){
    
    if(beanAttr.getFormatterClass() != null){
      
      String formatterClassName = beanAttr.getFormatterClass().getName();
      String formatterVar = Strings.randomAlphabetic(6)+"_fmt";
      
      methodBody.append(formatterClassName).append(" ").append(formatterVar).append(" = new ")
        .append(formatterClassName).append("();\n");
      
      if(beanAttr.getFormatterPattern() != null){
        methodBody.append(formatterVar).append(".setPattern(\"")
          .append(beanAttr.getFormatterPattern()).append("\");\n");
      }
      
      methodBody.append("writer.write(").append(formatterVar).append(".format(zapposJson, (")
        .append(attrType.getName()).append(")").append(varName).append("));\n");
    
    } else if(zapposJson.getValueFormatter(attrType) != null){
      
      String formatterVar = Strings.randomAlphabetic(6)+"_fmt";
      methodBody.append(ValueFormatter.class.getName()).append(" ").append(formatterVar).append(" = zapposJson.getValueFormatter(")
        .append(attrType.getName()).append(".class);\n");
      methodBody.append("writer.write(").append(formatterVar).append(".format(zapposJson, (")
        .append(attrType.getName()).append(")").append(varName).append("));\n");
      
    } else if (attrType == String.class) {
      
      methodBody.append("writeString(zapposJson, ").append(varName).append(", writer);\n");
    
    } else if (attrType == Character.class || attrType == char.class){
      
      methodBody.append("writeString(zapposJson, new String(").append(varName).append("), writer);\n");
      
    } else if (attrType.isPrimitive() || Number.class.isAssignableFrom(attrType) || attrType == Boolean.class){
      
      methodBody.append("writer.write(String.valueOf(").append(varName).append("));\n");
      
    } else if (attrType.isArray()) {
      
      if(attrType.getComponentType() == char.class){
        methodBody.append("writeString(zapposJson, new String(").append(varName).append("), writer);\n");
      }else if(attrType.getComponentType() == byte.class){
        methodBody.append("writeBase64String(zapposJson, ").append(varName).append(", writer);\n");
      }else{
        generateArrayCode(beanAttr, methodBody, attrType.getComponentType(), varName);
      }
    } else if (Map.class.isAssignableFrom(attrType)){
      
      Class<?> valueType = Reflections.getSecondGenericType(beanAttr.getField());
      
      if(valueType == null){
        throw new JsonException("Unknown map value type");
      }
      
      generateMapCode(beanAttr, methodBody, valueType, varName);
    
    } else if (Iterable.class.isAssignableFrom(attrType)){
      
      Class<?> valueType = Reflections.getFirstGenericType(beanAttr.getField());
      
      if(List.class.isAssignableFrom(attrType)){
          generateListCode(beanAttr, methodBody, valueType, varName);
        }else{
          generateIterableCode(beanAttr, methodBody, valueType, varName);
        }
    } else if(attrType.isEnum()){
      if(beanAttr.getEnumValue() != null){
        if(beanAttr.getEnumValue() == EnumValue.ORDINAL){
          methodBody.append("writer.write(String.valueOf(").append(varName).append(".ordinal()));\n");
          return;
        }
      }
      methodBody.append("writer.write(CONST_DOUBLE_QUOTE);\n");
      methodBody.append("writer.write(").append(varName).append(".name());\n");
      methodBody.append("writer.write(CONST_DOUBLE_QUOTE);\n");
    } else {
      
      methodBody.append("zapposJson.toJson(").append(varName).append(", writer);\n");
      
    }
  }
  
  private void generateIterableCode(JsonBeanAttribute beanAttr, StringBuilder methodBody, Class<?> valueType, String varName){
    
    String iterVarName = Strings.randomAlphabetic(4) + "_iter";
    
    methodBody.append("writer.write(CONST_OPEN_ARRAY);\n");
    methodBody.append("Iterator ").append(iterVarName).append(" = ").append(varName).append(".iterator();\n");
    methodBody.append("if(").append(iterVarName).append(".hasNext()){\n");
    methodBody.append("  boolean __hasLast = false;\n");
    methodBody.append("  ").append(valueType.getName()).append(" __value = (").append(valueType.getName())
      .append(")").append(iterVarName).append(".next();\n");
    methodBody.append("  do{\n");
    generateWriterCode(beanAttr, methodBody, valueType, "__value");
    methodBody.append("    if(__hasLast = ").append(iterVarName).append(".hasNext()){\n");
    methodBody.append("      __value = (").append(valueType.getName()).append(")").append(iterVarName).append(".next();\n");
    methodBody.append("      writer.write(CONST_COMMA);\n");
    methodBody.append("    }\n");
    methodBody.append("  }while(").append(iterVarName).append(".hasNext());\n");
    methodBody.append("  if(__hasLast) {");
    generateWriterCode(beanAttr, methodBody, valueType, "__value");
    methodBody.append("  }\n");
    methodBody.append("}\n");
    methodBody.append("writer.write(CONST_CLOSE_ARRAY);\n");
    
  }
  
  private void generateListCode(JsonBeanAttribute beanAttr, StringBuilder methodBody, Class<?> valueType, String varName){
    
    String jVarName = Strings.randomAlphabetic(4) + "_j";
    String valueVarName = Strings.randomAlphabetic(4) + "_val";
    
    methodBody.append("writer.write(CONST_OPEN_ARRAY);\n");
    methodBody.append("int ").append(jVarName).append(" = ").append(varName).append(".size() - 1;\n");
    methodBody.append(valueType.getName()).append(" ").append(valueVarName).append(" = null;\n");
    methodBody.append("for(int __i = 0; __i < ").append(jVarName).append("; __i++){\n");
    methodBody.append("  ").append(valueVarName).append(" = (")
      .append(valueType.getName()).append(")").append(varName).append(".get(__i);\n");
    generateWriterCode(beanAttr, methodBody, valueType, valueVarName);
    methodBody.append("writer.write(CONST_COMMA);\n");
    methodBody.append("}\n");
    methodBody.append("if(").append(jVarName).append(" > -1){\n");
    methodBody.append("  ").append(valueVarName).append(" = (")
      .append(valueType.getName()).append(")").append(varName).append(".get(").append(jVarName).append(");\n");
    generateWriterCode(beanAttr, methodBody, valueType, valueVarName);
    methodBody.append("}\n");
    methodBody.append("writer.write(CONST_CLOSE_ARRAY);\n");
  }
  
  private void generateMapCode(JsonBeanAttribute beanAttr, StringBuilder methodBody, Class<?> valueType, String varName) {
    
    String iterVarName = Strings.randomAlphabetic(4) + "_iter";
    methodBody.append("writer.write(CONST_OPEN_OBJECT);\n");
    
    methodBody.append("Iterator ").append(iterVarName).append(" = ").append(varName)
      .append(".entrySet().iterator();\n");
    methodBody.append("if(").append(iterVarName).append(".hasNext()){\n");
    methodBody.append("String __mapKey = null;\n");
    methodBody.append("boolean __hasLast = false;\n");
    methodBody.append("java.util.Map.Entry __entry = (java.util.Map.Entry)").append(iterVarName).append(".next();\n");
    methodBody.append("do{\n");
    methodBody.append("__mapKey = (String)__entry.getKey();\n");
    
    if(valueType.isArray()){
      methodBody.append(valueType.getComponentType().getName()).append(" __mapValue[] = (")
        .append(valueType.getComponentType().getName()).append("[])__entry.getValue();\n");
    }else{
      methodBody.append(valueType.getName()).append(" __mapValue = (")
        .append(valueType.getName()).append(")__entry.getValue();\n");
    }
    methodBody.append("writeString(zapposJson, __mapKey, writer);\n");
    methodBody.append("writer.write(CONST_COLON);\n");
    generateWriterCode(beanAttr, methodBody, valueType, "__mapValue");
    methodBody.append("if(__hasLast = ").append(iterVarName).append(".hasNext()){\n");
    methodBody.append("__entry = (java.util.Map.Entry)").append(iterVarName).append(".next();\n");
    methodBody.append("writer.write(CONST_COMMA);\n");
    methodBody.append("}\n");
    methodBody.append("}while(").append(iterVarName).append(".hasNext());\n");
    methodBody.append("if(__hasLast) {\n");
    methodBody.append("__mapKey = (String)__entry.getKey();\n");
    if(valueType.isArray()){
      methodBody.append(valueType.getComponentType().getName()).append(" __mapValue[] = (")
        .append(valueType.getComponentType().getName()).append("[])__entry.getValue();\n");
    }else{
      methodBody.append(valueType.getName()).append(" __mapValue = (")
        .append(valueType.getName()).append(")__entry.getValue();\n");
    }
    methodBody.append("writeString(zapposJson, __mapKey, writer);\n");
    methodBody.append("writer.write(CONST_COLON);\n");
    generateWriterCode(beanAttr, methodBody, valueType, "__mapValue");
    methodBody.append("}\n");
    methodBody.append("}\n");
    
    methodBody.append("writer.write(CONST_CLOSE_OBJECT);\n");
  }
  
  private void generateArrayCode(JsonBeanAttribute beanAttr,  StringBuilder methodBody, Class<?> componentType, String varName) {
    
    methodBody.append("writer.write(CONST_OPEN_ARRAY);\n");
    String jVarName = Strings.randomAlphabetic(4) + "_j";
    String valueVarName = Strings.randomAlphabetic(4) + "_val";
    
    methodBody.append("int ").append(jVarName).append(" = ").append(varName).append(".length - 1;\n");
    methodBody.append("for (int __i = 0; __i < ").append(jVarName).append("; __i++) {\n");
    methodBody.append("  ").append(componentType.getName()).append(" ").append(valueVarName).append(" = (")
      .append(componentType.getName()).append(")").append(varName).append("[__i];\n");
    generateWriterCode(beanAttr, methodBody, componentType, valueVarName);
    methodBody.append("  writer.write(CONST_COMMA);\n");
    methodBody.append("}\n");
    methodBody.append("if (").append(jVarName).append(" > -1) { \n");
    methodBody.append("  ").append(componentType.getName()).append(" ").append(valueVarName).append(" = (")
      .append(componentType.getName()).append(")").append(varName).append("[").append(jVarName).append("];\n");
    generateWriterCode(beanAttr, methodBody, componentType, valueVarName);
    methodBody.append("}\n");
    methodBody.append("writer.write(CONST_CLOSE_ARRAY);\n");
    
  }
  
}
