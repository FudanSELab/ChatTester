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

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public final class JsonConfig {
  
  public static enum WriterConfig {
    WRITE_HTML_SAFE,
    WRITE_ENUM_USING_NAME,
    WRITE_ENUM_USING_ORDINAL,
  }
  
  public static enum ReaderConfig {
    READ_HTML_SAFE,
    READ_ENUM_USING_NAME,
    READ_ENUM_USING_ORDINAL,
  }
  
}
