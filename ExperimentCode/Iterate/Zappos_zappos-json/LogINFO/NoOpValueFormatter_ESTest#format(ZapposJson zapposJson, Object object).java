original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/java/com/zappos/json/format/NoOpValueFormatter_ESTest.java
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] -----------------------< com.zappos:zappos-json >-----------------------
[INFO] Building zappos-json 0.1-alpha
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for org.evosuite:evosuite-standalone-runtime:jar:1.2.0 is missing, no dependency information available
[INFO] 
[INFO] --- enforcer:1.4.1:enforce (enforce-java) @ zappos-json ---
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ zappos-json ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ zappos-json ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ zappos-json ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ zappos-json ---
[INFO] Changes detected - recompiling the module! :source
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files with javac [debug target 1.7] to target/test-classes
[WARNING] bootstrap class path not set in conjunction with -source 1.7
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.051 s
[INFO] Finished at: 2024-05-03T23:59:32+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US

########## Test INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] -----------------------< com.zappos:zappos-json >-----------------------
[INFO] Building zappos-json 0.1-alpha
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for org.evosuite:evosuite-standalone-runtime:jar:1.2.0 is missing, no dependency information available
[INFO] 
[INFO] --- enforcer:1.4.1:enforce (enforce-java) @ zappos-json ---
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ zappos-json ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ zappos-json ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ zappos-json ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ zappos-json ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:3.1.2:test (default-test) @ zappos-json ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.zappos.json.format.NoOpValueFormatter_ESTest
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.021 s <<< FAILURE! -- in com.zappos.json.format.NoOpValueFormatter_ESTest
[ERROR] com.zappos.json.format.NoOpValueFormatter_ESTest -- Time elapsed: 0.006 s <<< ERROR!
java.lang.Exception: No runnable methods
	at org.junit.runners.BlockJUnit4ClassRunner.validateInstanceMethods(BlockJUnit4ClassRunner.java:191)
	at org.junit.runners.BlockJUnit4ClassRunner.collectInitializationErrors(BlockJUnit4ClassRunner.java:128)
	at org.junit.runners.ParentRunner.validate(ParentRunner.java:416)
	at org.junit.runners.ParentRunner.<init>(ParentRunner.java:84)
	at org.junit.runners.BlockJUnit4ClassRunner.<init>(BlockJUnit4ClassRunner.java:65)
	at org.evosuite.runtime.EvoRunner.<init>(EvoRunner.java:76)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.junit.internal.builders.AnnotatedBuilder.buildRunner(AnnotatedBuilder.java:104)
	at org.junit.vintage.engine.discovery.DefensiveAllDefaultPossibilitiesBuilder$DefensiveAnnotatedBuilder.buildRunner(DefensiveAllDefaultPossibilitiesBuilder.java:114)
	at org.junit.internal.builders.AnnotatedBuilder.runnerForClass(AnnotatedBuilder.java:86)
	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
	at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:26)
	at org.junit.vintage.engine.discovery.DefensiveAllDefaultPossibilitiesBuilder.runnerForClass(DefensiveAllDefaultPossibilitiesBuilder.java:57)
	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
	at org.junit.vintage.engine.discovery.ClassSelectorResolver.resolveTestClass(ClassSelectorResolver.java:66)
	at org.junit.vintage.engine.discovery.ClassSelectorResolver.resolve(ClassSelectorResolver.java:47)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution.lambda$resolve$2(EngineDiscoveryRequestResolution.java:135)
	at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
	at java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1351)
	at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
	at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)
	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
	at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)
	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution.resolve(EngineDiscoveryRequestResolution.java:189)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution.resolve(EngineDiscoveryRequestResolution.java:126)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution.resolveCompletely(EngineDiscoveryRequestResolution.java:92)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution.run(EngineDiscoveryRequestResolution.java:83)
	at org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver.resolve(EngineDiscoveryRequestResolver.java:113)
	at org.junit.vintage.engine.discovery.VintageDiscoverer.discover(VintageDiscoverer.java:42)
	at org.junit.vintage.engine.VintageTestEngine.discover(VintageTestEngine.java:64)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverEngineRoot(EngineDiscoveryOrchestrator.java:152)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverSafely(EngineDiscoveryOrchestrator.java:132)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:107)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:78)
	at org.junit.platform.launcher.core.DefaultLauncher.discover(DefaultLauncher.java:110)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:86)
	at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:86)
	at org.apache.maven.surefire.junitplatform.LazyLauncher.execute(LazyLauncher.java:56)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.execute(JUnitPlatformProvider.java:184)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invokeAllTests(JUnitPlatformProvider.java:148)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invoke(JUnitPlatformProvider.java:122)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   NoOpValueFormatter_ESTest »  No runnable methods
[INFO] 
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.624 s
[INFO] Finished at: 2024-05-03T23:59:39+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project zappos-json: 
[ERROR] 
[ERROR] Please refer to /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/Zappos_zappos-json/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
