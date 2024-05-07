/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:15:23 GMT 2024
 */
package technology.tabula;

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
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class TextChunk_ESTest extends TextChunk_ESTest_scaffolding {
    @Test(timeout = 4000)
    public void test02() throws Throwable {
        TextChunk textChunk0 = TextChunk.EMPTY;
        textChunk0.setRect(4139.800386453927, 2.0, 2.0, 2.0);
        textChunk0.hashCode();
    }
    
    @Test(timeout = 4000)
    public void test07() throws Throwable {
        TextChunk textChunk0 = TextChunk.EMPTY;
        TextChunk textChunk1 = TextChunk.EMPTY;
        TextChunk textChunk2 = textChunk0.merge(textChunk1);
        TextChunk textChunk3 = textChunk0.EMPTY.merge(textChunk2);
        textChunk1.intersects((Rectangle2D) textChunk3);
        ArrayList<TextElement> arrayList0 = new ArrayList<TextElement>();
        textChunk0.add((List<TextElement>) arrayList0);
        TextChunk textChunk4 = textChunk1.merge(textChunk3);
        Character[] characterArray0 = new Character[2];
        Character character0 = new Character(',');
        characterArray0[0] = character0;
        Character character1 = new Character(',');
        textChunk4.setRect((Rectangle2D) textChunk0);
        characterArray0[1] = character1;
        textChunk4.isSameChar(characterArray0);
        textChunk4.isSameChar(character0);
        textChunk4.isLtrDominant();
        Boolean boolean0 = Boolean.FALSE;
        // Undeclared exception!
        try {
            textChunk1.groupByDirectionality(boolean0);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // 
            // no message in exception (getMessage() returned null)
            // 
            verifyException("technology.tabula.TextChunk", e);
        }
    }
}
