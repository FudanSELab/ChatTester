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

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JavaDateFormatter extends AbstractValueFormatter<Date> {
  
  @Override
  public Date cast(Object obj) {
    return Date.class.cast(obj);
  }
  
  @Override
  public String format(ZapposJson zapposJson, Date object) {
    if(getPattern() != null){
      return toJsonValue(zapposJson, new SimpleDateFormat(getPattern()).format(object));
    }
    return String.valueOf(((Date) object).getTime());/* milliseconds */
  }
  
  @Override
  public Date parse(ZapposJson zapposJson, String string) throws Exception {
    if(getPattern() != null){
      return new SimpleDateFormat(getPattern()).parse(string);
    }
    return new Date(Long.parseLong(string));
  }

  @Override
  public ValueFormatter<Date> newInstance() {
    return new JavaDateFormatter();
  }
  
}
