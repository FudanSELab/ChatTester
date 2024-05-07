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

import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class NoOpValueFormatter extends AbstractValueFormatter<Object>{

  @Override
  public Object cast(Object obj) {
    return obj;
  }
  
  @Override
  public String format(ZapposJson zapposJson, Object object) {
    throw new UnsupportedOperationException("NoOp");
  }
  
  @Override
  public Object parse(ZapposJson zapposJson, String string) throws Exception {
    throw new UnsupportedOperationException("NoOp");
  }

  @Override
  public ValueFormatter<Object> newInstance() {
    throw new UnsupportedOperationException("NoOp");
  }
  
}
