// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/locations/LocationInfo_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:01:27 GMT 2024
 */
package org.jinstagram.entity.locations;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Location;
import org.jinstagram.entity.locations.LocationInfo;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class LocationInfo_ESTest extends LocationInfo_ESTest_scaffolding {
    @Test
    public void testToString() {
        LocationInfo locationInfo = new LocationInfo();
        Location locationData = new Location();
        locationData.setLatitude(40.7128);
        locationData.setLongitude(74.0060);
        locationInfo.setLocationData(locationData);

        String expected = "LocationInfo [locationData=Location{latitude=40.7128, longitude=74.0060}]";
        String actual = locationInfo.toString();

        assertEquals(expected, actual);
    }
}
