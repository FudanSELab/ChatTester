original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Table_ESTest.java
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
[INFO] Total time:  3.165 s
[INFO] Finished at: 2024-05-01T00:26:54+08:00
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
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:2.22.2:test (default-test) @ tabula ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running technology.tabula.Table_ESTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.751 s - in technology.tabula.Table_ESTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.082 s
[INFO] Finished at: 2024-05-01T00:27:03+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en -Duser.country=US
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Table_ESTest
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Table_ESTest'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Table_ESTest_scaffolding
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Table_ESTest_scaffolding'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Table_ESTest_scaffolding
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Table_ESTest
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.extractors.ExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.extractors.ExtractionAlgorithm'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.extractors.ExtractionAlgorithm
Warning: the font "Times" is not available, so "Lucida Bright" has been substituted, but may have unexpected appearance or behavor. Re-enable the "Times" font to remove this warning.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.HasText
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.HasText'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.HasText
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Cell
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Cell'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Cell
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/Cell
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.RectangularTextContainer'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Rectangle'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Rectangle
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Rectangle
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.RectangularTextContainer
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Cell
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Rectangle$1'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Rectangle$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.TextChunk
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.TextChunk'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/TextChunk
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/TextChunk
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
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.CellPosition
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.CellPosition'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/CellPosition
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/CellPosition
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.CellPosition
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Table
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Table'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Table
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/Table
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Table
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.extractors.SpreadsheetExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.extractors.SpreadsheetExtractionAlgorithm'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/extractors/SpreadsheetExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/extractors/SpreadsheetExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.extractors.SpreadsheetExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Ruling'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Ruling
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class technology/tabula/Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Ruling
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Page
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Page'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Page
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/Page
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field DEFAULT_MIN_CHAR_LENGTH
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Page
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.PDDocument
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.PDDocument'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/apache/pdfbox/pdmodel/PDDocument
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/apache/pdfbox/pdmodel/PDDocument
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.pdmodel, 2144800118
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.PDDocument
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.RectangleSpatialIndex
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.RectangleSpatialIndex'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/RectangleSpatialIndex
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/RectangleSpatialIndex
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.RectangleSpatialIndex
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.PDPage
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.PDPage'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/apache/pdfbox/pdmodel/PDPage
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/apache/pdfbox/pdmodel/PDPage
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.common.COSObjectable
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.common.COSObjectable'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.pdmodel.common, -772222621
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.common.COSObjectable
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.contentstream.PDContentStream
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.contentstream.PDContentStream'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.contentstream, 1430091834
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.contentstream.PDContentStream
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.PDPage
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.font.PDFont
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.font.PDFont'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/apache/pdfbox/pdmodel/font/PDFont
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/apache/pdfbox/pdmodel/font/PDFont
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.apache.pdfbox.pdmodel.font, -912444985
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.apache.pdfbox.pdmodel.font.PDFontLike
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.apache.pdfbox.pdmodel.font.PDFontLike'.
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.font.PDFontLike
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.apache.pdfbox.pdmodel.font.PDFont
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.extractors.BasicExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.extractors.BasicExtractionAlgorithm'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/extractors/BasicExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class technology/tabula/extractors/BasicExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.extractors.BasicExtractionAlgorithm
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Ruling$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Ruling$1'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Ruling$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Ruling$1
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: technology.tabula.Ruling$2
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'technology.tabula.Ruling$2'.
[main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class technology/tabula/Ruling$2
[main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: technology.tabula.Ruling$2
