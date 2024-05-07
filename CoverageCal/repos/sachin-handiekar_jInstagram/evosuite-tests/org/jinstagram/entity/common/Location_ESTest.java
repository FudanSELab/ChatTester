/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:46:49 GMT 2024
 */

package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Location;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false) 
public class Location_ESTest extends Location_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Location location0 = new Location();
      location0.setName("^_VW$bqieQ2v\"");
      String string0 = location0.getName();
      assertEquals("^_VW$bqieQ2v\"", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Location location0 = new Location();
      location0.setName("");
      String string0 = location0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Location location0 = new Location();
      location0.setLongitude(1319.1515315654);
      double double0 = location0.getLongitude();
      assertEquals(1319.1515315654, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Location location0 = new Location();
      location0.setLongitude((-1693.2258408078));
      double double0 = location0.getLongitude();
      assertEquals((-1693.2258408078), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Location location0 = new Location();
      location0.setLatitude(1076.484622);
      double double0 = location0.getLatitude();
      assertEquals(1076.484622, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Location location0 = new Location();
      location0.setLatitude((-482.5));
      double double0 = location0.getLatitude();
      assertEquals((-482.5), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Location location0 = new Location();
      location0.setId("aN@'+h@y");
      String string0 = location0.getId();
      assertEquals("aN@'+h@y", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Location location0 = new Location();
      location0.setId("");
      String string0 = location0.getId();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Location location0 = new Location();
      String string0 = location0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Location location0 = new Location();
      double double0 = location0.getLatitude();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Location location0 = new Location();
      String string0 = location0.getId();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Location location0 = new Location();
      double double0 = location0.getLongitude();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Location location0 = new Location();
      String string0 = location0.toString();
      assertEquals("Location [id=null, name=null, latitude=0.0, longitude=0.0]", string0);
  }
}
