/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:40:48 GMT 2024
 */

package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.ImageData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false) 
public class ImageData_ESTest extends ImageData_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageWidth(1029);
      int int0 = imageData0.getImageWidth();
      assertEquals(1029, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageWidth((-1249));
      int int0 = imageData0.getImageWidth();
      assertEquals((-1249), int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageUrl("ImageData [imageHeight=330, imageUrl=null, imageWidth=-1]");
      String string0 = imageData0.getImageUrl();
      assertEquals("ImageData [imageHeight=330, imageUrl=null, imageWidth=-1]", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageHeight((-1));
      int int0 = imageData0.getImageHeight();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      String string0 = imageData0.toString();
      assertEquals("ImageData [imageHeight=0, imageUrl=null, imageWidth=0]", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageHeight(1);
      int int0 = imageData0.getImageHeight();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      int int0 = imageData0.getImageWidth();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      imageData0.setImageUrl("");
      String string0 = imageData0.getImageUrl();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      String string0 = imageData0.getImageUrl();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      ImageData imageData0 = new ImageData();
      int int0 = imageData0.getImageHeight();
      assertEquals(0, int0);
  }
}
