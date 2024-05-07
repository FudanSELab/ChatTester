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

package com.zappos.json.benchmark;

import org.boon.json.implementation.ObjectMapperImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public enum JsonSingleton {
  
  INSTANCE;
  
  Gson GSON = new Gson();
  
  ObjectMapper JACKSON = new ObjectMapper();
  
  org.boon.json.ObjectMapper BOON = new ObjectMapperImpl();

  public Gson gson() {
    return GSON;
  }

  public ObjectMapper jackson() {
    return JACKSON;
  }

  public org.boon.json.ObjectMapper boon() {
    return BOON;
  }
}