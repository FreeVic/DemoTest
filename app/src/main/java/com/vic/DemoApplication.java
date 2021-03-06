package com.vic;

import android.content.Intent;
import android.support.multidex.MultiDexApplication;

import com.vic.applib.GlobalApplication;
import com.vic.restart.RestartActivity;

/**
 * Created by Vic on 2016/6/27 0027.
 */
public class DemoApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        GlobalApplication.setApplication(this);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                System.out.println("thread:" + thread.getName() + " threadId:" + thread.getId());
                System.out.println(ex.getCause().getMessage());
//                restartApp();
            }
        });
    }

    public void restartApp() {
        Intent intent = new Intent(DemoApplication.this, RestartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());  //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
    }
}
