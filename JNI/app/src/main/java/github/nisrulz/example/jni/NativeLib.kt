package github.nisrulz.example.jni

object NativeLib {
    // Load the native lib
    init {
        System.loadLibrary("hello-android-jni")
    }

    // Declare function
    external fun msgFromJni(): String
}