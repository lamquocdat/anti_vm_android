#include <jni.h>
#include <string>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>
#include <unistd.h>
#include <pthread.h>
#include <android/log.h>
#include <sstream>
#include <stdio.h>

#define TAG "test"
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)

std::string smcstring = "";
typedef void (*myfunc)();
void SMC_one(){
    smcstring += "#SMC1#";
    LOGD("###SMC1###");
}

void SMC_two(){
    smcstring += "#SMC2#";
    LOGD("###SMC2###");
}

extern "C" JNIEXPORT jstring
JNICALL
Java_com_example_smc_MainActivity_SMCdetection(JNIEnv *env, jobject ){
    for(int i=0;i<100;i++) {
        myfunc this_smc = SMC_one;
        this_smc();
        this_smc = SMC_two;
        this_smc();
    }
    return env->NewStringUTF(smcstring.c_str());
}
