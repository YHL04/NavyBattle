#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_navybattle_MainActivity_testing(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "testing successful";
    return env->NewStringUTF(hello.c_str());
}

