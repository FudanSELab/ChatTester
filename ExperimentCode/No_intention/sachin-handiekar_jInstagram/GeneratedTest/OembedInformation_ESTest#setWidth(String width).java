// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/oembed/OembedInformation_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:07:06 GMT 2024
 */
package org.jinstagram.entity.oembed;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.oembed.OembedInformation;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class OembedInformation_ESTest extends OembedInformation_ESTest_scaffolding {
    @Test
    public void testSetWidth() {
        OembedInformation oembed = new OembedInformation();
        String width = "100";
        oembed.setWidth(width);
        assertEquals(width, oembed.getWidth());
    }
}
