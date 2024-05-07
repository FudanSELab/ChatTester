/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:17:49 GMT 2024
 */
package me.gosimple.nbvcxz.matching;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import me.gosimple.nbvcxz.matching.DictionaryMatcher;
import me.gosimple.nbvcxz.matching.PasswordMatcher;
import me.gosimple.nbvcxz.matching.match.Match;
import me.gosimple.nbvcxz.resources.AdjacencyGraph;
import me.gosimple.nbvcxz.resources.Configuration;
import me.gosimple.nbvcxz.resources.Dictionary;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class DictionaryMatcher_ESTest extends DictionaryMatcher_ESTest_scaffolding {
    @Test(timeout = 4000)
    public void test8() throws Throwable {
        DictionaryMatcher dictionaryMatcher0 = new DictionaryMatcher();
        HashMap<String, Long> hashMap0 = new HashMap<String, Long>();
        LinkedList<Dictionary> linkedList0 = new LinkedList<Dictionary>();
        LinkedList<AdjacencyGraph> linkedList1 = new LinkedList<AdjacencyGraph>();
        HashMap<Character, Character[]> hashMap1 = new HashMap<Character, Character[]>();
        Integer integer0 = new Integer(24);
        HashMap<String, Integer> hashMap2 = new HashMap<String, Integer>();
        hashMap2.put("Threshold must not be negative", integer0);
        Dictionary dictionary0 = new Dictionary("Threshold must not be negative", hashMap2, false);
        linkedList0.add(dictionary0);
        Pattern pattern0 = Pattern.compile("Threshold must not be negative", 24);
        Double double0 = new Double(24);
        Locale locale0 = Locale.forLanguageTag("Threshold must not be negative");
        Configuration configuration0 = new Configuration((List<PasswordMatcher>) null, hashMap0, linkedList0, linkedList1, hashMap1, pattern0, double0, (Integer) null, locale0, true, 2394L);
        Character character0 = new Character('n');
        Character[] characterArray0 = new Character[1];
        characterArray0[0] = character0;
        hashMap1.put(character0, characterArray0);
        List<Match> list0 = dictionaryMatcher0.match(configuration0, "Threshold must not be negative");
        assertEquals(1, list0.size());
    }
}
