package com.vic.lib.rx7;

/**
 * Created by Vic on 2017/5/5 0005.
 */
public interface RxRunnable<T> {
    T run();
    void onUI(T t);
    void onError(Throwable error);
}
