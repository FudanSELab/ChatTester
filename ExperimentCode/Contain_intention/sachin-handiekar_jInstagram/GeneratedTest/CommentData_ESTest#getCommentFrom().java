// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/comments/CommentData_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:28:38 GMT 2024
 */
package org.jinstagram.entity.comments;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.comments.CommentData;
import org.jinstagram.entity.common.FromTagData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class CommentData_ESTest extends CommentData_ESTest_scaffolding {
    @Test
    public void testGetCommentFrom() {
        CommentData commentData = new CommentData();
        FromTagData expectedFromTagData = new FromTagData();
        
        commentData.setCommentFrom(expectedFromTagData);
        
        FromTagData actualFromTagData = commentData.getCommentFrom();
        
        assertNotNull(actualFromTagData);
        // Add more assertions as needed
    }
}
