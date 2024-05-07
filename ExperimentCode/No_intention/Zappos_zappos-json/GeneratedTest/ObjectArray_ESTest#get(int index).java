// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/util/ObjectArray_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 14:09:15 GMT 2024
 */
package com.zappos.json.util;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.util.ObjectArray;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class ObjectArray_ESTest extends ObjectArray_ESTest_scaffolding {
    @Test
    public void testGet() {
        ObjectArray objectArray = new ObjectArray();
        objectArray.add("Element 1");
        objectArray.add("Element 2");
        objectArray.add("Element 3");

        // Test for valid index
        assertEquals("Element 1", objectArray.get(0));
        assertEquals("Element 2", objectArray.get(1));
        assertEquals("Element 3", objectArray.get(2));

        // Test for invalid index
        try {
            objectArray.get(3);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 3, Size: 3", e.getMessage());
        }
    }
}
