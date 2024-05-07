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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zappos.json.annot.JsonEnum;
import com.zappos.json.annot.JsonFormat;
import com.zappos.json.annot.JsonIgnore;
import com.zappos.json.annot.JsonKey;
import com.zappos.json.format.NoOpValueFormatter;
import com.zappos.json.format.ValueFormatter;
import com.zappos.json.util.Reflections;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonBeanIntrospector {
  
  private ZapposJson jacinda;
  
  public JsonBeanIntrospector(ZapposJson jacinda){
    this.jacinda = jacinda;
  }
  
  @SuppressWarnings("unchecked")
  private List<JsonBeanAttribute> getAccessorsOrMutators(Class<?> clazz, boolean accessor){
    
    List<JsonBeanAttribute> attributes = new ArrayList<>();
    try {
      for (PropertyDescriptor propertyDescriptor : Introspector
          .getBeanInfo(clazz, Object.class).getPropertyDescriptors()) {
        
        /*
         * getReadMethod can be null if there is no getter but only setter
         */
        Method method = null;
        Class<?> attrType = null; 
        if(accessor) {
          method = propertyDescriptor.getReadMethod();
          if(method == null) continue;
          attrType = method.getReturnType();
        }else{
          method = propertyDescriptor.getWriteMethod();
          if(method == null) continue;
          if(method.getParameterTypes().length < 1){
            throw new RuntimeException("Invalid writer method " + method.getName() +" - argument required");
          }
          attrType = method.getParameterTypes()[0];
        }
        /*
         * field can be null when it cannot find matching field 
         */
        String fieldName = propertyDescriptor.getName();
        Field field = Reflections.getField(clazz, fieldName);
        if (Reflections.hasAnnotation(method, field, JsonIgnore.class)) {
          continue;
        }
        String methodName = method.getName();
        String attributeKey = null;
        if(accessor){
          int isOrGet = methodName.startsWith("is") ? 2 : 3;
          char name[] = methodName.substring(isOrGet).toCharArray();
          name[0] = Character.toLowerCase(name[0]);
          attributeKey = new String(name);
        }else{
          char name[] = methodName.substring(3).toCharArray();
          name[0] = Character.toLowerCase(name[0]);
          attributeKey = new String(name);
        }
        
        JsonBeanAttribute attribute = new JsonBeanAttribute(method, field, attributeKey);
        
        JsonKey jsonKeyAnnot = Reflections.getAnnotation(method, field, JsonKey.class);
        if (jsonKeyAnnot != null) {
          if (!jsonKeyAnnot.value().equals(JsonKey.DEFAULT_KEY)) {
            attribute.setJsonKey(jsonKeyAnnot.value());
          }
        }
        
        /* JsonFormat */
        JsonFormat jsonFormatAnnot = Reflections.getAnnotation(method, field, JsonFormat.class);
        if(jsonFormatAnnot != null){
          JsonType attrJsonType = JsonType.toJsonType(attrType);
          if(attrJsonType != JsonType.OBJECT || Map.class.isAssignableFrom(attrType)){
            throw new JsonException("invalid annotated type: " + attrType);
          }
          Class<? extends ValueFormatter<?>> formatterClass = null;
          String pattern = jsonFormatAnnot.value();
          formatterClass = jsonFormatAnnot.formatter();
          if(formatterClass == NoOpValueFormatter.class){
            //TODO: validate the formatter and type
            ValueFormatter<?> formatter = jacinda.getValueFormatter(attrType);
            if(formatter != null){
              formatterClass = (Class<? extends ValueFormatter<?>>)formatter.getClass();
            }
          }
          attribute.setFormatterClass(formatterClass);
          if(!pattern.equals("")){
            attribute.setFormatterPattern(pattern);
          }
        }
        
        /* JsonEnum */
        JsonEnum jsonEnumAnnot = Reflections.getAnnotation(method, field, JsonEnum.class);
        if(jsonEnumAnnot != null){
          if(!attrType.isEnum()){//TODO: support list, and array
            throw new JsonException("Annotated type of JsonEnum must be enum.");
          }
          attribute.setEnumValue(jsonEnumAnnot.value());
        }
        
        attributes.add(attribute);
      }
    } catch (ReflectiveOperationException | IntrospectionException e) {
      throw new JsonException("bean introspection failed", e);
    }
    return attributes;
  }
  
  public List<JsonBeanAttribute> getMutators(Class<?> clazz){
    return getAccessorsOrMutators(clazz, false);
  }
  
  public List<JsonBeanAttribute> getAccessors(Class<?> clazz){
    return getAccessorsOrMutators(clazz, true);
  }
  
}
