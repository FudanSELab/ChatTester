// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/tags/TagSearchFeed_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:18:17 GMT 2024
 */
package org.jinstagram.entity.tags;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.tags.TagSearchFeed;
import org.junit.runner.RunWith;

import java.util.*;
import java.lang.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.tags.TagSearchFeed;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.tags.TagSearchFeed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.entity.tags.TagSearchFeed;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class TagSearchFeed_ESTest extends TagSearchFeed_ESTest_scaffolding {

    @Test
    public void testSetMeta() {
        // Given
        TagSearchFeed tagSearchFeed = new TagSearchFeed();
        Meta meta = new Meta();
        
        // When
        tagSearchFeed.setMeta(meta);
        
        // Then
        assertEquals(meta, tagSearchFeed.getMeta());
    }

@Test
public void testSetTagList() {
    TagSearchFeed tagSearchFeed = new TagSearchFeed();
    List<TagInfoData> newTagList = new LinkedList<TagInfoData>();

    newTagList.add(new TagInfoData());
    newTagList.get(0).setTagName("tag1");

    newTagList.add(new TagInfoData());
    newTagList.get(1).setTagName("tag2");

    tagSearchFeed.setTagList(newTagList);
    List<TagInfoData> updatedTagList = tagSearchFeed.getTagList();
    assertEquals(newTagList, updatedTagList);
}

    @Test
    public void testGetMeta() {
        TagSearchFeed tagSearchFeed = new TagSearchFeed();
        Meta meta = new Meta();
        tagSearchFeed.setMeta(meta);

        Meta retrievedMeta = tagSearchFeed.getMeta();

        assertNotNull("Meta object should not be null", retrievedMeta);
    }

}
