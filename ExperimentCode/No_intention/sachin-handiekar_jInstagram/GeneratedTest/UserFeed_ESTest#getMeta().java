// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/users/feed/UserFeed_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:32:23 GMT 2024
 */
package org.jinstagram.entity.users.feed;
import org.jinstagram.entity.common.Meta;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.common.Pagination;
import org.jinstagram.entity.users.feed.UserFeed;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class UserFeed_ESTest extends UserFeed_ESTest_scaffolding {
    @Test
    public void testGetMeta() {
        // Create a UserFeed instance
        UserFeed userFeed = new UserFeed();

        // Create a Meta instance
        Meta meta = new Meta();
        meta.setCode(200);
        meta.setErrorType("none");
        meta.setErrorMessage("");

        // Set the Meta instance in the UserFeed instance
        userFeed.setMeta(meta);

        // Call the getMeta() method and assert the returned value
        Meta returnedMeta = userFeed.getMeta();
        assertEquals(meta, returnedMeta);
    }
}
