// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Meta_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:48:49 GMT 2024
 */
package org.jinstagram.entity.common;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Meta_ESTest extends Meta_ESTest_scaffolding {
    @Test
    public void testSetErrorType() {
        Meta meta = new Meta();
        String errorType = "Runtime Error";
        
        meta.setErrorType(errorType);
        
        assertEquals(errorType, meta.getErrorType());
    }
}
