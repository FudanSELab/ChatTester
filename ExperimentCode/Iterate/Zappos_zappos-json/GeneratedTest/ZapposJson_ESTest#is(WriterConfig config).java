// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/ZapposJson_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 14:19:12 GMT 2024
 */
package com.zappos.json;




import java.util.*;
import java.lang.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.JsonConfig;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.JavaDateFormatter;
import com.zappos.json.format.ValueFormatter;
import java.io.File;
import java.io.PipedReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.chrono.HijrahEra;
import java.util.Date;
import java.util.Locale;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.io.MockPrintWriter;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class ZapposJson_ESTest extends ZapposJson_ESTest_scaffolding {
    
    
    
    
    
    @Test
    public void testIsWriterConfigEnabled() {
        ZapposJson zapposJson = ZapposJson.getInstance();

        zapposJson.configure(ZapposJson.WriterConfig.WRITE_NULL_PROPERTIES, true);

        assertTrue(zapposJson.is(ZapposJson.WriterConfig.WRITE_NULL_PROPERTIES));
        zapposJson.configure(ZapposJson.WriterConfig.WRITE_DATES_AS_TIMESTAMPS, false);
        assertFalse(zapposJson.is(ZapposJson.WriterConfig.WRITE_DATES_AS_TIMESTAMPS));
    }
}
