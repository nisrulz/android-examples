#include <jni.h>

JNIEXPORT jstring JNICALL
Java_github_nisrulz_jni_MainActivity_getMsgFromJni(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "Hello From JNI");
}