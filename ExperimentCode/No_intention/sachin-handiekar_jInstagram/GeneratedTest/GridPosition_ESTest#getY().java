// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/GridPosition_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:38:49 GMT 2024
 */
package org.jinstagram.entity.common;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.GridPosition;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class GridPosition_ESTest extends GridPosition_ESTest_scaffolding {
    @Test
    public void testGetY() {
        // Create a new instance of GridPosition
        GridPosition gridPosition = new GridPosition();

        // Set the value of y using the setY() method
        double expectedY = 5.0;
        gridPosition.setY(expectedY);

        // Call the getY() method and assert that it returns the expected value
        double actualY = gridPosition.getY();
        assertEquals(expectedY, actualY, 0.001);
    }
}
