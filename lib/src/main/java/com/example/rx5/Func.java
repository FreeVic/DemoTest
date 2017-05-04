package com.example.rx5;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public interface Func<T,R> {
    R call(T t);
}
