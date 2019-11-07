package com.config.pad.content.libding.utils;

import android.util.Log;

/**
 * Created by tushuangxi 2019.1.26
 */
public class LogUtils {
//    private static boolean isDebug = AppConfig.isDebug();
    private static boolean isDebug = true; //true打印日志  false 不打印


    /**
     * 以级别为 v 的形式输出LOG
     */
    public static void v(String mTag, String msg) {
        if (isDebug) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(String mTag, String msg) {
        if (isDebug) {
            Log.d(mTag, msg);
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(String mTag, String msg) {
        if (isDebug) {
            Log.i(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(String mTag, String msg) {
        if (isDebug) {
            Log.w(mTag, msg);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(String mTag, String msg) {
        if (isDebug) {
            Log.e(mTag, msg);
        }
    }

}
