// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Likes_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:44:44 GMT 2024
 */
package org.jinstagram.entity.common;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Likes;
import org.jinstagram.entity.common.User;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Likes_ESTest extends Likes_ESTest_scaffolding {
    @Test
    public void testSetCount() {
        Likes likes = new Likes();
        int newCount = 10;
        
        likes.setCount(newCount);
        
        assertEquals(newCount, likes.getCount());
    }
}
