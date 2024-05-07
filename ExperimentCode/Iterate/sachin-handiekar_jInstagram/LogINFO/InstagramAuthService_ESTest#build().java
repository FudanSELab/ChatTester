original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] -------------------< com.sachinhandiekar:jInstagram >-------------------
[INFO] Building jInstagram 1.2.3-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for org.evosuite:evosuite-standalone-runtime:jar:1.2.0 is missing, no dependency information available
[INFO] 
[INFO] --- enforcer:1.0:enforce (enforce-maven) @ jInstagram ---
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ jInstagram ---
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/main/resources
[INFO] 
[INFO] --- compiler:3.0:compile (default-compile) @ jInstagram ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ jInstagram ---
[INFO] Copying 3 resources from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.0:testCompile (default-testCompile) @ jInstagram ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[20,27] cannot find symbol
  symbol:   class InstagramService
  location: package org.jinstagram.auth
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[22,24] package org.scribe.model does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[23,24] package org.scribe.model does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[24,29] package org.scribe.exceptions does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[51,16] cannot find symbol
  symbol:   method setApiKey(java.lang.String)
  location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[52,16] cannot find symbol
  symbol:   method setApiSecret(java.lang.String)
  location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[53,16] cannot find symbol
  symbol:   method setCallback(java.lang.String)
  location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[54,16] cannot find symbol
  symbol:   method setScope(java.lang.String)
  location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[55,16] cannot find symbol
  symbol:   method setDisplay(java.lang.String)
  location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[58,5] cannot find symbol
  symbol:   class InstagramService
  location: class org.jinstagram.auth.InstagramAuthService_ESTest
[INFO] 10 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.011 s
[INFO] Finished at: 2024-05-04T00:30:34+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.0:testCompile (default-testCompile) on project jInstagram: Compilation failure: Compilation failure: 
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[20,27] cannot find symbol
[ERROR]   symbol:   class InstagramService
[ERROR]   location: package org.jinstagram.auth
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[22,24] package org.scribe.model does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[23,24] package org.scribe.model does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[24,29] package org.scribe.exceptions does not exist
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[51,16] cannot find symbol
[ERROR]   symbol:   method setApiKey(java.lang.String)
[ERROR]   location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[52,16] cannot find symbol
[ERROR]   symbol:   method setApiSecret(java.lang.String)
[ERROR]   location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[53,16] cannot find symbol
[ERROR]   symbol:   method setCallback(java.lang.String)
[ERROR]   location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[54,16] cannot find symbol
[ERROR]   symbol:   method setScope(java.lang.String)
[ERROR]   location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[55,16] cannot find symbol
[ERROR]   symbol:   method setDisplay(java.lang.String)
[ERROR]   location: variable authService of type org.jinstagram.auth.InstagramAuthService
[ERROR] /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/InstagramAuthService_ESTest.java:[58,5] cannot find symbol
[ERROR]   symbol:   class InstagramService
[ERROR]   location: class org.jinstagram.auth.InstagramAuthService_ESTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
