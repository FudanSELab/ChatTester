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
 *
 * Copyright (c) 2013, 2015 EclipseSource.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.zappos.json.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.zappos.json.JsonConfig.WriterConfig;
import com.zappos.json.ZapposJson;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class JsonUtils {
  
  /*
   * Source: GSON
   * From RFC 4627, "All Unicode characters may be placed within the
   * quotation marks except for the characters that must be escaped:
   * quotation mark, reverse solidus, and the control characters
   * (U+0000 through U+001F)."
   *
   * We also escape '\u2028' and '\u2029', which JavaScript interprets as
   * newline characters. This prevents eval() from failing with a syntax
   * error. http://code.google.com/p/google-gson/issues/detail?id=341
   */
  private static final String[] REPLACEMENT_CHARS;
  private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
  static {
    REPLACEMENT_CHARS = new String[128];
    for (int i = 0; i <= 0x1f; i++) {
      REPLACEMENT_CHARS[i] = String.format("\\u%04x", (int) i);
    }
    REPLACEMENT_CHARS['"'] = "\\\"";
    REPLACEMENT_CHARS['\\'] = "\\\\";
    REPLACEMENT_CHARS['\t'] = "\\t";
    REPLACEMENT_CHARS['\b'] = "\\b";
    REPLACEMENT_CHARS['\n'] = "\\n";
    REPLACEMENT_CHARS['\r'] = "\\r";
    REPLACEMENT_CHARS['\f'] = "\\f";
    HTML_SAFE_REPLACEMENT_CHARS = REPLACEMENT_CHARS.clone();
    HTML_SAFE_REPLACEMENT_CHARS['<'] = "\\u003c";
    HTML_SAFE_REPLACEMENT_CHARS['>'] = "\\u003e";
    HTML_SAFE_REPLACEMENT_CHARS['&'] = "\\u0026";
    HTML_SAFE_REPLACEMENT_CHARS['='] = "\\u003d";
    HTML_SAFE_REPLACEMENT_CHARS['\''] = "\\u0027";
  }
  
  public static void escape(ZapposJson zapposJson, CharSequence value, Writer writer) throws IOException {
    String[] replacements = (zapposJson.is(WriterConfig.WRITE_HTML_SAFE)) ? 
        HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
    int last = 0;
    int length = value.length();
    for (int i = 0; i < length; i++) {
      char c = value.charAt(i);
      String replacement;
      if (c < 128) {
        replacement = replacements[c];
        if (replacement == null) {
          continue;
        }
      } else if (c == '\u2028') {
        replacement = "\\u2028";
      } else if (c == '\u2029') {
        replacement = "\\u2029";
      } else {
        continue;
      }
      if (last < i) {
        writer.write(value.toString(), last, i - last);
      }
      writer.write(replacement);
      last = i + 1;
    }
    if (last < length) {
      writer.write(value.toString(), last, length - last);
    }
  }
  
  public static String escape(ZapposJson zapposJson, CharSequence value) {
    StringWriter writer = new StringWriter();
    try{
      escape(zapposJson, value, writer);
    }catch(IOException e){}
    return writer.toString();
  }
  
  public static void unescape(ZapposJson zapposJson, CharSequence value, Writer writer) throws IOException {
    boolean inescape = false;
    for(int i = 0; i < value.length(); i++){
      char c = value.charAt(i);
      if(c != '\\' && !inescape) {
        writer.append(c);
        continue;
      }else if( c == '\\'){
        inescape = true;
        continue;
      }
      
      switch(c){
        case 'u':
          writer.append(String.valueOf(Integer.parseInt(value.subSequence(i, 4).toString(), 16)));
          i += 4;
          break;
        case 't':
          writer.append('\t');
          break;
        case 'b':
          writer.append('\b');
          break;
        case 'n':
          writer.append('\n');
          break;
        case 'r':
          writer.append('\r');
          break;
        case 'f':
          writer.append('\f');
          break;
        case '\n':
        case '\'':
        case '"':
        case '\\':
        default: 
          writer.append(c);
      }
      inescape = false;
    }
  }
  
  public static String unescape(ZapposJson zapposJson, CharSequence value) {
    StringWriter writer = new StringWriter();
    try{
      unescape(zapposJson, value, writer);
    }catch(IOException e){}
    return writer.toString();
  }
  
}
