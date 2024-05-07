// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/JsonReader_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:53:16 GMT 2024
 */
package com.zappos.json;
import org.junit.Test;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.JsonReader;
import com.zappos.json.ZapposJson;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class JsonReader_ESTest extends JsonReader_ESTest_scaffolding {
    @Test
    public void testParse() throws IOException {
        // Create a JsonReader object
        ZapposJson zapposJson = new ZapposJson();
        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        JsonReader jsonReader = new JsonReader(zapposJson, jsonString);

        // Call the parse method
        Object result = jsonReader.parse();

        // Assert the expected result
        assertNotNull(result);
        assertTrue(result instanceof Map);

        Map<String, Object> resultMap = (Map<String, Object>) result;
        assertEquals("John", resultMap.get("name"));
        assertEquals(30, resultMap.get("age"));
        assertEquals("New York", resultMap.get("city"));
    }
}
