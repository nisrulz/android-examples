![Image](/img/github_banner.png)

### Featured in
[![AndroidDev Digest](https://img.shields.io/badge/AndroidDev%20Digest-%23100-blue.svg)](https://www.androiddevdigest.com/digest-100/)

### Show some :heart:
[![GitHub stars](https://img.shields.io/github/stars/nisrulz/android-examples.svg?style=social&label=Star)](https://github.com/nisrulz/android-examples) [![GitHub forks](https://img.shields.io/github/forks/nisrulz/android-examples.svg?style=social&label=Fork)](https://github.com/nisrulz/android-examples/fork) [![GitHub watchers](https://img.shields.io/github/watchers/nisrulz/android-examples.svg?style=social&label=Watch)](https://github.com/nisrulz/android-examples) [![GitHub followers](https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow)](https://github.com/nisrulz/android-examples)  
[![Twitter Follow](https://img.shields.io/twitter/follow/nisrulz.svg?style=social)](https://twitter.com/nisrulz)

Main repository containing all the example apps demonstrating features/functionality/integrations in android application development

## Example apps
+ [ActivityLifecycle](/ActivityLifecycle) [![download](/img/ic_download.png)](https://kinolien.github.com/gitzip/?download=https://github.com/nisrulz/android-examples/tree/master/ActivityLifecycle)
+ [AudioRecording](/AudioRecording)
+ [BasicMVP](/BasicMVP)
+ [BoundServices](/BoundServices)
+ [BottomSheet](/BottomSheet)
+ [BroadcastReceiver](/BroadcastReceiver)
+ [BuilderPattern](/BuilderPattern)
+ [BuildVariants](/BuildVariants)
+ [Camera2](/Camera2)
+ [ChangeThemeDuringRuntime](/ChangeThemeDuringRuntime)
+ [CheckIfScreenLocked](/CheckIfScreenLocked)
+ [ChromeCustomTabs](/ChromeCustomTabs)
+ [CollapsibleToolbar](/CollapsibleToolbar)
+ [CustomBroadcastPermissions](/CustomBroadcastPermissions)
+ [CustomOnboardingIntro](/CustomOnboardingIntro)
+ [CustomView](/CustomView)
+ [DataBinding](/DataBinding)
+ [DebuggingWebViews](/DebuggingWebViews)
+ [Encryption](/Encryption)
+ [ExtractingColorFromBitmap](/ExtractingColorFromBitmap)
+ [Firebase](/Firebase)
+ [FirebaseCloudMessaging](/FirebaseCloudMessaging)
+ [GCMNetworkManager](/GCMNetworkManager)
+ [GPSLocation](/GPSLocation)
+ [GestureDetection](/GestureDetection)
+ [GridView](/GridView)
+ [HeadlessFragment](/HeadlessFragment)
+ [IntentService](/IntentService)
+ [Intents](/Intents)
+ [InterProcessService](/InterProcessService)
+ [JNI](/JNI)
+ [JUnitTests](/JUnitTests)
+ [ListView](/ListView)
+ [LoadHtmlIntoWebview](/LoadHtmlIntoWebview)
+ [LocalBroadcastManager](/LocalBroadcastManager)
+ [MobileVisionAPI2ReadBarCodes](/MobileVisionAPI2ReadBarCodes)
+ [NavigationDrawer](/NavigationDrawer)
+ [Notification](/Notification)
+ [ParallaxHeaderListview](/ParallaxHeaderListview)
+ [ProductFlavors](/ProductFlavors)
+ [RatingBar](/RatingBar)
+ [ReadJSONFile](/ReadJSONFile)
+ [RecyclerView](/RecyclerView)
+ [RuntimePermissions](/RuntimePermissions)
+ [SQLite](/SQLite)
+ [SearchView](/SearchView)
+ [SearchViewInToolbar](/SearchViewInToolbar)
+ [Service](/Service)
+ [SharedElementTransitions](/SharedElementTransitions)
+ [SimulateClick](/SimulateClick)
+ [SnackBar](/SnackBar)
+ [SpeechRecognition](/SpeechRecognition)
+ [TabLayout](/TabLayout)
+ [TextToSpeech](/TextToSpeech)
+ [TranslucentStatusBar](/TranslucentStatusBar)
+ [UnitTestingWithRoboelectric](/UnitTestingWithRoboelectric)
+ [UsingAppintro](/UsingAppintro)
+ [UsingArcMenu](/UsingArcMenu)
+ [UsingBottomNavigationBar](/UsingBottomNavigationBar)
+ [UsingButterKnife](/UsingButterKnife)
+ [UsingDBFlow](/UsingDBFlow)
+ [UsingDagger2](/UsingDagger2)
+ [UsingEasyGCMlib](/UsingEasyGCMlib)
+ [UsingFontAwesomeLib](/UsingFontAwesomeLib)
+ [UsingMPChartsLib](/UsingMPChartsLib)
+ [UsingParceler](/UsingParceler)
+ [UsingPercentSupportLib](/UsingPercentSupportLib)
+ [UsingPocketSphinxForVoiceRecognition](/UsingPocketSphinxForVoiceRecognition)
+ [UsingRealmDB](/UsingRealmDB)
+ [UsingRetrofit2](/UsingRetrofit2)
+ [UsingRobolectric](/UsingRobolectric)
+ [UsingRxJava](/UsingRxJava)
+ [UsingStetho](/UsingStetho)
+ [UsingSugarORM](/UsingSugarORM)
+ [UsingTimberLogger](/UsingTimberLogger)
+ [UsingAltBeaconLib](/UsingltBeaconLib)
+ [VectorDrawables](/VectorDrawables)
+ [ViewPager](/ViewPager)
+ [WebViewDialogueBox](/WebViewDialogueBox)


# Pull Requests
I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using `CMD`+`Option`+`L` (Reformat code) on Mac (not sure for Windows) with Android Studio defaults.
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
  4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Check for existing [issues](https://github.com/nisrulz/android-examples/issues) first, before filing an issue.
  6. Make sure you follow the set standard as all other projects in this repo do
    + Upgrade your gradle wrapper to the one all other apps are using. Use the below command at root of your project

        ```
        ./gradlew wrapper --gradle-version <version_name>
        ```
        i.e `./gradlew wrapper --gradle-version 3.1`
    + Use `ext` variables as defined in [`dependencies.gradle`](/dependencies.gradle), in your `build.gradle` files to make sure all apps are in sync with configurations and dependencies. Take a look [here](/DataBinding/app/build.gradle) and [here](/DataBinding/build.gradle)
    + Use the package name of the format `github.nisrulz.sample.*` where `*` is the example you are adding to the repo. I am trying to follow a set standard in the repo, please adhere to that.
  7. Have fun!

## Extra
Since the repo is pretty large now , I am sure a lot of you guys would like to download only some of the projects. To tackle that I came across this cool tool - [Gitzip](https://github.com/KinoLien/gitzip) (All credits to the [author](https://github.com/KinoLien), really cool work). To download a specific project
  + Navigate to the specific project you want to download and copy the path from address bar.

    i.e `https://github.com/nisrulz/android-examples/tree/master/ActivityLifecycle`
  + Next goto [Gitzip](https://kinolien.github.io/gitzip/)
  + Paste the path into the provided box and hit **Download**.
  + Done now load the project into Android Studio as you would normally.

> P.S. : I saw if you use Adblocker then Gitzip downloads an empty `zip` file, so disable Adblocker to get the correct `zip` file.

### Created & Maintained By
[Nishant Srivastava](https://github.com/nisrulz) ([@nisrulz](https://www.twitter.com/nisrulz))


License
=======

    Copyright 2016 Nishant Srivastava

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
