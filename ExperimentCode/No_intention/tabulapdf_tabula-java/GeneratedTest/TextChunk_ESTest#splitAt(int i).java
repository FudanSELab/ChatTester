// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/TextChunk_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:15:23 GMT 2024
 */
package technology.tabula;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.Rectangle;
import technology.tabula.TextChunk;
import technology.tabula.TextElement;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class TextChunk_ESTest extends TextChunk_ESTest_scaffolding {
    @Test
    public void testSplitAt() {
        // Create a TextChunk object with some TextElements
        List<TextElement> textElements = new ArrayList<>();
        textElements.add(new TextElement("Hello"));
        textElements.add(new TextElement("World"));
        textElements.add(new TextElement("!"));
        TextChunk textChunk = new TextChunk(textElements);

        // Test splitting at index 1
        TextChunk[] result = textChunk.splitAt(1);
        assertEquals(2, result.length);
        assertEquals("Hello", result[0].getText());
        assertEquals("World!", result[1].getText());

        // Test splitting at index 2
        result = textChunk.splitAt(2);
        assertEquals(2, result.length);
        assertEquals("HelloWorld", result[0].getText());
        assertEquals("!", result[1].getText());

        // Test splitting at index 3
        try {
            result = textChunk.splitAt(3);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Exception expected
        }

        // Test splitting at index 0
        try {
            result = textChunk.splitAt(0);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Exception expected
        }
    }
}
