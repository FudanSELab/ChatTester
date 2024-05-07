// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/JavaTimeLocalDateFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:42:08 GMT 2024
 */
package com.zappos.json.format;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaTimeLocalDateFormatter;
import com.zappos.json.format.ValueFormatter;
import java.time.Clock;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.time.temporal.UnsupportedTemporalTypeException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockClock;
import org.evosuite.runtime.mock.java.time.MockLocalDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class JavaTimeLocalDateFormatter_ESTest extends JavaTimeLocalDateFormatter_ESTest_scaffolding {
    @Test
    public void testCast() {
        JavaTimeLocalDateFormatter formatter = new JavaTimeLocalDateFormatter();
        
        // Test case 1: Valid LocalDate object
        Object obj1 = LocalDate.now();
        LocalDate result1 = formatter.cast(obj1);
        assertEquals(obj1, result1);
        
        // Test case 2: Invalid object type
        Object obj2 = "2021-01-01";
        try {
            LocalDate result2 = formatter.cast(obj2);
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException e) {
            // Exception expected
        }
        
        // Test case 3: Null object
        Object obj3 = null;
        try {
            LocalDate result3 = formatter.cast(obj3);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Exception expected
        }
    }
}
