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

package com.zappos.json.benchmark.data;

import java.util.Random;

import com.zappos.json.util.Strings;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class SimpleBean {
  
  private static final Random RANDOM = new Random();
  
  private String string;

  private Boolean flag;

  private int number;

  public static SimpleBean random(){
    SimpleBean bean = new SimpleBean();
    bean.string = Strings.randomAlphabetic(32);
    bean.flag = RANDOM.nextBoolean();
    bean.number = RANDOM.nextInt(100);
    return bean;
  }
  
  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public Boolean getFlag() {
    return flag;
  }

  public void setFlag(Boolean flag) {
    this.flag = flag;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
  
}
