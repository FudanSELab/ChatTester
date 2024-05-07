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

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.zappos.json.JsonConfig.ReaderConfig;
import com.zappos.json.JsonConfig.WriterConfig;
import com.zappos.json.format.BigDecimalFormatter;
import com.zappos.json.format.BigIntegerFormatter;
import com.zappos.json.format.JavaDateFormatter;
import com.zappos.json.format.JavaSqlDateFormatter;
import com.zappos.json.format.JavaTimeInstantFormatter;
import com.zappos.json.format.JavaTimeLocalDateFormatter;
import com.zappos.json.format.JavaTimestampFormatter;
import com.zappos.json.format.ValueFormatter;
import com.zappos.json.util.JsonUtils;
import com.zappos.json.util.Reflections;
import com.zappos.json.util.Strings;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
public class ZapposJson {

  protected final Map<Class<?>, ValueFormatter<Object>> VALUE_FORMATTERS = new ConcurrentHashMap<>();

  private final static Map<String, ZapposJson> INSTANCES = new HashMap<>();

  private boolean debug = false;
  
  private JsonBeanIntrospector jsonBeanIntrospector;
  
  private JsonWriterCodeGenerator writerCodeGenerator;
  
  private JsonReaderCodeGenerator readerCodeGenerator;
  
  private final boolean[] WRITER_CONFIGS = new boolean[WriterConfig.values().length];
  
  private final boolean[] READER_CONFIGS = new boolean[ReaderConfig.values().length];
  
  protected ZapposJson() {
    
    addValueFormatter(Date.class, new JavaDateFormatter());
    addValueFormatter(java.sql.Date.class, new JavaSqlDateFormatter());
    addValueFormatter(java.sql.Timestamp.class, new JavaTimestampFormatter());
    addValueFormatter(java.math.BigInteger.class, new BigIntegerFormatter());
    addValueFormatter(java.math.BigDecimal.class, new BigDecimalFormatter());
    if (Reflections.classPresent("java.time.chrono.ChronoLocalDate")) {
      ValueFormatter<LocalDate> localDateHandler = new JavaTimeLocalDateFormatter();
      addValueFormatter(LocalDate.class, localDateHandler);
      ValueFormatter<Instant> instantHandler = new JavaTimeInstantFormatter();
      addValueFormatter(Instant.class, instantHandler);
    }
    jsonBeanIntrospector = new JsonBeanIntrospector(this);
    writerCodeGenerator = new JsonWriterCodeGenerator(this, jsonBeanIntrospector);
    readerCodeGenerator = new JsonReaderCodeGenerator(this, jsonBeanIntrospector);
  }
  
  protected ZapposJson(boolean debug) {
    this();
    this.debug = debug;
  }

  public static enum ZapposJsonSingleton {
    INSTANCE;

    ZapposJson zapposJson = new ZapposJson();

    public ZapposJson get() {
      return zapposJson;
    }
  }

  public static ZapposJson getInstance() {
    return ZapposJsonSingleton.INSTANCE.get();
  }

  public synchronized static ZapposJson getInstance(String name) {
    ZapposJson instance = INSTANCES.get(name);
    if (instance == null) {
      instance = new ZapposJson();
      INSTANCES.put(name, instance);
    }
    return instance;
  }

  public void register(Class<?>... classes) {
    for (Class<?> clazz : classes) {
      register(clazz);
    }
  }

  public void register(Class<?> clazz) {
    try{
      writerCodeGenerator.registerWriter(clazz);
      readerCodeGenerator.registerReader(clazz);
    }catch(Exception e){
      throw new JsonException(e);
    }
  }
  
  public void deregister(Class<?> clazz) {
    writerCodeGenerator.deregister(clazz);
    readerCodeGenerator.deregister(clazz);
  }

  public void deregisterAll() {
    writerCodeGenerator.deregisterAll();
    readerCodeGenerator.deregisterAll();
  }

  @SuppressWarnings("unchecked")
  public void addValueFormatter(Class<?> objectType,
      ValueFormatter<?> valueFormatter) {
    VALUE_FORMATTERS.put(objectType,
        (ValueFormatter<Object>) valueFormatter);
  }

  public void removeValueFormatter(Class<?> objectType) {
    VALUE_FORMATTERS.remove(objectType);
  }

  public ValueFormatter<Object> getValueFormatter(Class<?> objectType) {
    return VALUE_FORMATTERS.get(objectType);
  }
  
  public synchronized void configure(ReaderConfig config, boolean value){
    READER_CONFIGS[config.ordinal()] = true;
  }
  
  public synchronized boolean is(ReaderConfig config){
    return READER_CONFIGS[config.ordinal()];
  }
  
  public synchronized void configure(WriterConfig config, boolean value){
    WRITER_CONFIGS[config.ordinal()] = true;
  }
  
  public synchronized boolean is(WriterConfig config){
    return WRITER_CONFIGS[config.ordinal()];
  }
  
  /**
   * Try to format specified value with the formatter in a registry.
   * This method throws {@link NullPointerException} when the specified value is null.
   * @param value the object being formatted
   * @return formatted value or value.toString when there is no formatter
   */
  public String format(Object value) {
    ValueFormatter<Object> valueFormatter = VALUE_FORMATTERS.get(value.getClass());
    if (valueFormatter != null) {
      return valueFormatter.format(this, value);
    } else {
      return value.toString();
    }
  }
  
  public String toJson(Object object) {
    
    StringWriter writer = new StringWriter();
    toJson(object, writer);
    return writer.toString();
    
  }
  
