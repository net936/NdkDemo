package com.xqs.ndkdemo;

public class JniUtil {

    static {
        System.loadLibrary("JniSDK");
    }


    public static native int add(int a , int b);

}
