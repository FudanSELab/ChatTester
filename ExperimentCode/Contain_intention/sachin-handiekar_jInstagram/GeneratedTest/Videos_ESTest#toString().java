// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Videos_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:57:54 GMT 2024
 */
package org.jinstagram.entity.common;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.VideoData;
import org.jinstagram.entity.common.Videos;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Videos_ESTest extends Videos_ESTest_scaffolding {
    @Test
    public void testToString() {
        Videos videos = new Videos();
        VideoData lowResolution = new VideoData();
        lowResolution.setUrl("low_res_url");
        lowResolution.setWidth(480);
        lowResolution.setHeight(360);
        
        VideoData standardResolution = new VideoData();
        standardResolution.setUrl("std_res_url");
        standardResolution.setWidth(1280);
        standardResolution.setHeight(720);
        
        videos.setLowResolution(lowResolution);
        videos.setStandardResolution(standardResolution);
        
        String expected = "Videos [lowResolution=VideoData{url='low_res_url', width=480, height=360}, standardResolution=VideoData{url='std_res_url', width=1280, height=720}]";
        String actual = videos.toString();
        
        assertEquals(expected, actual);
    }
}
