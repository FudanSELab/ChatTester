// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/JavaDateFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:35:46 GMT 2024
 */
package com.zappos.json.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaDateFormatter;
import com.zappos.json.format.ValueFormatter;
import java.text.ParseException;
import java.util.Date;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class JavaDateFormatter_ESTest extends JavaDateFormatter_ESTest_scaffolding {
    @Test
    public void testParse_withPattern() throws Exception {
        JavaDateFormatter formatter = new JavaDateFormatter();
        ZapposJson zapposJson = new ZapposJson();
        String dateString = "2022-01-01";
        
        Date parsedDate = formatter.parse(zapposJson, dateString);
        
        assertNotNull(parsedDate);
        assertEquals("Sat Jan 01 00:00:00 UTC 2022", parsedDate.toString());
    }
}
