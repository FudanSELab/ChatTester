/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:59:43 GMT 2024
 */
package org.jinstagram.entity.likes;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.common.User;
import org.jinstagram.entity.likes.LikesFeed;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class LikesFeed_ESTest extends LikesFeed_ESTest_scaffolding {
    @Test 
    public void testSetMeta() { 
    LikesFeed feed = new LikesFeed();
    feed.setMeta(new Meta());
    }
    
}
