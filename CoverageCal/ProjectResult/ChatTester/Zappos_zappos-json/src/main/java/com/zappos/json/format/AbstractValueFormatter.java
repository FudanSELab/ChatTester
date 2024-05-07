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

package com.zappos.json.format;

import java.io.IOException;
import java.io.StringWriter;

import com.zappos.json.JsonWriter;
import com.zappos.json.ZapposJson;


/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public abstract class AbstractValueFormatter<T> implements ValueFormatter<T>{

  private String pattern;
  
  private boolean jsString = true;
  
  @Override
  public String formatObject(ZapposJson zapposJson, Object object){
    return format(zapposJson, cast(object));
  }
  
  @Override
  public ValueFormatter<T> setPattern(String pattern) {
    this.pattern = pattern;
    return this;
  }
  
  public String getPattern(){
    return pattern;
  }

  /**
   * 
   * @param zapposJson the instance of @{../ZapposJson}
   * @param value JSON value in string format
   * @return the string representing JSON value
   */
  public String toJsonValue(ZapposJson zapposJson, String value){
    if(jsString){
      StringWriter writer = new StringWriter();
      try{
        JsonWriter.writeString(zapposJson, value, writer);
      }catch(IOException e){}
      return writer.toString();
    }else{
      return value;
    }
  }
  
  public void setJsString(boolean jsString) {
    this.jsString = jsString;
  }
  
  /**
   * 
   * @return boolean indicating string or else
   */
  public boolean isJsString(){
    return jsString;
  }
  
}
