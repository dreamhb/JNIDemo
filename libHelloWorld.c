#include <stdio.h>
#include "HelloWorld.h"

JNIEXPORT void JNICALL Java_HelloWorld_print(JNIEnv *env, 
        jobject obj, jint i, jstring s, jintArray intarray){
    getSum(env, intarray);
    int length = (*env)->GetStringLength(env, s);
    const char* str = (*env)->GetStringUTFChars(env, s, JNI_FALSE);
    printf("HelloWorld i == %d string == %s, length == %d\n", i, str, length);
    return;
}

void getSum(JNIEnv *env, jintArray array){
    jint i, sum = 0;
    jint *c_array;
    jint arr_len;

    arr_len = (*env)->GetArrayLength(env, array);
    c_array = (jint *)malloc(sizeof(jint) * arr_len);
    memset(c_array, 0, sizeof(jint)*arr_len);

    (*env)->GetIntArrayRegion(env, array, 0, arr_len,  c_array);

    for(i = 0; i < arr_len;i++){
        sum += c_array[i];
    }

    free(c_array);

    printf(" sum is %d \n", sum);
}
