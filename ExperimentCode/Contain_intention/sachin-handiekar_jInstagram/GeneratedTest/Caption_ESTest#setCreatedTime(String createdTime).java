// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Caption_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:34:16 GMT 2024
 */
package org.jinstagram.entity.common;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Caption;
import org.jinstagram.entity.common.FromTagData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Caption_ESTest extends Caption_ESTest_scaffolding {
    @Test
    public void testSetCreatedTime() {
        Caption caption = new Caption();
        String createdTime = "2022-01-01T12:00:00Z";
        
        caption.setCreatedTime(createdTime);
        
        assertEquals(createdTime, caption.getCreatedTime());
    }
}
