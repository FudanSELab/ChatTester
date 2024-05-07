original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java
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
[INFO] Some messages have been simplified; recompile with -Xdiags:verbose to get full output
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java:[31,32] no suitable constructor found for TextChunk(java.lang.String)
    constructor technology.tabula.TextChunk.TextChunk(technology.tabula.TextElement) is not applicable
      (argument mismatch; java.lang.String cannot be converted to technology.tabula.TextElement)
    constructor technology.tabula.TextChunk.TextChunk(java.util.List<technology.tabula.TextElement>) is not applicable
      (argument mismatch; java.lang.String cannot be converted to java.util.List<technology.tabula.TextElement>)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java:[32,32] no suitable constructor found for TextChunk(java.lang.String)
    constructor technology.tabula.TextChunk.TextChunk(technology.tabula.TextElement) is not applicable
      (argument mismatch; java.lang.String cannot be converted to technology.tabula.TextElement)
    constructor technology.tabula.TextChunk.TextChunk(java.util.List<technology.tabula.TextElement>) is not applicable
      (argument mismatch; java.lang.String cannot be converted to java.util.List<technology.tabula.TextElement>)
[INFO] 2 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.251 s
[INFO] Finished at: 2024-05-01T00:29:43+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:testCompile (default-testCompile) on project tabula: Compilation failure: Compilation failure: 
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java:[31,32] no suitable constructor found for TextChunk(java.lang.String)
[ERROR]     constructor technology.tabula.TextChunk.TextChunk(technology.tabula.TextElement) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to technology.tabula.TextElement)
[ERROR]     constructor technology.tabula.TextChunk.TextChunk(java.util.List<technology.tabula.TextElement>) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to java.util.List<technology.tabula.TextElement>)
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java:[32,32] no suitable constructor found for TextChunk(java.lang.String)
[ERROR]     constructor technology.tabula.TextChunk.TextChunk(technology.tabula.TextElement) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to technology.tabula.TextElement)
[ERROR]     constructor technology.tabula.TextChunk.TextChunk(java.util.List<technology.tabula.TextElement>) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to java.util.List<technology.tabula.TextElement>)
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
