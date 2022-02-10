#include <jni.h>

JNIEXPORT jstring JNICALL
Java_github_nisrulz_example_jni_NativeLib_msgFromJni(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "Hello World From JNI i.e C code");
}