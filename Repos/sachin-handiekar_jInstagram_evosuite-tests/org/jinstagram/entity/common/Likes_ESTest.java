/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:44:44 GMT 2024
 */

package org.jinstagram.entity.common;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Likes;
import org.jinstagram.entity.common.User;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Likes_ESTest extends Likes_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Likes likes0 = new Likes();
      LinkedList<User> linkedList0 = new LinkedList<User>();
      User user0 = new User();
      linkedList0.add(user0);
      likes0.setLikesUserList(linkedList0);
      List<User> list0 = likes0.getLikesUserList();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Likes likes0 = new Likes();
      likes0.setCount(2249);
      int int0 = likes0.getCount();
      assertEquals(2249, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Likes likes0 = new Likes();
      List<User> list0 = likes0.getLikesUserList();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Likes likes0 = new Likes();
      likes0.setCount((-2558));
      int int0 = likes0.getCount();
      assertEquals((-2558), int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Likes likes0 = new Likes();
      LinkedList<User> linkedList0 = new LinkedList<User>();
      likes0.setLikesUserList(linkedList0);
      List<User> list0 = likes0.getLikesUserList();
      assertEquals(0, list0.size());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Likes likes0 = new Likes();
      String string0 = likes0.toString();
      assertEquals("Likes [count=0, likesUserList=null]", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Likes likes0 = new Likes();
      int int0 = likes0.getCount();
      assertEquals(0, int0);
  }
}
