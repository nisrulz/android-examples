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
    const val androidGradlePlugin = "3.4.1"

    // Dependencies
    const val kotlin = "1.3.31"
    const val support = "1.0.0"
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"

    // Testing
    const val junit = "4.12"
    const val espresso = "3.1.1"
    const val testRunner = "1.1.1"

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
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.support}"
    const val cardView = "androidx.cardview:cardview:${Versions.support}"
    const val palette = "androidx.palette:palette:${Versions.support}"
    const val design = "com.google.android.material:material:${Versions.support}"
    const val customTabs = "androidx.browser:browser:${Versions.support}"
    const val supportAnnotations = "androidx.annotation:annotation:${Versions.support}"
    const val supportCompat = "androidx.core:core:${Versions.support}"
    const val supportCoreUtils = "androidx.legacy:legacy-support-core-utils:${Versions.support}"
    const val supportCoreUi = "androidx.legacy:legacy-support-core-ui:${Versions.support}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
}