/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:06:07 GMT 2024
 */
package me.gosimple.nbvcxz.resources;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import me.gosimple.nbvcxz.matching.PasswordMatcher;
import me.gosimple.nbvcxz.resources.AdjacencyGraph;
import me.gosimple.nbvcxz.resources.Configuration;
import me.gosimple.nbvcxz.resources.Dictionary;
import me.gosimple.nbvcxz.resources.Feedback;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Feedback_ESTest extends Feedback_ESTest_scaffolding {
    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Feedback feedback0 = new Feedback((Configuration) null, ",Yc/F/M");
        String string0 = feedback0.getWarningKey();
        assertNull(string0);
    }
    
    @Test(timeout = 4000)
    public void test01() throws Throwable {
        LinkedList<PasswordMatcher> linkedList0 = new LinkedList<PasswordMatcher>();
        HashMap<String, Long> hashMap0 = new HashMap<String, Long>();
        LinkedList<Dictionary> linkedList1 = new LinkedList<Dictionary>();
        HashMap<Character, Character[]> hashMap1 = new HashMap<Character, Character[]>();
        Pattern pattern0 = Pattern.compile("6D@nHz?M5VNtNSS>rno");
        Integer integer0 = new Integer((-1478));
        Locale locale0 = new Locale("6D@nHz?M5VNtNSS>rno", "");
        Configuration configuration0 = new Configuration(linkedList0, hashMap0, linkedList1, (List<AdjacencyGraph>) null, hashMap1, pattern0, (Double) null, integer0, locale0, true, (-1478));
        String[] stringArray0 = new String[4];
        Feedback feedback0 = new Feedback(configuration0, "", "qLChsId", stringArray0);
        String string0 = feedback0.getWarningKey();
        assertEquals("qLChsId", string0);
        assertEquals("", feedback0.getResult());
    }
    
    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Feedback feedback0 = new Feedback((Configuration) null, "");
        List<String> list0 = feedback0.getSuggestionKeys();
        assertEquals(0, list0.size());
    }
}
