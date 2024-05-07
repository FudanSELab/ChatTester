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

import java.math.BigInteger;
import java.text.DecimalFormat;

import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class BigIntegerFormatter extends AbstractNumberFormatter<BigInteger> {
  
  @Override
  public BigInteger cast(Object obj) {
    return BigInteger.class.cast(obj);
  }
  
  @Override
  public String format(ZapposJson zapposJson, BigInteger object) {
    if(getPattern() != null){
      return toJsonValue(zapposJson, new DecimalFormat(getPattern()).format(object));
    }
    return object.toString();
  }

  @Override
  public BigInteger parse(ZapposJson zapposJson, String string) throws Exception {
    if(getPattern() != null){
      DecimalFormat df = new DecimalFormat(getPattern());
      return BigInteger.valueOf(df.parse(string).longValue());
    }
    return new BigInteger(string);
  }

  @Override
  public ValueFormatter<BigInteger> newInstance() {
    return new BigIntegerFormatter();
  }
  
}
