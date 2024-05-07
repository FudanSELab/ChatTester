/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:42:58 GMT 2024
 */
package technology.tabula;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Cell;
import technology.tabula.TextChunk;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Cell_ESTest extends Cell_ESTest_scaffolding {

@Test(timeout = 4000)
public void test00() throws Throwable {
    Cell cell0 = new Cell(1.0F, 1.0F, 1.0F, 1.0F);
    LinkedList<TextChunk> linkedList0 = new LinkedList<TextChunk>();
    TextChunk textChunk0 = new TextChunk(3329.5376F, 612.87616F, 0.5F, (-89.0F));
    linkedList0.add(textChunk0);
    TextChunk textChunk1 = new TextChunk(0.0F, 1.0F, 0.0F, 0.0F);
    linkedList0.add(textChunk1);
    cell0.setTextElements(linkedList0);
    String string0 = cell0.getText(true);
    assertEquals("", string0);
    assertFalse(cell0.isPlaceholder());
    assertFalse(cell0.isSpanning());
}

@Test(timeout = 4000)
public void test01() throws Throwable {
    Point point0 = new Point();
    Cell cell0 = new Cell(point0, point0);
    cell0.textElements = null;
    // Undeclared exception!
    try {
        cell0.getText(true);
        fail("Expecting exception: NullPointerException");
    } catch (NullPointerException e) {
        // 
        // no message in exception (getMessage() returned null)
        // 
        verifyException("technology.tabula.Cell", e);
    }
}

@Test(timeout = 4000)
public void test02() throws Throwable {
    Cell cell0 = new Cell((-1540.676F), (-1540.676F), 801.6F, 801.6F);
    assertFalse(cell0.isSpanning());
    cell0.setSpanning(true);
    boolean boolean0 = cell0.isSpanning();
    assertTrue(boolean0);
}

@Test(timeout = 4000)
public void test03() throws Throwable {
    Cell cell0 = new Cell((-1540.676F), (-1540.676F), 801.6F, 801.6F);
    assertFalse(cell0.isSpanning());
    cell0.setSpanning(true);
    boolean boolean0 = cell0.isSpanning();
    assertTrue(boolean0);
}

@Test(timeout = 4000)
public void test04() throws Throwable {
    Cell cell0 = new Cell(0.0F, 0.0F, (-576.0F), 0.0F);
    assertFalse(cell0.isPlaceholder());
    cell0.setPlaceholder(true);
    boolean boolean0 = cell0.isPlaceholder();
    assertTrue(boolean0);
}

}
