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

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.zappos.json.util.JsonUtils;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonWriter {

  /*
   * Static will not be copied. So they are fine to be here.
   */
  public static final String CONST_NULL = "null";
  public static final char CONST_DOUBLE_QUOTE = '"';
  public static final char CONST_COMMA = ',';
  public static final char CONST_COLON = ':';
  public static final char CONST_OPEN_OBJECT = '{';
  public static final char CONST_CLOSE_OBJECT = '}';
  public static final char CONST_OPEN_ARRAY = '[';
  public static final char CONST_CLOSE_ARRAY = ']';
  
  
  protected ZapposJson zapposJson;

  public JsonWriter(ZapposJson jacinda) {
    this.zapposJson = jacinda;
  }
  
  public static void writeString(ZapposJson zapposJson, String value, Writer writer) throws IOException {
    writer.write(JsonWriter.CONST_DOUBLE_QUOTE);
    JsonUtils.escape(zapposJson, value, writer);
    writer.write(JsonWriter.CONST_DOUBLE_QUOTE);
  }
  
  public static void writeBoolean(ZapposJson zapposJson, Boolean value, Writer writer) throws IOException {
    writer.append(value.toString());
  }
  
  public static void writeNumber(ZapposJson zapposJson, Number value, Writer writer) throws IOException {
    writer.append(zapposJson.format(value));
  }
  
  public static void writeEnum(ZapposJson zapposJson, Enum<?> value, Writer writer) throws IOException {
    writeString(zapposJson, value.name(), writer);
  }
  
  public static void writeIterable(ZapposJson zapposJson, Iterable<?> iterable, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    Iterator<?> iterator = iterable.iterator();
    if(iterator.hasNext()){
      zapposJson.toJson(iterator.next(), writer);
    }
    while(iterator.hasNext()){
      writer.append(JsonWriter.CONST_COMMA);
      zapposJson.toJson(iterator.next(), writer);
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  public static void writeMap(ZapposJson zapposJson, Map<?, ?> map, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_OBJECT);
    boolean second = false;
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      if(second){
        writer.append(JsonWriter.CONST_COMMA);
      }else{
        second = true;
      }
      JsonWriter.writeString(zapposJson, (String)entry.getKey(), writer);
      writer.append(JsonWriter.CONST_COLON);
      zapposJson.toJson(entry.getValue(), writer);
    }
    writer.append(JsonWriter.CONST_CLOSE_OBJECT);
  }
  
  public static void writeArray(ZapposJson zapposJson, Object[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      zapposJson.toJson(values[i], writer);
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      zapposJson.toJson(values[j], writer);
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  public static void writeBase64String(ZapposJson zapposJson, byte value[], Writer writer) throws IOException {
    writer.write(JsonWriter.CONST_DOUBLE_QUOTE);
    writer.write(DatatypeConverter.printBase64Binary(value));
    writer.write(JsonWriter.CONST_DOUBLE_QUOTE);
  }
  
  /*
   * =========================== writeArray for native type ===================================
   * TODO: How can we avoid duplicate code for array of native type?
   * writeArray(byte[]) is not defined in a favor of writeString(byte[], writer) 
   */
  
  
  /**
   * 
   * @param values the array of char
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(char[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      //TODO: figure out whether we should have ZapposJson in parameters
      writeString(ZapposJson.getInstance(), String.valueOf(values[i]), writer);
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      //TODO: figure out whether we should have ZapposJson in parameters
      writeString(ZapposJson.getInstance(), String.valueOf(values[j]), writer);
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of boolean
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(boolean[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of short
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(short[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of int
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(int[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of long
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(long[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of float
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(float[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
  
  /**
   * 
   * @param values the array of double
   * @param writer the writer object
   * @throws IOException the exception that might throw when I/O operation performs
   */
  public static void writeArray(double[] values, Writer writer) throws IOException {
    writer.append(JsonWriter.CONST_OPEN_ARRAY);
    int j = values.length - 1;
    for (int i = 0; i < j; i++) {
      writer.append(String.valueOf(values[i]));
      writer.append(JsonWriter.CONST_COMMA);
    }
    if (j > -1) {
      writer.append(String.valueOf(values[j]));
    }
    writer.append(JsonWriter.CONST_CLOSE_ARRAY);
  }
}
