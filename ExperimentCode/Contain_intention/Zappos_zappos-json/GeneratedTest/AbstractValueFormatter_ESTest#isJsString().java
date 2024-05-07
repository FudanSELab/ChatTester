// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/AbstractValueFormatter_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 25 13:29:33 GMT 2024
 */
package com.zappos.json.format;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.zappos.json.ZapposJson;
import com.zappos.json.format.BigIntegerFormatter;
import com.zappos.json.format.JavaTimeLocalDateFormatter;
import com.zappos.json.format.JavaTimestampFormatter;
import com.zappos.json.format.NoOpValueFormatter;
import java.time.Clock;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.IsoChronology;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockClock;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class AbstractValueFormatter_ESTest extends AbstractValueFormatter_ESTest_scaffolding {
    @Test
    public void testIsJsString() {
        AbstractValueFormatter valueFormatter = new AbstractValueFormatter() {
            // Mock implementation for testing purposes
            @Override
            public String formatObject(ZapposJson zapposJson, Object object) {
                return null;
            }

            @Override
            public ValueFormatter<T> setPattern(String pattern) {
                return null;
            }

            @Override
            public String getPattern() {
                return null;
            }

            @Override
            public String toJsonValue(ZapposJson zapposJson, String value) {
                return null;
            }

            @Override
            public void setJsString(boolean jsString) {
                // Do nothing for testing
            }
        };

        // Test when jsString is true
        valueFormatter.setJsString(true);
        assertTrue(valueFormatter.isJsString());

        // Test when jsString is false
        valueFormatter.setJsString(false);
        assertFalse(valueFormatter.isJsString());
    }
}
