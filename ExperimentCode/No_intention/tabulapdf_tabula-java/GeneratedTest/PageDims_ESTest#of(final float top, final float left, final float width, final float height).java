// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/PageDims_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:56:04 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.PageDims;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class PageDims_ESTest extends PageDims_ESTest_scaffolding {
@Test
public void testOf() {
    float top = 10.0f;
    float left = 20.0f;
    float width = 30.0f;
    float height = 40.0f;

    PageDims pageDims = PageDims.of(top, left, width, height);

    assertEquals(top, pageDims.getTop(), 0.0f);
    assertEquals(left, pageDims.getLeft(), 0.0f);
    assertEquals(width, pageDims.getWidth(), 0.0f);
    assertEquals(height, pageDims.getHeight(), 0.0f);
}
}
