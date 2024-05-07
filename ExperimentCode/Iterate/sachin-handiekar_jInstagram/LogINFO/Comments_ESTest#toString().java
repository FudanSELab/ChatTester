original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/entity/common/Comments_ESTest.java
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
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.084 s
[INFO] Finished at: 2024-05-04T01:04:46+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US

########## Test INFO ##########
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
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:3.1.2:test (default-test) @ jInstagram ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
01:04:52.794 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.common.Comments_ESTest
01:04:52.797 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.common.Comments_ESTest'.
01:04:52.825 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.common.Comments_ESTest_scaffolding
01:04:52.825 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.common.Comments_ESTest_scaffolding'.
01:04:52.828 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.common.Comments_ESTest_scaffolding
01:04:52.828 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.common.Comments_ESTest
01:04:52.908 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.common.Comments_ESTest
01:04:52.909 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.common.Comments_ESTest'.
01:04:52.910 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.common.Comments_ESTest_scaffolding
01:04:52.910 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.common.Comments_ESTest_scaffolding'.
01:04:52.913 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.common.Comments_ESTest_scaffolding
01:04:52.913 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.common.Comments_ESTest
[INFO] Running org.jinstagram.entity.common.Comments_ESTest
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.020 s <<< FAILURE! -- in org.jinstagram.entity.common.Comments_ESTest
[ERROR] org.jinstagram.entity.common.Comments_ESTest -- Time elapsed: 0.004 s <<< ERROR!
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
[ERROR]   Comments_ESTest »  No runnable methods
[INFO] 
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.396 s
[INFO] Finished at: 2024-05-04T01:04:53+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project jInstagram: 
[ERROR] 
[ERROR] Please refer to /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/target/surefire-reports for the individual test results.
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
