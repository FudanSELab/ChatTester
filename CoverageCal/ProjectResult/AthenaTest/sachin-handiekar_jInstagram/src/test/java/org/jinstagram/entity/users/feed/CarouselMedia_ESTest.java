/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:26:18 GMT 2024
 */
package org.jinstagram.entity.users.feed;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Images;
import org.jinstagram.entity.common.UsersInPhoto;
import org.jinstagram.entity.common.Videos;
import org.jinstagram.entity.users.feed.CarouselMedia;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class CarouselMedia_ESTest extends CarouselMedia_ESTest_scaffolding {
    @Test 
    public void testSetType() { 
    CarouselMedia media = new CarouselMedia();
    media.setType("test");
    assertEquals("test", media.getType());
    }
    
}
