package com.vic.applib;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Vic on 2017/5/18 0018.
 */

public class GlobalApplication {
    private static Application application;
    public static Application getApplication(){
        return application;
    }
    public static void setApplication(Application application){
         GlobalApplication.application= application;
        init();
    }

    private static void init() {
        Timber.plant(new Timber.DebugTree());
    }
}
