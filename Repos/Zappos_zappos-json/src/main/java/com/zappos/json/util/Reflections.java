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

package com.zappos.json.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public final class Reflections {

  
  public static boolean classPresent(String className) {
    ClassLoader thisClassLoader = Reflections.class.getClassLoader();
    try {
      Class.forName(className, false, thisClassLoader);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

  /**
   * Recursively find the field by name up to the top of class hierarchy.
   * 
   * @param clazz the class object
   * @param fieldName declared field name of specified class
   * @return the field object
   */
  public static Field getField(Class<?> clazz, String fieldName)
      throws NoSuchFieldException {
    if (clazz == Object.class) {
      return null;
    }
    try {
      Field field = clazz.getDeclaredField(fieldName);
      return field;
    } catch (NoSuchFieldException e) {
      return getField(clazz.getSuperclass(), fieldName);
    }
  }

  public static boolean hasAnnotation(Field field,
      Class<? extends Annotation> annotationClass) {
    if (field != null) {
      return field.isAnnotationPresent(annotationClass);
    }
    return false;
  }

  public static boolean hasAnnotation(Method method,
      Class<? extends Annotation> annotationClass) {
    if (method != null) {
      return method.isAnnotationPresent(annotationClass);
    }
    return false;
  }

  public static boolean hasAnnotation(Method method, Field field,
      Class<? extends Annotation> annotationClass) {
    return hasAnnotation(field, annotationClass)
        || hasAnnotation(method, annotationClass);
  }
  
  public static <T extends Annotation> T getAnnotation(Method method,
      Field field, Class<T> annotationClass) {
    T annot = null;
    if (field != null) {
      annot = field.getAnnotation(annotationClass);
    }
    if (annot == null && method != null) {
      annot = method.getAnnotation(annotationClass);
    }
    return annot;
  }

  public static Class<?> getFirstGenericParameterType(Method method) {
    Class<?> types[] = getGenericParameterTypes(method);
    if (types != null && types.length > 0) {
      return types[0];
    }
    return null;
  }

  public static Class<?> getSecondGenericParameterType(Method method) {
    Class<?> types[] = getGenericParameterTypes(method);
    if (types != null && types.length > 1) {
      return types[1];
    }
    return null;
  }

  public static Class<?>[] getGenericParameterTypes(Method method) {
    Type argTypes[] = method.getGenericParameterTypes();
    for (Type argType : argTypes) {
      if (argType instanceof ParameterizedType) {
        Type typeArgs[] = ((ParameterizedType) argType)
            .getActualTypeArguments();
        if (typeArgs.length > 0) {
          List<Class<?>> genericTypes = new ArrayList<>();
          for (Type typeArg : typeArgs) {
            if (typeArg instanceof Class<?>) {
              genericTypes.add((Class<?>) typeArg);
            }
          }
          return genericTypes.toArray(new Class[0]);
        }
      }
    }
    return null;
  }

  public static Class<?> getFirstGenericType(Field field) {
    Class<?> types[] = getGenericTypes(field);
    if (types != null && types.length > 0) {
      return types[0];
    }
    return null;
  }

  public static Class<?> getSecondGenericType(Field field) {
    Class<?> types[] = getGenericTypes(field);
    if (types != null && types.length > 1) {
      return types[1];
    }
    return null;
  }

  public static Class<?>[] getGenericTypes(Field field) {
    Type fieldType = field.getGenericType();
    if (fieldType instanceof ParameterizedType) {
      Type typeArgs[] = ((ParameterizedType) fieldType)
          .getActualTypeArguments();
      if (typeArgs.length > 0) {
        List<Class<?>> genericTypes = new ArrayList<>();
        for (Type typeArg : typeArgs) {
          if (typeArg instanceof Class<?>) {
            genericTypes.add((Class<?>) typeArg);
          }
        }
        return genericTypes.toArray(new Class[0]);
      }
    }
    return null;
  }
  
}
