/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:07:21 GMT 2024
 */
package technology.tabula;


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
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class RectangularTextContainer_ESTest extends RectangularTextContainer_ESTest_scaffolding {

@Test(timeout = 4000)
public void test00() throws Throwable {
    RectangularTextContainer<RectangularTextContainer<TextElement>> rectangularTextContainer0 = new RectangularTextContainer<RectangularTextContainer<TextElement>>(1.0F, 0.0F, 0.0F, 1.0F);
    RectangularTextContainer<RectangularTextContainer<TextElement>> rectangularTextContainer1 = new RectangularTextContainer<RectangularTextContainer<TextElement>>((-198.57213F), 1.0F, (-1133.79F), 0.0F);
    rectangularTextContainer0.merge(rectangularTextContainer1);
    assertEquals((-198.57213F), rectangularTextContainer0.y, 0.01F);
}

@Test(timeout = 4000)
public void test01() throws Throwable {
    TextChunk textChunk0 = new TextChunk(0.0F, 0.0F, 0.0F, 0.0F);
    String string0 = textChunk0.getText();
    assertEquals("", string0);
}

}
