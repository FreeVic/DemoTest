package com.vic.test;

import android.util.Log;

import com.example.test.BaseTest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class RxJavaTest extends BaseTest {
    String TAG = RxJavaTest.class.getSimpleName();
    @Override
    protected void doSubTest() {
        testObserable();
        testFlowable();
    }

    void saveCutestCat(){
    }

    void testObserable(){
        Observable<String> observable = Observable.just("hello", "obserable");
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull String s) {

                Log.i(TAG,s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    void testFlowable(){
        Flowable<String> just = Flowable.just("hello", "flowable");
        just.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Integer.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG,s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
