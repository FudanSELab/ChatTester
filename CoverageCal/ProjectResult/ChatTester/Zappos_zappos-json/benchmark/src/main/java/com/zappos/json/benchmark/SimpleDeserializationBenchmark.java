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

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;

import com.zappos.json.ZapposJson;
import com.zappos.json.benchmark.data.SimpleBean;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 */
@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
@Fork(1) @Threads(2)
public class SimpleDeserializationBenchmark {

  private List<String> jsons;
  
  @Setup
  public void prepare() throws Exception {
    jsons = new ArrayList<>();
    for(int i = 0; i < 1000; i++)
      jsons.add(JsonSingleton.INSTANCE.JACKSON.writeValueAsString(SimpleBean.random()));
  }
  
  @Benchmark
  public void deserializeUsingGson(Blackhole bh){
    for(String json: jsons){
      bh.consume(JsonSingleton.INSTANCE.gson().fromJson(json, SimpleBean.class));
    }
  }
  
  @Benchmark
  public void deserializeUsingJackson(Blackhole bh) throws Exception {
    for(String json: jsons){
      bh.consume(JsonSingleton.INSTANCE.jackson().readValue(json, SimpleBean.class));
    }
  }
  
  @Benchmark
  public void deserializeUsingBoon(Blackhole bh) throws Exception {
    for(String json: jsons){
      bh.consume(JsonSingleton.INSTANCE.boon().readValue(json, SimpleBean.class));
    }
  }
  
  @Benchmark
  public void deserializeUsingZapposJson(Blackhole bh){
    for(String json: jsons){
      bh.consume(ZapposJson.getInstance().fromJson(json, SimpleBean.class));
    }
  }
  
  
}
