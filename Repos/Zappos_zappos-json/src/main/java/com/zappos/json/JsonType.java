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

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public enum JsonType {

  NUMBER, STRING, BOOLEAN, ARRAY, OBJECT;

  public static JsonType toJsonType(Class<?> clazz) {
    if (isStringType(clazz)) {
      return STRING;
    } else if (isNumberType(clazz)) {
      return NUMBER;
    } else if (isBooleanType(clazz)) {
      return BOOLEAN;
    } else if (isArrayType(clazz)) {
      return ARRAY;
    }
    return JsonType.OBJECT;
  }

  public static boolean isNumberType(Class<?> clazz) {
    if (Number.class.isAssignableFrom(clazz)) {
      return true;
    } else if (clazz.isPrimitive()) {
      return clazz != boolean.class && clazz != char.class;
    }
    return false;
  }

  public static boolean isStringType(Class<?> clazz) {
    return clazz == String.class;
  }

  public static boolean isBooleanType(Class<?> clazz) {
    return clazz == boolean.class || Boolean.class.isAssignableFrom(clazz);
  }

  public static boolean isArrayType(Class<?> clazz) {
    return clazz.isArray() || Iterable.class.isAssignableFrom(clazz);
  }
}
