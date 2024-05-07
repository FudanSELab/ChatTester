/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:28:38 GMT 2024
 */

package org.jinstagram.entity.comments;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.comments.CommentData;
import org.jinstagram.entity.common.FromTagData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class CommentData_ESTest extends CommentData_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setText("org.jinstagram.entity.common.FromTagData");
      String string0 = commentData0.getText();
      assertEquals("org.jinstagram.entity.common.FromTagData", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setText("");
      String string0 = commentData0.getText();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setId("bF~}(h/vw");
      String string0 = commentData0.getId();
      assertEquals("bF~}(h/vw", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setId("");
      String string0 = commentData0.getId();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setCreatedTime("3v([Q$");
      String string0 = commentData0.getCreatedTime();
      assertEquals("3v([Q$", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      commentData0.setCreatedTime("");
      String string0 = commentData0.getCreatedTime();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      String string0 = commentData0.toString();
      assertEquals("CommentData [commentFrom=null, createdTime=null, id=null, text=null]", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      String string0 = commentData0.getId();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      FromTagData fromTagData0 = commentData0.getCommentFrom();
      assertNull(fromTagData0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      String string0 = commentData0.getCreatedTime();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      FromTagData fromTagData0 = new FromTagData();
      commentData0.setCommentFrom(fromTagData0);
      FromTagData fromTagData1 = commentData0.getCommentFrom();
      assertNull(fromTagData1.getFullName());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CommentData commentData0 = new CommentData();
      String string0 = commentData0.getText();
      assertNull(string0);
  }
}
