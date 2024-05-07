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

import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonReaderInvoker {

  private ZapposJson zapposJson;

  private Constructor<?> constructorWithReader;

  private Method parseMethod;

  public JsonReaderInvoker(ZapposJson jacinda, Class<?> readerClass)
      throws Exception {
    
    this.zapposJson = jacinda;
    this.constructorWithReader = readerClass.getConstructor(ZapposJson.class, Reader.class);
    parseMethod = readerClass.getDeclaredMethod("parse");
  }

  @SuppressWarnings("unchecked")
  public <T> T readJson(Reader reader, Class<T> clazz) {
    
    try {
      
      Object jsonReader = constructorWithReader.newInstance(zapposJson, reader);
      return (T) parseMethod.invoke(jsonReader);
      
    } catch (InvocationTargetException e) {
      
      throw new JsonException(e.getTargetException());
      
    } catch (InstantiationException | IllegalAccessException
        | IllegalArgumentException e) {
      
      throw new RuntimeException(e);
    }
  }

}
