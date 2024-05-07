// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Caption_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:34:16 GMT 2024
 */
package org.jinstagram.entity.common;

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
    public void testGetText() {
        // Create a Caption object
        Caption caption = new Caption();

        // Set the text of the caption
        caption.setText("Hello World");

        // Get the text using the getText() method
        String text = caption.getText();

        // Assert that the returned text is equal to the set text
        assertEquals("Hello World", text);
    }
}
