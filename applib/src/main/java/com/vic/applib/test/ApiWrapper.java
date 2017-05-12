package com.vic.applib.test;

import android.util.Log;

import com.vic.lib.rx7.Api;
import com.vic.lib.rx7.ApiImpl;
import com.vic.lib.rx7.Cat;
import com.vic.lib.rx7.RxRunnable;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class ApiWrapper {
    String TAG = ApiWrapper.class.getSimpleName();
    Api api = new ApiImpl();

    public Flowable<List<Cat>> queryCats(final String query) {
        return Flowable.create(new FlowableOnSubscribe<List<Cat>>() {
            @Override
            public void subscribe(final @NonNull FlowableEmitter<List<Cat>> publisher) throws Exception {
                logThread();
                api.queryCats(query, new Api.CatsQueryCallback() {
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        publisher.onNext(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        publisher.onError(e);
                        publisher.onComplete();
                    }
                });
            }
        }, BackpressureStrategy.BUFFER);

    }

    public Flowable<Cat> findCutest(final List<Cat> list) {
        return Flowable.create(new FlowableOnSubscribe<Cat>() {
            @Override
            public void subscribe(final @NonNull FlowableEmitter<Cat> publisher) throws Exception {
                logThread();
                api.findCutest(list, new Api.FindCallback() {
                    @Override
                    public void onCatFound(Cat cat) {
                        publisher.onNext(cat);
                        publisher.onComplete();
                    }

                    @Override
                    public void onFindFailed(Exception e) {
                        publisher.onError(e);
                    }
                });
            }
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<String> storeCat(final Cat cat) {
        return Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(final @NonNull FlowableEmitter<String> publisher) throws Exception {
                logThread();
                api.store(cat, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(String uri) {

                        publisher.onNext(uri);
                        publisher.onComplete();
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        publisher.onError(e);
                    }
                });
            }
        }, BackpressureStrategy.BUFFER);
    }

    public <T> void runThread(final RxRunnable<T> runnable) {
        Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<T> e) throws Exception {
                logThread();
                e.onNext(runnable.run());
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<T>() {
            @Override
            public void accept(@NonNull T t) throws Exception {
                runnable.onUI(t);
            }
        });
    }

    public void logThread() {
        Log.i(TAG, "thread=" + Thread.currentThread().getId());
    }


}
