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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JavaTimestampFormatter extends AbstractValueFormatter<Timestamp> {

  @Override
  public Timestamp cast(Object obj) {
    return Timestamp.class.cast(obj);
  }
  
  @Override
  public String format(ZapposJson zapposJson, Timestamp object) {
    if(getPattern() != null){
      return toJsonValue(zapposJson, new SimpleDateFormat(getPattern()).format(object));
    }
    return String.valueOf(object.getTime());
  }

  @Override
  public Timestamp parse(ZapposJson zapposJson, String string) throws Exception {
    if(getPattern() != null){
      return new Timestamp(new SimpleDateFormat(getPattern()).parse(string).getTime());
    }
    return new Timestamp(Long.parseLong(string));
  }

  @Override
  public ValueFormatter<Timestamp> newInstance() {
    return new JavaTimestampFormatter();
  }
  
}
