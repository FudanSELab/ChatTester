// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/JavaSqlDateFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:37:54 GMT 2024
 */
package com.zappos.json.format;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaSqlDateFormatter;
import com.zappos.json.format.ValueFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class JavaSqlDateFormatter_ESTest extends JavaSqlDateFormatter_ESTest_scaffolding {
@Test
public void testFormat() {
    // Create a ZapposJson object
    ZapposJson zapposJson = new ZapposJson();

    // Create a Date object
    Date date = new Date(System.currentTimeMillis());

    // Create an instance of the JavaSqlDateFormatter class
    JavaSqlDateFormatter formatter = new JavaSqlDateFormatter();

    // Call the format method and get the result
    String result = formatter.format(zapposJson, date);

    // Assert that the result is not null
    assertNotNull(result);

    // Assert that the result is a valid JSON value
    assertTrue(isValidJsonValue(result));
}
}
