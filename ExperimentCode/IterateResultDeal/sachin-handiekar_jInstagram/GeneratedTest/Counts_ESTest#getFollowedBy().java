// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/users/basicinfo/Counts_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:20:16 GMT 2024
 */
package org.jinstagram.entity.users.basicinfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.users.basicinfo.Counts;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Counts_ESTest extends Counts_ESTest_scaffolding {
    @Test
    public void testGetFollowedBy() {
        Counts counts = new Counts();
        counts.setFollowedBy(100); // Set a specific value for testing

        int expectedFollowedBy = 100;
        int actualFollowedBy = counts.getFollowedBy();

        assertEquals(expectedFollowedBy, actualFollowedBy);
    }
}
