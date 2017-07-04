package com.vic.lib.rx6;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public interface Callback<T> {
    public void onResult(T t);
    public void onError(Exception e);
}
