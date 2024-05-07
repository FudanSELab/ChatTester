original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/auth/oauth/InstagramService_ESTest.java
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
[INFO] Total time:  3.096 s
[INFO] Finished at: 2024-05-04T00:25:25+08:00
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
00:25:31.414 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.oauth.InstagramService_ESTest
00:25:31.420 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.oauth.InstagramService_ESTest'.
00:25:31.448 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding
00:25:31.448 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding'.
00:25:31.452 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding
00:25:31.452 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.oauth.InstagramService_ESTest
00:25:31.530 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.oauth.InstagramService_ESTest
00:25:31.530 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.oauth.InstagramService_ESTest'.
00:25:31.532 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding
00:25:31.532 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding'.
00:25:31.535 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.oauth.InstagramService_ESTest_scaffolding
00:25:31.535 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.oauth.InstagramService_ESTest
[INFO] Running org.jinstagram.auth.oauth.InstagramService_ESTest
00:25:32.514 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "Reference Handler"
00:25:32.514 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "Finalizer"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "Signal Dispatcher"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "AppKit Thread"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "AWT-Shutdown"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "Java2D Queue Flusher"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "Java2D Disposer"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "main"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "surefire-forkedjvm-stream-flusher"
00:25:32.515 [main] DEBUG org.evosuite.runtime.sandbox.MSecurityManager - Adding privileged thread: "surefire-forkedjvm-command-thread"
00:25:32.566 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.model.OAuthRequest
00:25:32.567 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.model.OAuthRequest'.
00:25:32.578 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/model/OAuthRequest
00:25:32.853 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/model/OAuthRequest
00:25:32.854 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field OAUTH_PREFIX
00:25:32.856 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.auth.model, -719554817
00:25:32.856 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.http.Request
00:25:32.856 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.http.Request'.
00:25:32.861 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/http/Request
00:25:32.876 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/http/Request
00:25:32.876 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field CONTENT_LENGTH
00:25:32.877 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.http, 898268452
00:25:32.877 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.http.Request
00:25:32.877 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.model.OAuthRequest
00:25:32.877 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.exceptions.OAuthException
00:25:32.878 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.exceptions.OAuthException'.
00:25:32.879 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/exceptions/OAuthException
00:25:32.881 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/exceptions/OAuthException
00:25:32.881 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.auth.exceptions, 1157870574
00:25:32.881 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.exceptions.OAuthException
00:25:32.883 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.InstagramApi
00:25:32.883 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.InstagramApi'.
00:25:32.884 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/InstagramApi
00:25:32.887 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/InstagramApi
00:25:32.887 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.auth, 898060868
00:25:32.887 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.InstagramApi
00:25:32.887 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.AccessTokenExtractor
00:25:32.887 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.AccessTokenExtractor'.
00:25:32.888 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.AccessTokenExtractor
00:25:32.889 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.http.Response
00:25:32.889 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.http.Response'.
00:25:32.890 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/http/Response
00:25:32.901 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/http/Response
00:25:32.901 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field EMPTY_RESPONSE
00:25:32.901 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.http.Response
00:25:32.902 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.http.Verbs
00:25:32.902 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.http.Verbs'.
00:25:32.902 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/http/Verbs
00:25:32.904 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/jinstagram/http/Verbs
00:25:32.905 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.http.Verbs
00:25:32.905 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.oauth.InstagramService
00:25:32.906 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.oauth.InstagramService'.
00:25:32.906 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/oauth/InstagramService
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/oauth/InstagramService
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field VERSION
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field AUTHORIZATION_CODE
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.oauth.InstagramService
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.InstagramClient
00:25:32.914 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.InstagramClient'.
00:25:32.918 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram, 657905618
00:25:32.918 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.InstagramClient
00:25:32.924 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.model.Verifier
00:25:32.924 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.model.Verifier'.
00:25:32.926 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/model/Verifier
00:25:32.929 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/model/Verifier
00:25:32.930 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.model.Verifier
00:25:32.930 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.model.OAuthConfig
00:25:32.930 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.model.OAuthConfig'.
00:25:32.931 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/model/OAuthConfig
00:25:32.932 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/model/OAuthConfig
00:25:32.933 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.model.OAuthConfig
00:25:32.934 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.auth.model.Token
00:25:32.935 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.auth.model.Token'.
00:25:32.935 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/auth/model/Token
00:25:32.941 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/auth/model/Token
00:25:32.941 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.auth.model.Token
00:25:32.942 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.utils.Preconditions
00:25:32.942 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.utils.Preconditions'.
00:25:32.944 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/utils/Preconditions
00:25:32.947 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/jinstagram/utils/Preconditions
00:25:32.947 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.utils, 2088513429
00:25:32.948 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.utils.Preconditions
00:25:32.949 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.users.feed.UserFeed
00:25:32.949 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.users.feed.UserFeed'.
00:25:32.951 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/users/feed/UserFeed
00:25:32.956 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/users/feed/UserFeed
00:25:32.958 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.users.feed, 1240399251
00:25:32.959 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.InstagramObject
00:25:32.959 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.InstagramObject'.
00:25:32.959 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/InstagramObject
00:25:32.961 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/InstagramObject
00:25:32.961 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.InstagramResponse
00:25:32.961 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.InstagramResponse'.
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.InstagramResponse
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.InstagramObject
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.users.feed.UserFeed
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.exceptions.InstagramException
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.exceptions.InstagramException'.
00:25:32.963 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/exceptions/InstagramException
00:25:32.968 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/exceptions/InstagramException
00:25:32.968 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.exceptions, 1332267424
00:25:32.969 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.exceptions.InstagramException
00:25:32.969 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.common.Pagination
00:25:32.970 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.common.Pagination'.
00:25:32.978 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/common/Pagination
00:25:32.979 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/common/Pagination
00:25:32.979 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.common, 1839157562
00:25:32.979 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.common.Pagination
00:25:32.979 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.tags.TagMediaFeed
00:25:32.979 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.tags.TagMediaFeed'.
00:25:32.980 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/tags/TagMediaFeed
00:25:32.985 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/tags/TagMediaFeed
00:25:32.985 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.tags, 1673913128
00:25:32.985 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.tags.TagMediaFeed
00:25:32.985 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.users.feed.MediaFeed
00:25:32.986 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.users.feed.MediaFeed'.
00:25:32.988 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/users/feed/MediaFeed
00:25:32.990 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/users/feed/MediaFeed
00:25:32.990 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.users.feed.MediaFeed
00:25:32.990 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.locations.LocationSearchFeed
00:25:32.991 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.locations.LocationSearchFeed'.
00:25:32.991 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/locations/LocationSearchFeed
00:25:32.991 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/locations/LocationSearchFeed
00:25:32.991 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.locations, -266159697
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.locations.LocationSearchFeed
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.users.basicinfo.UserInfo
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.users.basicinfo.UserInfo'.
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/users/basicinfo/UserInfo
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/users/basicinfo/UserInfo
00:25:32.992 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.users.basicinfo, 1911360263
00:25:32.993 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.users.basicinfo.UserInfo
00:25:32.994 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.tags.TagSearchFeed
00:25:32.994 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.tags.TagSearchFeed'.
00:25:32.994 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/tags/TagSearchFeed
00:25:32.995 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/tags/TagSearchFeed
00:25:32.995 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.tags.TagSearchFeed
00:25:32.996 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.locations.LocationInfo
00:25:32.996 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.locations.LocationInfo'.
00:25:32.996 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/locations/LocationInfo
00:25:32.997 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/locations/LocationInfo
00:25:32.997 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.locations.LocationInfo
00:25:32.998 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.tags.TagInfoFeed
00:25:32.998 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.tags.TagInfoFeed'.
00:25:32.999 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/tags/TagInfoFeed
00:25:33.000 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/tags/TagInfoFeed
00:25:33.000 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.tags.TagInfoFeed
00:25:33.000 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.likes.LikesFeed
00:25:33.000 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.likes.LikesFeed'.
00:25:33.002 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/likes/LikesFeed
00:25:33.002 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/likes/LikesFeed
00:25:33.002 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.likes, 344553101
00:25:33.002 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.likes.LikesFeed
00:25:33.003 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.comments.MediaCommentResponse
00:25:33.003 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.comments.MediaCommentResponse'.
00:25:33.007 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/comments/MediaCommentResponse
00:25:33.010 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/comments/MediaCommentResponse
00:25:33.010 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.comments, -2096403069
00:25:33.011 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.comments.MediaCommentResponse
00:25:33.011 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.comments.MediaCommentsFeed
00:25:33.011 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.comments.MediaCommentsFeed'.
00:25:33.013 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/comments/MediaCommentsFeed
00:25:33.016 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/comments/MediaCommentsFeed
00:25:33.017 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.comments.MediaCommentsFeed
00:25:33.017 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.media.MediaInfoFeed
00:25:33.017 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.media.MediaInfoFeed'.
00:25:33.018 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/media/MediaInfoFeed
00:25:33.018 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/media/MediaInfoFeed
00:25:33.018 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.media, 345350837
00:25:33.019 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.media.MediaInfoFeed
00:25:33.019 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.model.Relationship
00:25:33.019 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.model.Relationship'.
00:25:33.019 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/model/Relationship
00:25:33.022 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/jinstagram/model/Relationship
00:25:33.023 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.model, 2080971277
00:25:33.023 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.model.Relationship
00:25:33.023 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.entity.relationships.RelationshipFeed
00:25:33.023 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.entity.relationships.RelationshipFeed'.
00:25:33.024 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/entity/relationships/RelationshipFeed
00:25:33.024 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/entity/relationships/RelationshipFeed
00:25:33.024 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.jinstagram.entity.relationships, -836951284
00:25:33.025 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.entity.relationships.RelationshipFeed
00:25:33.065 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.Mockito
00:25:33.065 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.Mockito'.
00:25:33.070 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/Mockito
00:25:33.076 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/Mockito
00:25:33.078 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito, -218950192
00:25:33.079 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.Matchers
00:25:33.079 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.Matchers'.
00:25:33.090 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/Matchers
00:25:33.097 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/Matchers
00:25:33.100 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.Matchers
00:25:33.101 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.Mockito
00:25:33.101 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.hamcrest.Matcher
00:25:33.101 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.hamcrest.Matcher'.
00:25:33.110 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.hamcrest.SelfDescribing
00:25:33.110 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.hamcrest.SelfDescribing'.
00:25:33.111 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.hamcrest.SelfDescribing
00:25:33.111 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.hamcrest.Matcher
00:25:33.112 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.progress.MockingProgress
00:25:33.112 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.progress.MockingProgress'.
00:25:33.113 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.progress, -535423584
00:25:33.113 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.progress.MockingProgress
00:25:33.114 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.verification.VerificationMode
00:25:33.114 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.verification.VerificationMode'.
00:25:33.117 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.verification, -390341255
00:25:33.117 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.verification.VerificationMode
00:25:33.117 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.verification.VerificationAfterDelay
00:25:33.117 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.verification.VerificationAfterDelay'.
00:25:33.118 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.verification.VerificationAfterDelay
00:25:33.118 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.MockitoDebugger
00:25:33.118 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.MockitoDebugger'.
00:25:33.119 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.MockitoDebugger
00:25:33.119 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.stubbing.Answer
00:25:33.120 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.stubbing.Answer'.
00:25:33.123 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.stubbing, 1147178060
00:25:33.123 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.stubbing.Answer
00:25:33.124 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.verification.VerificationWithTimeout
00:25:33.124 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.verification.VerificationWithTimeout'.
00:25:33.127 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.verification.VerificationWithTimeout
00:25:33.128 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.progress.ThreadSafeMockingProgress
00:25:33.128 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.progress.ThreadSafeMockingProgress'.
00:25:33.130 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/progress/ThreadSafeMockingProgress
00:25:33.137 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/internal/progress/ThreadSafeMockingProgress
00:25:33.138 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.progress.ThreadSafeMockingProgress
00:25:33.139 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.MockitoCore
00:25:33.139 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.MockitoCore'.
00:25:33.142 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/MockitoCore
00:25:33.156 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/MockitoCore
00:25:33.157 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal, -156488421
00:25:33.157 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.MockitoCore
00:25:33.158 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.InOrder
00:25:33.158 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.InOrder'.
00:25:33.159 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.InOrder
00:25:33.159 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.MockingDetails
00:25:33.159 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.MockingDetails'.
00:25:33.161 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.MockingDetails
00:25:33.161 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.NotAMockException
00:25:33.161 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.NotAMockException'.
00:25:33.161 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/NotAMockException
00:25:33.162 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/NotAMockException
00:25:33.163 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.exceptions.misusing, -1043487719
00:25:33.163 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.base.MockitoException
00:25:33.163 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.base.MockitoException'.
00:25:33.163 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/base/MockitoException
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/base/MockitoException
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.exceptions.base, 2039938141
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.base.MockitoException
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.NotAMockException
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.verification.api.VerificationData
00:25:33.164 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.verification.api.VerificationData'.
00:25:33.165 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.verification.api, -1145445318
00:25:33.165 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.verification.api.VerificationData
00:25:33.165 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.stubbing.InvocationContainer
00:25:33.165 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.stubbing.InvocationContainer'.
00:25:33.166 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.stubbing, -1955235487
00:25:33.166 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.stubbing.InvocationContainer
00:25:33.166 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.verification.api.VerificationDataInOrder
00:25:33.166 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.verification.api.VerificationDataInOrder'.
00:25:33.167 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.verification.api.VerificationDataInOrder
00:25:33.167 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.Reporter
00:25:33.167 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.Reporter'.
00:25:33.169 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/Reporter
00:25:33.184 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/Reporter
00:25:33.192 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.exceptions, 215384290
00:25:33.193 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.Reporter
00:25:33.193 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.NullInsteadOfMockException
00:25:33.193 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.NullInsteadOfMockException'.
00:25:33.195 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/NullInsteadOfMockException
00:25:33.195 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/NullInsteadOfMockException
00:25:33.196 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.NullInsteadOfMockException
00:25:33.196 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.MissingMethodInvocationException
00:25:33.196 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.MissingMethodInvocationException'.
00:25:33.197 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/MissingMethodInvocationException
00:25:33.197 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/MissingMethodInvocationException
00:25:33.197 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.MissingMethodInvocationException
00:25:33.197 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.UnfinishedStubbingException
00:25:33.197 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.UnfinishedStubbingException'.
00:25:33.198 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/UnfinishedStubbingException
00:25:33.199 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/UnfinishedStubbingException
00:25:33.199 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.UnfinishedStubbingException
00:25:33.200 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.InvalidUseOfMatchersException
00:25:33.200 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.InvalidUseOfMatchersException'.
00:25:33.201 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/InvalidUseOfMatchersException
00:25:33.201 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/InvalidUseOfMatchersException
00:25:33.201 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.InvalidUseOfMatchersException
00:25:33.201 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock
00:25:33.201 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock'.
00:25:33.202 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/CannotVerifyStubOnlyMock
00:25:33.202 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/CannotVerifyStubOnlyMock
00:25:33.202 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock
00:25:33.203 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.WantedButNotInvoked
00:25:33.203 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.WantedButNotInvoked'.
00:25:33.205 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/WantedButNotInvoked
00:25:33.206 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/WantedButNotInvoked
00:25:33.206 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.exceptions.verification, -862552153
00:25:33.206 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.base.MockitoAssertionError
00:25:33.206 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.base.MockitoAssertionError'.
00:25:33.207 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/base/MockitoAssertionError
00:25:33.207 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/base/MockitoAssertionError
00:25:33.208 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.base.MockitoAssertionError
00:25:33.208 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.WantedButNotInvoked
00:25:33.208 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.TooManyActualInvocations
00:25:33.208 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.TooManyActualInvocations'.
00:25:33.209 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/TooManyActualInvocations
00:25:33.209 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/TooManyActualInvocations
00:25:33.209 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.TooManyActualInvocations
00:25:33.209 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.NeverWantedButInvoked
00:25:33.209 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.NeverWantedButInvoked'.
00:25:33.210 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/NeverWantedButInvoked
00:25:33.210 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/NeverWantedButInvoked
00:25:33.210 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.NeverWantedButInvoked
00:25:33.210 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.WrongTypeOfReturnValue
00:25:33.210 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.WrongTypeOfReturnValue'.
00:25:33.211 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/WrongTypeOfReturnValue
00:25:33.211 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/WrongTypeOfReturnValue
00:25:33.211 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.WrongTypeOfReturnValue
00:25:33.211 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.NoInteractionsWanted
00:25:33.211 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.NoInteractionsWanted'.
00:25:33.212 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/NoInteractionsWanted
00:25:33.212 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/NoInteractionsWanted
00:25:33.212 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.NoInteractionsWanted
00:25:33.212 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.FriendlyReminderException
00:25:33.212 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.FriendlyReminderException'.
00:25:33.213 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/FriendlyReminderException
00:25:33.213 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/FriendlyReminderException
00:25:33.213 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.FriendlyReminderException
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.SmartNullPointerException
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.SmartNullPointerException'.
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/SmartNullPointerException
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/SmartNullPointerException
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.SmartNullPointerException
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.VerificationInOrderFailure
00:25:33.214 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.VerificationInOrderFailure'.
00:25:33.215 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/VerificationInOrderFailure
00:25:33.215 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/VerificationInOrderFailure
00:25:33.215 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.VerificationInOrderFailure
00:25:33.216 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.CannotStubVoidMethodWithReturnValue
00:25:33.216 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.CannotStubVoidMethodWithReturnValue'.
00:25:33.216 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/CannotStubVoidMethodWithReturnValue
00:25:33.217 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/CannotStubVoidMethodWithReturnValue
00:25:33.217 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.CannotStubVoidMethodWithReturnValue
00:25:33.217 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.verification.TooLittleActualInvocations
00:25:33.217 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.verification.TooLittleActualInvocations'.
00:25:33.218 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/verification/TooLittleActualInvocations
00:25:33.218 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/verification/TooLittleActualInvocations
00:25:33.219 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.verification.TooLittleActualInvocations
00:25:33.219 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.UnfinishedVerificationException
00:25:33.219 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.UnfinishedVerificationException'.
00:25:33.220 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/UnfinishedVerificationException
00:25:33.222 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/UnfinishedVerificationException
00:25:33.222 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.UnfinishedVerificationException
00:25:33.223 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.util.MockUtil
00:25:33.223 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.util.MockUtil'.
00:25:33.224 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/util/MockUtil
00:25:33.226 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/internal/util/MockUtil
00:25:33.230 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.util, 1337586933
00:25:33.233 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.util.MockUtil
00:25:33.233 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.mock.MockName
00:25:33.233 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.mock.MockName'.
00:25:33.234 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.mock, 677215976
00:25:33.235 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.mock.MockName
00:25:33.235 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.invocation.MockHandler
00:25:33.235 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.invocation.MockHandler'.
00:25:33.237 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.invocation, -1026637970
00:25:33.237 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.invocation.MockHandler
00:25:33.237 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.Plugins
00:25:33.237 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.Plugins'.
00:25:33.239 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/Plugins
00:25:33.241 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/internal/configuration/plugins/Plugins
00:25:33.242 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.configuration.plugins, -1086470635
00:25:33.245 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.Plugins
00:25:33.246 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.PluginRegistry
00:25:33.248 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.PluginRegistry'.
00:25:33.252 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/PluginRegistry
00:25:33.255 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/plugins/PluginRegistry
00:25:33.255 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.PluginRegistry
00:25:33.255 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.plugins.PluginSwitch
00:25:33.255 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.plugins.PluginSwitch'.
00:25:33.257 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.plugins, -221983358
00:25:33.257 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.plugins.PluginSwitch
00:25:33.257 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.PluginLoader
00:25:33.257 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.PluginLoader'.
00:25:33.259 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/PluginLoader
00:25:33.269 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/plugins/PluginLoader
00:25:33.270 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.PluginLoader
00:25:33.270 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.misusing.MockitoConfigurationException
00:25:33.270 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.misusing.MockitoConfigurationException'.
00:25:33.270 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/exceptions/misusing/MockitoConfigurationException
00:25:33.272 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/exceptions/misusing/MockitoConfigurationException
00:25:33.272 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.misusing.MockitoConfigurationException
00:25:33.272 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.DefaultPluginSwitch
00:25:33.272 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.DefaultPluginSwitch'.
00:25:33.273 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/DefaultPluginSwitch
00:25:33.273 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/plugins/DefaultPluginSwitch
00:25:33.273 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.DefaultPluginSwitch
00:25:33.274 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.PluginFinder
00:25:33.274 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.PluginFinder'.
00:25:33.275 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/PluginFinder
00:25:33.279 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/plugins/PluginFinder
00:25:33.279 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.PluginFinder
00:25:33.280 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.util.collections.Iterables
00:25:33.280 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.util.collections.Iterables'.
00:25:33.281 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/util/collections/Iterables
00:25:33.281 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/util/collections/Iterables
00:25:33.281 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.util.collections, 2017266204
00:25:33.281 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.util.collections.Iterables
00:25:33.284 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.plugins.MockMaker
00:25:33.284 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.plugins.MockMaker'.
00:25:33.287 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.plugins.MockMaker
00:25:33.290 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.plugins.PluginFileReader
00:25:33.290 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.plugins.PluginFileReader'.
00:25:33.292 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/plugins/PluginFileReader
00:25:33.294 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/plugins/PluginFileReader
00:25:33.295 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.plugins.PluginFileReader
00:25:33.295 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.util.io.IOUtil
00:25:33.295 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.util.io.IOUtil'.
00:25:33.297 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/util/io/IOUtil
00:25:33.307 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/util/io/IOUtil
00:25:33.307 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.util.io, -654203713
00:25:33.308 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.util.io.IOUtil
00:25:33.320 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter
00:25:33.321 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter'.
00:25:33.323 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/exceptions/stacktrace/ConditionalStackTraceFilter
00:25:33.327 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/exceptions/stacktrace/ConditionalStackTraceFilter
00:25:33.327 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.exceptions.stacktrace, 1054137684
00:25:33.327 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter
00:25:33.327 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.configuration.IMockitoConfiguration
00:25:33.327 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.configuration.IMockitoConfiguration'.
00:25:33.328 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.configuration, 1488869720
00:25:33.329 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.configuration.IMockitoConfiguration
00:25:33.330 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.GlobalConfiguration
00:25:33.331 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.GlobalConfiguration'.
00:25:33.332 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/GlobalConfiguration
00:25:33.336 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/internal/configuration/GlobalConfiguration
00:25:33.336 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.internal.configuration, -292859549
00:25:33.337 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.GlobalConfiguration
00:25:33.337 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.configuration.DefaultMockitoConfiguration
00:25:33.338 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.configuration.DefaultMockitoConfiguration'.
00:25:33.339 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/configuration/DefaultMockitoConfiguration
00:25:33.342 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/configuration/DefaultMockitoConfiguration
00:25:33.343 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.configuration.DefaultMockitoConfiguration
00:25:33.343 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.configuration.AnnotationEngine
00:25:33.343 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.configuration.AnnotationEngine'.
00:25:33.344 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.configuration.AnnotationEngine
00:25:33.344 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.configuration.ClassPathLoader
00:25:33.344 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.configuration.ClassPathLoader'.
00:25:33.344 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/configuration/ClassPathLoader
00:25:33.345 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/mockito/internal/configuration/ClassPathLoader
00:25:33.345 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Adding bytecode for initializing field MOCKITO_CONFIGURATION_CLASS_NAME
00:25:33.345 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.configuration.ClassPathLoader
00:25:33.346 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.configuration.MockitoConfiguration
00:25:33.346 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.configuration.MockitoConfiguration'.
00:25:33.346 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Error while loading class: java.lang.ClassNotFoundException: Class 'org/mockito/configuration/MockitoConfiguration.class' should be in target project, but could not be found!
00:25:33.346 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.internal.exceptions.stacktrace.StackTraceFilter
00:25:33.346 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.internal.exceptions.stacktrace.StackTraceFilter'.
00:25:33.347 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/mockito/internal/exceptions/stacktrace/StackTraceFilter
00:25:33.349 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/mockito/internal/exceptions/stacktrace/StackTraceFilter
00:25:33.349 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.internal.exceptions.stacktrace.StackTraceFilter
00:25:33.350 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.mockito.exceptions.stacktrace.StackTraceCleaner
00:25:33.350 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.mockito.exceptions.stacktrace.StackTraceCleaner'.
00:25:33.350 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Defined package (3): package org.mockito.exceptions.stacktrace, -1970331575
00:25:33.350 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.mockito.exceptions.stacktrace.StackTraceCleaner
00:25:33.356 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.http.URLUtils$EncodingRule
00:25:33.356 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.http.URLUtils$EncodingRule'.
00:25:33.358 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/http/URLUtils$EncodingRule
00:25:33.359 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Creating brand-new static initializer in class org/jinstagram/http/URLUtils$EncodingRule
00:25:33.359 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.http.URLUtils$EncodingRule
00:25:33.359 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Seeing class for first time: org.jinstagram.http.URLUtils
00:25:33.359 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Instrumenting class 'org.jinstagram.http.URLUtils'.
00:25:33.360 [main] INFO org.evosuite.runtime.instrumentation.MethodCallReplacementClassAdapter - Adding mock interface to class org/jinstagram/http/URLUtils
00:25:33.367 [main] INFO org.evosuite.runtime.instrumentation.CreateClassResetClassAdapter - Found static initializer in class org/jinstagram/http/URLUtils
00:25:33.368 [main] INFO org.evosuite.runtime.instrumentation.EvoClassLoader - Keeping class: org.jinstagram.http.URLUtils
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 1.775 s <<< FAILURE! -- in org.jinstagram.auth.oauth.InstagramService_ESTest
[ERROR] org.jinstagram.auth.oauth.InstagramService_ESTest.testGetAuthorizationUrl -- Time elapsed: 0.336 s <<< ERROR!
java.lang.ExceptionInInitializerError
	at org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter.<init>(ConditionalStackTraceFilter.java:17)
	at org.mockito.exceptions.base.MockitoException.filterStackTrace(MockitoException.java:41)
	at org.mockito.exceptions.base.MockitoException.<init>(MockitoException.java:30)
	at org.mockito.exceptions.misusing.MockitoConfigurationException.<init>(MockitoConfigurationException.java:18)
	at org.mockito.internal.configuration.plugins.PluginLoader.loadImpl(PluginLoader.java:66)
	at org.mockito.internal.configuration.plugins.PluginLoader.loadPlugin(PluginLoader.java:24)
	at org.mockito.internal.configuration.plugins.PluginRegistry.<init>(PluginRegistry.java:12)
	at org.mockito.internal.configuration.plugins.Plugins.<clinit>(Plugins.java)
	at org.mockito.internal.util.MockUtil.<clinit>(MockUtil.java)
	at org.mockito.internal.MockitoCore.<init>(MockitoCore.java:44)
	at org.mockito.Mockito.<clinit>(Mockito.java)
	at org.jinstagram.auth.oauth.InstagramService_ESTest.testGetAuthorizationUrl(InstagramService_ESTest.java:36)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.evosuite.runtime.vnet.NonFunctionalRequirementRule$1.evaluate(NonFunctionalRequirementRule.java:41)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
	at org.junit.vintage.engine.execution.RunnerExecutor.execute(RunnerExecutor.java:42)
	at org.junit.vintage.engine.VintageTestEngine.executeAllChildren(VintageTestEngine.java:80)
	at org.junit.vintage.engine.VintageTestEngine.execute(VintageTestEngine.java:72)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:147)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:127)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:90)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:55)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:102)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
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
Caused by: java.lang.NullPointerException
	at org.mockito.internal.configuration.plugins.Plugins.getStackTraceCleanerProvider(Plugins.java:17)
	at org.mockito.internal.exceptions.stacktrace.StackTraceFilter.<clinit>(StackTraceFilter.java)
	... 57 more

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   InstagramService_ESTest.testGetAuthorizationUrl:36 » ExceptionInInitializer
[INFO] 
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.659 s
[INFO] Finished at: 2024-05-04T00:25:34+08:00
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
Warning: the font "Times" is not available, so "Lucida Bright" has been substituted, but may have unexpected appearance or behavor. Re-enable the "Times" font to remove this warning.
