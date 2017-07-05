package com.vic.applib.utils;

import android.support.annotation.NonNull;

import com.vic.lib.rx7.RxRunnable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vic on 2017/7/4 0004.
 */

public class AsyncUtil {
    public static <T> void runThread(final RxRunnable<T> runnable) {
        Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<T> e) throws Exception {
                T t = runnable.run();
                if(t!=null) {
                    e.onNext(t);
                    e.onComplete();
                }else{
                    LogUtil.d("result of Runnable is null");
                    e.onError(new Exception("result of Runnable is null"));
                }
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(T t) {
                runnable.onUI(t);
            }

            @Override
            public void onError(Throwable t) {
                runnable.onError(t);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
