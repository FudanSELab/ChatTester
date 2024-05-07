// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:07:21 GMT 2024
 */
package technology.tabula;





import java.util.Arrays;
import java.util.*;
import java.lang.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.geom.Point2D;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Cell;
import technology.tabula.RectangularTextContainer;
import technology.tabula.TextChunk;
import technology.tabula.TextElement;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class RectangularTextContainer_ESTest extends RectangularTextContainer_ESTest_scaffolding {
    
    




@Test
public void testGetTextWithLineReturns() {
    RectangularTextContainer container = new RectangularTextContainer(10.0f, 20.0f, 100.0f, 50.0f);
    container.setTextElements(Arrays.asList("Hello", "World"));
    String expectedTextWithLineReturns = "Hello\nWorld";
    
    String actualTextWithLineReturns = container.getText(true);
    
    assertEquals(expectedTextWithLineReturns, actualTextWithLineReturns);
}
}
