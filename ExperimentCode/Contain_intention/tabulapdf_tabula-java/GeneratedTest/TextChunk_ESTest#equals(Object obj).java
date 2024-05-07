// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/TextChunk_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:15:23 GMT 2024
 */
package technology.tabula;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
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
    public void testEquals() {
        // Create TextElement objects for testing
        TextElement textElement1 = new TextElement(10, 20, 30, 40);
        TextElement textElement2 = new TextElement(15, 25, 35, 45);
        
        // Create TextChunk objects for testing
        TextChunk textChunk1 = new TextChunk(textElement1);
        TextChunk textChunk2 = new TextChunk(textElement2);
        
        // Test when comparing TextChunk objects with different textElements
        assertFalse(textChunk1.equals(textChunk2));
        
        // Create TextChunk objects with the same textElements for testing
        List<TextElement> textElementsList = new ArrayList<>();
        textElementsList.add(textElement1);
        textElementsList.add(textElement2);
        TextChunk textChunk3 = new TextChunk(textElementsList);
        TextChunk textChunk4 = new TextChunk(textElementsList);
        
        // Test when comparing TextChunk objects with the same textElements
        assertTrue(textChunk3.equals(textChunk4));
    }
}
