/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:57:41 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Pair;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Pair_ESTest extends Pair_ESTest_scaffolding {
    @Test 
    public void testGetRight() throws Exception { 
    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1, 2);
    assertEquals(2, pair.getRight().intValue());
    }
    
}
