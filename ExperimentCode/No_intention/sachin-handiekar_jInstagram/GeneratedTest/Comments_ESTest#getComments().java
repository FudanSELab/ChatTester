// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Comments_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:36:05 GMT 2024
 */
package org.jinstagram.entity.common;
import org.jinstagram.entity.comments.CommentData;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.comments.CommentData;
import org.jinstagram.entity.common.Comments;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Comments_ESTest extends Comments_ESTest_scaffolding {
    @Test
    public void testGetComments() {
        // Create a new instance of the Comments class
        Comments comments = new Comments();

        // Create a list of CommentData objects
        List<CommentData> expectedComments = List.of(
                new CommentData("User1", "Comment1"),
                new CommentData("User2", "Comment2"),
                new CommentData("User3", "Comment3")
        );

        // Set the comments in the Comments object
        comments.setComments(expectedComments);

        // Call the getComments method
        List<CommentData> actualComments = comments.getComments();

        // Assert that the returned comments are equal to the expected comments
        assertEquals(expectedComments, actualComments);
    }
}
