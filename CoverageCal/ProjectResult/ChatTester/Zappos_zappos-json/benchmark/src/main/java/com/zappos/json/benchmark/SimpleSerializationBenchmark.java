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
public class SimpleSerializationBenchmark {

  private List<SimpleBean> beans;
  
  @Setup
  public void prepare() {
    beans = new ArrayList<>();
    for(int i = 0; i < 1000; i++)
      beans.add(SimpleBean.random());
  }
  
  @Benchmark
  public void serializeUsingGson(Blackhole bh){
    for(SimpleBean bean: beans){
      bh.consume(JsonSingleton.INSTANCE.gson().toJson(bean));
    }
  }
  
  @Benchmark
  public void serializeUsingJackson(Blackhole bh) throws Exception {
    for(SimpleBean bean: beans){
      bh.consume(JsonSingleton.INSTANCE.jackson().writeValueAsString(bean));
    }
  }
  
  @Benchmark
  public void serializeUsingBoon(Blackhole bh) throws Exception {
    for(SimpleBean bean: beans){
      bh.consume(JsonSingleton.INSTANCE.boon().writeValueAsString(bean));
    }
  }
  
  @Benchmark
  public void serializeUsingZapposJson(Blackhole bh){
    for(SimpleBean bean: beans){
      bh.consume(ZapposJson.getInstance().toJson(bean));
    }
  }
  
  
}
