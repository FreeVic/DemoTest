package com.vic.applib.test;

import android.util.Log;

/**
 * Created by Vic on 2017/5/11 0011.
 */

public class LogUtil {
    private static final String TAG = "LOG_D";

    public static void d(Object obj) {
        if (obj != null)
            Log.d(TAG, obj.toString());
    }

    public static void d(String tag, Object obj) {
        if (obj != null)
            Log.d(tag, obj.toString());
    }
}
