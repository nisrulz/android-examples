cmake_minimum_required(VERSION 3.4.1)

add_library(hello-android-jni SHARED
            hello-android-jni.c)

# Include libraries needed for hello-android-jni lib
target_link_libraries(hello-android-jni
                      android
                      log)