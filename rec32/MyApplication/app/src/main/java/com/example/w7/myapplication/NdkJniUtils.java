package com.example.w7.myapplication;

// javah -jni com.example.w7.myapplication.NdkJniUtils
public class NdkJniUtils {
    static {
        //System.loadLibrary("JniLibName");	//defaultConfig.ndk.moduleName
        System.loadLibrary("freeimage");

    }
    public native String getCLanguageString();
    public native String reconize(String imagePath);
}


