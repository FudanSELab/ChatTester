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

package com.zappos.json.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Random;

import com.zappos.json.JsonWriter;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class Strings {
  
  private static final char PLACEHOLDER = '@';

  private static final char BIG_LETTERS[] = new char[26];
  private static final char SMALL_LETTERS[] = new char[26];
  private static final char NUMBERS[] = new char[10];

  private static final Random RANDOM = new Random();

  static {
    for (int i = 0; i < 26; i++) {
      BIG_LETTERS[i] = (char) (65 + i);
      SMALL_LETTERS[i] = (char) (97 + i);
    }
    for (int i = 0; i < 10; i++) {
      NUMBERS[i] = (char) (48 + i);
    }
  }

  /**
   * Simplest formatter. It does not support escaping or any kinds of fancy
   * feature. It just fill the placeholder '@' with supplied argument values.
   * 
   * @param pattern the pattern being used by formatter
   * @param args the arguments for the formatter
   * @return formatted value as a string
   */
  public static String format(String pattern, Object... args) {

    if (args == null)
      return pattern;

    StringBuilder str = new StringBuilder(pattern.length() + 50);
    int idx = -1;
    int i = 0;
    int p = 0;
    while ((idx = pattern.indexOf(PLACEHOLDER, p)) != -1) {
      str.append(pattern.substring(p, idx));
      Object arg = args[i];
      if (arg == null) {
        str.append(JsonWriter.CONST_NULL);
      } else {
        str.append(args[i].toString());
      }
      i++;
      p = idx + 1;
    }
    str.append(pattern.substring(p));
    return str.toString();
  }

  public static String randomNumber(int n) {
    char c[] = new char[n];
    for (int i = 0; i < n; i++) {
      c[i] = NUMBERS[RANDOM.nextInt(10)];
    }
    return new String(c);
  }

  public static String randomAlphabetic(int n) {
    char c[] = new char[n];
    for (int i = 0; i < n; i++) {
      int j = RANDOM.nextInt(26);
      c[i] = RANDOM.nextBoolean() ? BIG_LETTERS[j] : SMALL_LETTERS[j];
    }
    return new String(c);
  }

  public static String random(int n, char chars[]) {
    char c[] = new char[n];
    for (int i = 0; i < n; i++) {
      c[i] = chars[RANDOM.nextInt(chars.length)];
    }
    return new String(c);
  }

  /**
   * 
   * @param s the string object
   * @return boolean indicating whether specified string is number
   */
  public static boolean isNumber(String s){
    if(s == null || s.length() == 0) return false;
    if(!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-') return false;
    
    int decimal = 0; 
    for(int i = 1; i < s.length(); i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)) continue;
      if(c == '.') {
        if(decimal == 1) return false;
        decimal++;
        continue;
      }
      return false;
    }
    return true;
  }
  
  public static String fromReader(Reader reader) throws IOException {
    return fromReader(reader, 1024);
  }
  
  public static String fromReader(Reader reader, int bufferSize) throws IOException {
    char[] arr = new char[bufferSize];
    StringBuilder buffer = new StringBuilder();
    int numCharsRead;
    while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
        buffer.append(arr, 0, numCharsRead);
    }
    reader.close();
    return buffer.toString();
  }
  
}
