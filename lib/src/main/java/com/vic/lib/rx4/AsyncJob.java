package com.vic.lib.rx4;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
