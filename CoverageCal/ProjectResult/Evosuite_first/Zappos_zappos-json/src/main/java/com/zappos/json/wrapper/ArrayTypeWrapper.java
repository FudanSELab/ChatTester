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

package com.zappos.json.wrapper;

/**
 * 
 * @author Hussachai Puripunpinyo
 *
 * @param <T> the type of target
 */
public class ArrayTypeWrapper<T> implements TypeWrapper<T>{
  
  private Class<?> componentType;
  
  private T target;
  
  @Override
  public void setTarget(T target) {
    this.target = target;
  }
  
  @Override
  public T getTarget() {
    return target;
  }

  public Class<?> getComponentType() {
    return componentType;
  }

  public void setComponentType(Class<?> componentType) {
    this.componentType = componentType;
  }
  
}
