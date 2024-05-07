// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/users/feed/CarouselMedia_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:26:18 GMT 2024
 */
package org.jinstagram.entity.users.feed;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import org.jinstagram.entity.common.UsersInPhoto;
import org.jinstagram.entity.users.feed.CarouselMedia;
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
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class CarouselMedia_ESTest extends CarouselMedia_ESTest_scaffolding {
    @Test
    public void testSetUsersInPhotoList() {
        // Create a CarouselMedia instance
        CarouselMedia carouselMedia = new CarouselMedia();
        
        // Create a list of UsersInPhoto objects
        List<UsersInPhoto> usersInPhotoList = new LinkedList<>();
        UsersInPhoto user1 = new UsersInPhoto();
        UsersInPhoto user2 = new UsersInPhoto();
        usersInPhotoList.add(user1);
        usersInPhotoList.add(user2);
        
        // Set the list of UsersInPhoto objects using the setUsersInPhotoList method
        carouselMedia.setUsersInPhotoList(usersInPhotoList);
        
        // Verify that the list of UsersInPhoto objects has been set correctly
        List<UsersInPhoto> retrievedUsersInPhotoList = carouselMedia.getUsersInPhotoList();
        assertEquals(usersInPhotoList, retrievedUsersInPhotoList);
    }
}