  public void toJson(Object object, Writer writer) {
    
    try{
      
      if(object == null){
        writer.append(JsonWriter.CONST_NULL);
        return;
      }
      
      Class<?> objectType = object.getClass();
      ValueFormatter<?> formatter = VALUE_FORMATTERS.get(objectType);
      
      if(formatter != null){
        
        String formattedStr = formatter.formatObject(this, object);
        writer.append(formattedStr);
        return;
      }else if(object instanceof Boolean) {
        
        JsonWriter.writeBoolean(this, (Boolean)object, writer);
        return;
      }else if(object instanceof String || object instanceof Character) {
        
        JsonWriter.writeString(this, object.toString(), writer);
        return;
      }else if(object instanceof Number) {
        
        JsonWriter.writeNumber(this, (Number)object, writer);
        return;
      }else if(object instanceof Enum) {
        
        JsonWriter.writeEnum(this, (Enum<?>)object, writer);
        return;
      }else if(object instanceof Iterable) {
        
        JsonWriter.writeIterable(this, (Iterable<?>) object, writer);
        return;
      }else if(object instanceof Map) {
        
        JsonWriter.writeMap(this, (Map<?, ?>) object, writer);
        return;
      }else if(objectType.isArray()){
        Class<?> componentType = objectType.getComponentType();
        if(componentType == byte.class){
          JsonWriter.writeBase64String(this, (byte[])object, writer);
        }else if(componentType == char.class){
          JsonWriter.writeArray((char[])object, writer);
        }else if(componentType == boolean.class){
          JsonWriter.writeArray((boolean[])object, writer);
        }else if(componentType == short.class){
          JsonWriter.writeArray((short[])object, writer);
        }else if(componentType == int.class){
          JsonWriter.writeArray((int[])object, writer);
        }else if(componentType == long.class){
          JsonWriter.writeArray((long[])object, writer);
        }else if(componentType == float.class){
          JsonWriter.writeArray((float[])object, writer);
        }else if(componentType == double.class){
          JsonWriter.writeArray((double[])object, writer);
        }else{
          JsonWriter.writeArray(this, (Object[]) object, writer);
        }
        return;
      }
      
      JsonWriterInvoker writerInvoker = writerCodeGenerator.getWriter(objectType);
      if(writerInvoker == null){
        writerInvoker = writerCodeGenerator.registerWriter(objectType);
      }
      writerInvoker.writeJson(object, writer);
    
    }catch(JsonException e){
      throw e;
    }catch(Exception e){
      throw new JsonException(e);
    }
  }
  
  public <T> T fromJson(String json, Class<T> targetClass) {
    return fromJson(new StringReader(json), targetClass);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> T fromJson(Reader reader, Class<T> targetClass) {
    
    try{
      
      ValueFormatter<?> formatter = VALUE_FORMATTERS.get(targetClass);
      
      if(formatter != null){
        String s = Strings.fromReader(reader).trim();
        return (T)formatter.parse(this, s);
        
      }else if(targetClass == Boolean.class || targetClass == boolean.class){
        
        String s = Strings.fromReader(reader).trim();
        return (T)Boolean.valueOf(s);
        
      }else if(targetClass == String.class || targetClass == Character.class || targetClass == char.class){
        
        String s = Strings.fromReader(reader).trim();
        if(s.charAt(0) != '"' || s.charAt(s.length() - 1) != '"'){
          throw new IllegalArgumentException("Invalid string: " + s);
        }
        s = JsonUtils.unescape(this, s.subSequence(1, s.length() - 1));
        if(targetClass == Character.class || targetClass == char.class){
          if(s.length() != 1){
            throw new IllegalArgumentException("Invalid character: " + s);
          }
          return (T)new Character(s.charAt(0));
        }
        return (T)s;
      }else if(Number.class.isAssignableFrom(targetClass) || targetClass.isPrimitive()) {
        
        String s = Strings.fromReader(reader).trim();
        if(targetClass == Byte.class || targetClass == byte.class){
          return (T)Byte.valueOf(s);
        }else if(targetClass == Short.class || targetClass == short.class){
          return (T)Short.valueOf(s);
        }else if(targetClass == Integer.class || targetClass == int.class){
          return (T)Integer.valueOf(s);
        }else if(targetClass == Long.class || targetClass == long.class){
          return (T)Long.valueOf(s);
        }else if(targetClass == Float.class || targetClass == float.class){
          return (T)Float.valueOf(s);
        }else if(targetClass == Double.class || targetClass == double.class){
          return (T)Double.valueOf(s);
        }else{
          throw new IllegalArgumentException(targetClass.getName() +" is an unsupported type." +
              "You need a custom ValueFormatter for this type.");
        }
      }else if(targetClass.isEnum()) {
        
        String s = Strings.fromReader(reader).trim();
        return (T)Enum.valueOf((Class<? extends Enum>)targetClass, s);
        
      }else if(Iterable.class.isAssignableFrom(targetClass) ||
          Map.class.isAssignableFrom(targetClass)) {
        
        //What should we do with these types?
        //TODO: Should we use String/Boolean/Number/Array/Map type for generic parameter depending on JSON type?
        throw new IllegalArgumentException(targetClass.getName() +" not support yet");
      
      }else if(targetClass.isArray()){
        //TODO: add type hinting
        throw new IllegalArgumentException("Array type not support yet");
      }
      
      JsonReaderInvoker readerInvoker = readerCodeGenerator.getReader(targetClass);
      if(readerInvoker == null){
        readerInvoker = readerCodeGenerator.registerReader(targetClass);
      }
      
      return readerInvoker.readJson(reader, targetClass);
    
    }catch(JsonException e){
      throw e;
    }catch(Exception e){
      throw new JsonException(e);
    }
  }
  
  protected void debug(String pattern, Object... args) {
    if (debug) {
      System.out.println(Strings.format(pattern, args));
    }
  }
  
}
