#include <jni.h>

//3.实现c代码。
JNIEXPORT jstring JNICALL Java_com_vic_MainActivity_helloFromC
  (JNIEnv* env, jobject obj){
	char* str = "hello from c!";
	//把c语言的字符串 转化成 java的字符串
	//    jstring     (*NewStringUTF)(JNIEnv*, const char*);
	return (*env)->NewStringUTF(env,str);
	//(*(*env)).NewStringUTF();
}
