package com.vic.applib.utils;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.vic.applib.GlobalApplication;

import java.lang.reflect.Field;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class UIUtil {

    public static int getNumber() {
        return 1;
    }

    public static void showToast(String str) {
        if (!TextUtils.isEmpty(str))
            Toast.makeText(GlobalApplication.getApplication(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = GlobalApplication.getApplication().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sbar;
    }

    public static int[] getScreenSize() {
        DisplayMetrics dm = GlobalApplication.getApplication().getResources().getDisplayMetrics();
        return new int[]{dm.widthPixels, dm.heightPixels};
    }

}
