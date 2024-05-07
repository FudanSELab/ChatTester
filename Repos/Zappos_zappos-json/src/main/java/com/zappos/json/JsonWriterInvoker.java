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

import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonWriterInvoker {

  private Method writerMethod;
  private Object jsonWriter;

  public JsonWriterInvoker(Class<?> dataClass, Object jsonWriter) {
    
    try {
      
      this.writerMethod = jsonWriter.getClass().getDeclaredMethod("writeJson",
          dataClass, Writer.class);
      
    } catch (NoSuchMethodException | SecurityException e) {
      throw new RuntimeException(e);
    }
    
    this.jsonWriter = jsonWriter;
  }
  
  public void writeJson(Object data, Writer writer) {
    
    try {
      
      writerMethod.invoke(jsonWriter, data, writer);
      
    } catch(InvocationTargetException e){
      
      throw new JsonException(e.getTargetException());
      
    } catch (IllegalAccessException | IllegalArgumentException e) {
      
      throw new RuntimeException(e);
    }
  }
}
