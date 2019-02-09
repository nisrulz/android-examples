/**
 * A holder of all the versions.
 */
object Versions {

    // Build Config
    const val minSDK = 14
    const val compileSDK = 28
    const val targetSDK = 28

    // App version
    const val appVersionCode = 1
    const val appVersionName = "1.0.0"

    // Plugins
    const val androidGradlePlugin = "3.3.1"

    // Dependencies
    const val kotlin = "1.3.21"
    const val support = "28.0.0"
    const val constraintLayout = "1.1.3"

    // Testing
    const val junit = "4.12"
    const val espresso = "3.0.2"
    const val testRunner = "1.0.2"

}

/**
 * A holder of all the dependencies required by the app.
 */
object Deps {

    // Plugins
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // Support Library
    const val appCompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val recyclerView = "com.android.support:recyclerview-v7:${Versions.support}"
    const val cardView = "com.android.support:cardview-v7:${Versions.support}"
    const val palette = "com.android.support:palette-v7:${Versions.support}"
    const val design = "com.android.support:design:${Versions.support}"
    const val customTabs = "com.android.support:customtabs:${Versions.support}"
    const val supportAnnotations = "com.android.support:support-annotations:${Versions.support}"
    const val supportCompat = "com.android.support:support-compat:${Versions.support}"
    const val supportCoreUtils = "com.android.support:support-core-utils:${Versions.support}"
    const val supportCoreUi = "com.android.support:support-core-ui:${Versions.support}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
}