// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/JavaTimeInstantFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:40:01 GMT 2024
 */
package com.zappos.json.format;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaTimeInstantFormatter;
import com.zappos.json.format.ValueFormatter;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class JavaTimeInstantFormatter_ESTest extends JavaTimeInstantFormatter_ESTest_scaffolding {
    @Test
    public void testFormat() {
        // Create a ZapposJson object
        ZapposJson zapposJson = new ZapposJson();

        // Create an Instant object
        Instant instant = Instant.now();

        // Create an instance of JavaTimeInstantFormatter
        JavaTimeInstantFormatter formatter = new JavaTimeInstantFormatter();

        // Call the format method
        String result = formatter.format(zapposJson, instant);

        // Assert the result
        assertEquals(String.valueOf(instant.toEpochMilli()), result);
    }
}
