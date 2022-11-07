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
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__)


int global_value = 0;

void* thread_one(void* arg){
    LOGD("Thread 1");
    for(;;){
        global_value = 1;
        __asm__ __volatile__ ("");
    }
}

int count[33] = {0};
std::string count_string = "";
void* thread_two(void* arg){
    LOGD("Thread 2");
    count_string = "";
    for(int i=0;i<5000;i++)
        count[global_value]++;

    sleep(2);
    LOGD("Thread two awake!");
    for(int j=0;j<33;j++){
        count_string += std::to_string(count[j]);
    }
    LOGD("Thread 2 finish!");
    return ((void*)0);
}

extern "C" JNIEXPORT jstring
JNICALL
Java_com_example_qemutask_MainActivity_mainthread(JNIEnv *env,jobject ){

    pthread_t pt[2];
    pthread_create(&pt[0],NULL,thread_one,NULL);
    pthread_create(&pt[0],NULL,thread_two,NULL);

    sleep(6);
    return env->NewStringUTF(count_string.c_str());
}
