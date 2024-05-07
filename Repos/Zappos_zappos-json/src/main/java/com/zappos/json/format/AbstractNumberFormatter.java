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

import java.util.regex.Pattern;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 * @param <T> the type extending @{Number} type
 */
public abstract class AbstractNumberFormatter<T extends Number> extends AbstractValueFormatter<T>{

  private final static Pattern JS_NUMBER_PATTERN = Pattern.compile("^[-+]?[0#]*\\.?[0#]+([eE][-+]?[0#]+)?$");
  
  @Override
  public ValueFormatter<T> setPattern(String pattern) {
    setPattern(pattern);
    if(JS_NUMBER_PATTERN.matcher(pattern).matches()){
      setJsString(false);
    }
    return this;
  }
  
}
