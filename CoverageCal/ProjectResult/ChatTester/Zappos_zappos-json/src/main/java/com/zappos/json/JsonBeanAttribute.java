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

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.zappos.json.annot.JsonEnum.EnumValue;
import com.zappos.json.format.ValueFormatter;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonBeanAttribute {
  
  private Method method;
  
  private Field field;

  private String attributeKey;
  
  /**
   * @JsonKey
   */
  private String jsonKey;
  
  private Class<? extends ValueFormatter<?>> formatterClass;
  
  private String formatterPattern;
  
  private EnumValue enumValue;
  
  public JsonBeanAttribute(){}
  
  public JsonBeanAttribute(Method method, Field field, String attributeKey) {
    this.method = method;
    this.field = field;
    this.attributeKey = attributeKey;
    this.jsonKey = attributeKey;
  }

  @Override
  public String toString(){
    if(field != null){
      return field.getName();
    }
    return method.getName();
  }
  
  public Method getMethod() {
    return method;
  }
  
  public Field getField() {
    return field;
  }
  
  public String getAttributeKey() {
    return attributeKey;
  }

  public JsonBeanAttribute setAttributeKey(String attributeKey) {
    this.attributeKey = attributeKey;
    return this;
  }

  public String getJsonKey() {
    return jsonKey;
  }

  public JsonBeanAttribute setJsonKey(String jsonKey) {
    this.jsonKey = jsonKey;
    return this;
  }

  public Class<? extends ValueFormatter<?>> getFormatterClass() {
    return formatterClass;
  }

  public JsonBeanAttribute setFormatterClass(
      Class<? extends ValueFormatter<?>> formatterClass) {
    this.formatterClass = formatterClass;
    return this;
  }

  public String getFormatterPattern() {
    return formatterPattern;
  }

  public JsonBeanAttribute setFormatterPattern(String formatterPattern) {
    this.formatterPattern = formatterPattern;
    return this;
  }

  public EnumValue getEnumValue() {
    return enumValue;
  }

  public JsonBeanAttribute setEnumValue(EnumValue enumValue) {
    this.enumValue = enumValue;
    return this;
  }
  
}
