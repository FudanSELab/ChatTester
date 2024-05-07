// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:53:47 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.TextChunk;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Line_ESTest extends Line_ESTest_scaffolding {
@Test
public void testToString() {
    // Create a Line object
    Line line = new Line();
    
    // Create a list of TextChunk objects
    List<TextChunk> textChunks = new ArrayList<>();
    textChunks.add(new TextChunk("Hello"));
    textChunks.add(new TextChunk("World"));
    
    // Set the textChunks in the Line object
    line.setTextElements(textChunks);
    
    // Expected result
    String expected = "Line@<hashcode>,chunks='Hello', 'World']";
    
    // Call the toString() method
    String result = line.toString();
    
    // Assert the result
    assertEquals(expected, result);
}
}
