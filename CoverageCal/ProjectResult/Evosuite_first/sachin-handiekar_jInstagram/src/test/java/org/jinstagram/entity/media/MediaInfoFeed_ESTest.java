/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:05:00 GMT 2024
 */
package org.jinstagram.entity.media;


import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.media.MediaInfoFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class MediaInfoFeed_ESTest extends MediaInfoFeed_ESTest_scaffolding {


@Test(timeout = 4000)
public void test0() throws Throwable {
    MediaInfoFeed mediaInfoFeed0 = new MediaInfoFeed();
    String string0 = mediaInfoFeed0.toString();
    assertEquals("MediaInfoFeed [data=null, meta=null]", string0);
}


@Test(timeout = 4000)
public void test1() throws Throwable {
    MediaInfoFeed mediaInfoFeed0 = new MediaInfoFeed();
    Meta meta0 = new Meta();
    mediaInfoFeed0.setMeta(meta0);
    meta0.setCode(173);
    Meta meta1 = mediaInfoFeed0.getMeta();
    assertSame(meta1, meta0);
}


@Test(timeout = 4000)
public void test2() throws Throwable {
    MediaInfoFeed mediaInfoFeed0 = new MediaInfoFeed();
    MediaFeedData mediaFeedData0 = new MediaFeedData();
    mediaInfoFeed0.setData(mediaFeedData0);
    MediaFeedData mediaFeedData1 = mediaInfoFeed0.getData();
    assertNull(mediaFeedData1.getType());
}

}
