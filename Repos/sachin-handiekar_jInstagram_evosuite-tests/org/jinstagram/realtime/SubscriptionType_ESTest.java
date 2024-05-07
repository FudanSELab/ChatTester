/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 05:06:43 GMT 2024
 */

package org.jinstagram.realtime;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.realtime.SubscriptionType;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class SubscriptionType_ESTest extends SubscriptionType_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      SubscriptionType[] subscriptionTypeArray0 = SubscriptionType.values();
      assertEquals(4, subscriptionTypeArray0.length);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SubscriptionType subscriptionType0 = SubscriptionType.valueOf("LOCATIONS");
      assertEquals(SubscriptionType.LOCATIONS, subscriptionType0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SubscriptionType subscriptionType0 = SubscriptionType.LOCATIONS;
      String string0 = subscriptionType0.toString();
      assertEquals("location", string0);
  }
}
