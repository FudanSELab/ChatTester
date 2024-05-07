// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/locations/LocationSearchFeed_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:03:11 GMT 2024
 */
package org.jinstagram.entity.locations;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Location;
import org.jinstagram.entity.locations.LocationSearchFeed;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class LocationSearchFeed_ESTest extends LocationSearchFeed_ESTest_scaffolding {
    @Test
    public void testGetLocationList() {
        // Create a LocationSearchFeed instance
        LocationSearchFeed locationSearchFeed = new LocationSearchFeed();

        // Create a list of Location objects
        List<Location> expectedLocationList = new LinkedList<>();
        expectedLocationList.add(new Location("Location 1"));
        expectedLocationList.add(new Location("Location 2"));

        // Set the locationList in the LocationSearchFeed instance
        locationSearchFeed.setLocationList(expectedLocationList);

        // Retrieve the locationList using getLocationList()
        List<Location> actualLocationList = locationSearchFeed.getLocationList();

        // Check if the retrieved locationList is not null
        assertNotNull(actualLocationList);

        // Check if the retrieved locationList size matches the expected size
        assertEquals(expectedLocationList.size(), actualLocationList.size());

        // Check if the contents of the retrieved locationList match the expected contents
        for (int i = 0; i < expectedLocationList.size(); i++) {
            assertEquals(expectedLocationList.get(i).getName(), actualLocationList.get(i).getName());
        }
    }
}
