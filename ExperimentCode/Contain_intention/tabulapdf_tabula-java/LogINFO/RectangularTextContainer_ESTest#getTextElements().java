original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] ----------------------< technology.tabula:tabula >----------------------
[INFO] Building Tabula 1.0.6-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for org.evosuite:evosuite-standalone-runtime:jar:1.2.0 is missing, no dependency information available
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ tabula ---
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/main/resources
[INFO] 
[INFO] --- compiler:3.8.1:compile (default-compile) @ tabula ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ tabula ---
[INFO] Copying 334 resources from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.8.1:testCompile (default-testCompile) @ tabula ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[10,19] package org.mockito does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[30,54] cannot find symbol
  symbol:   class ArrayList
  location: class technology.tabula.RectangularTextContainer_ESTest
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[31,34] no suitable constructor found for TextElement(java.lang.String)
    constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float) is not applicable
      (actual and formal argument lists differ in length)
    constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float,float) is not applicable
      (actual and formal argument lists differ in length)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[32,34] no suitable constructor found for TextElement(java.lang.String)
    constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float) is not applicable
      (actual and formal argument lists differ in length)
    constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float,float) is not applicable
      (actual and formal argument lists differ in length)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[35,59] cannot find symbol
  symbol:   variable Mockito
  location: class technology.tabula.RectangularTextContainer_ESTest
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[38,9] cannot find symbol
  symbol:   variable Mockito
  location: class technology.tabula.RectangularTextContainer_ESTest
[INFO] 6 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.249 s
[INFO] Finished at: 2024-05-01T00:34:00+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:testCompile (default-testCompile) on project tabula: Compilation failure: Compilation failure: 
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[10,19] package org.mockito does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[30,54] cannot find symbol
[ERROR]   symbol:   class ArrayList
[ERROR]   location: class technology.tabula.RectangularTextContainer_ESTest
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[31,34] no suitable constructor found for TextElement(java.lang.String)
[ERROR]     constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float,float) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[32,34] no suitable constructor found for TextElement(java.lang.String)
[ERROR]     constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor technology.tabula.TextElement.TextElement(float,float,float,float,org.apache.pdfbox.pdmodel.font.PDFont,float,java.lang.String,float,float) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[35,59] cannot find symbol
[ERROR]   symbol:   variable Mockito
[ERROR]   location: class technology.tabula.RectangularTextContainer_ESTest
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/RectangularTextContainer_ESTest.java:[38,9] cannot find symbol
[ERROR]   symbol:   variable Mockito
[ERROR]   location: class technology.tabula.RectangularTextContainer_ESTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
