original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/TextChunk_ESTest.java
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
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.291 s
[INFO] Finished at: 2024-05-01T00:22:42+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US

########## Test INFO ##########
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
[INFO] 
[INFO] --- surefire:2.22.2:test (default-test) @ tabula ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running technology.tabula.TextChunk_ESTest
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 1.602 s <<< FAILURE! - in technology.tabula.TextChunk_ESTest
[ERROR] testGroupByLines(technology.tabula.TextChunk_ESTest)  Time elapsed: 0.027 s  <<< FAILURE!
java.lang.AssertionError: expected:<2> but was:<1>
	at technology.tabula.TextChunk_ESTest.testGroupByLines(TextChunk_ESTest.java:48)

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Failures: 
[ERROR]   TextChunk_ESTest.testGroupByLines:48 expected:<2> but was:<1>
[INFO] 
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.552 s
[INFO] Finished at: 2024-05-01T00:22:52+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.2:test (default-test) on project tabula: There are test failures.
[ERROR] 
[ERROR] Please refer to /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextChunk_ESTest
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextChunk_ESTest'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextChunk_ESTest_scaffolding
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextChunk_ESTest_scaffolding'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.TextChunk_ESTest_scaffolding
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.TextChunk_ESTest
Warning: the font "Times" is not available, so "Lucida Bright" has been substituted, but may have unexpected appearance or behavor. Re-enable the "Times" font to remove this warning.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.HasText
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.HasText'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.HasText
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Rectangle'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Rectangle
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Rectangle$1'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextChunk
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextChunk'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/TextChunk
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/TextChunk
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.RectangularTextContainer'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.TextChunk
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextElement
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextElement'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/TextElement
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/TextElement
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field AVERAGE_CHAR_TOLERANCE
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.TextElement
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextChunk$DirectionalityOptions
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextChunk$DirectionalityOptions'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/TextChunk$DirectionalityOptions
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/TextChunk$DirectionalityOptions
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.TextChunk$DirectionalityOptions
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Line
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Line'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Line
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/Line
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Line
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Ruling'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Ruling
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.font.PDFont
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.font.PDFont'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/apache/pdfbox/pdmodel/font/PDFont
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/apache/pdfbox/pdmodel/font/PDFont
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.pdmodel.font, -912444985
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.common.COSObjectable
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.common.COSObjectable'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.pdmodel.common, -772222621
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.common.COSObjectable
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.font.PDFontLike
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.font.PDFontLike'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.font.PDFontLike
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.font.PDFont
