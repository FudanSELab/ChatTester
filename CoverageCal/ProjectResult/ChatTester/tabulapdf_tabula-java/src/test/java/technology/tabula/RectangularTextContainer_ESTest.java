// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:07:21 GMT 2024
 */
package technology.tabula;






import java.util.*;
import java.lang.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
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

import static org.junit.Assert.assertEquals;
import org.junit.Test;
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

import java.util.*;
import java.lang.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
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
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class RectangularTextContainer_ESTest extends RectangularTextContainer_ESTest_scaffolding {

@Test
public void testToString() {
    RectangularTextContainer container = new RectangularTextContainer(10.0f, 20.0f, 30.0f, 40.0f);
    container.setTextElements(Arrays.asList("Hello", "World"));
    String expected = "RectangularTextContainer[x=10.0,y=20.0,width=30.0,height=40.0,text=[\"Hello\",\"World\"]]";
   
}

    @Test
    public void testSetTextElements() {
        // Given
        RectangularTextContainer container = new RectangularTextContainer(0, 0, 100, 50);
        List<String> newTextElements = new ArrayList<>();
        newTextElements.add("Text Element 1");
        newTextElements.add("Text Element 2");

        // When
        container.setTextElements(newTextElements);

        // Then
        assertEquals(2, container.textElements.size());
        assertTrue(container.textElements.contains("Text Element 1"));
        assertTrue(container.textElements.contains("Text Element 2"));
    }

    @Test
    public void testGetText() {
        RectangularTextContainer container = new RectangularTextContainer(10.0f, 20.0f, 100.0f, 50.0f) {
            @Override
            public String getText() {
                return "Sample Text Content";
            }
        };

        String expectedText = "Sample Text Content";
        String actualText = container.getText();

        assertEquals(expectedText, actualText);
    }

}
