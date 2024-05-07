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

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JavaTimeInstantFormatter extends AbstractValueFormatter<Instant> {
  
  
  /**
   * This class is thread-safe
   */
  private DateTimeFormatter formatter = null;
  
  @Override
  public Instant cast(Object obj) {
    return Instant.class.cast(obj);
  }
  
  @Override
  public String format(ZapposJson zapposJson, Instant object) {
    if(formatter != null){
      return toJsonValue(zapposJson, formatter.format(object));
    }
    return String.valueOf(object.toEpochMilli());
  }
  
  @Override
  public Instant parse(ZapposJson zapposJson, String string) throws Exception {
    if(formatter != null){
      return Instant.from(formatter.parse(string));
    }
    return Instant.ofEpochMilli(Long.parseLong(string));
  }

  @Override
  public ValueFormatter<Instant> setPattern(String pattern) {
    super.setPattern(pattern);
    formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.systemDefault());
    return this;
  }
  
  @Override
  public ValueFormatter<Instant> newInstance() {
    return new JavaTimeInstantFormatter();
  }
  
  
}
