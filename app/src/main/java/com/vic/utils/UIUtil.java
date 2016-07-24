package com.vic.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.vic.DemoApplication;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class UIUtil {

    public static int getNumber(){
        return 1;
    }

    public static void showToast(String str){
        if(!TextUtils.isEmpty(str))
        Toast.makeText(DemoApplication.getInstance(), str, Toast.LENGTH_SHORT).show();
    }

}
