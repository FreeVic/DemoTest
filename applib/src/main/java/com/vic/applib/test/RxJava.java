package com.vic.applib.test;

import android.os.SystemClock;

import com.vic.applib.utils.LogUtil;
import com.vic.lib.rx7.Api;
import com.vic.lib.rx7.Cat;
import com.vic.lib.rx7.RxRunnable;
import com.vic.lib.test.BaseTest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class RxJava extends BaseTest {
    String TAG = RxJava.class.getSimpleName();
    ApiWrapper apiWrapper = new ApiWrapper();
    ListCompositeDisposable listComposite = new ListCompositeDisposable();

    @Override
    protected void doSubTest() {
        testObserable();
        testFlowable();
        testObseravle2();
    }

    void saveCutestCat(final String query, final Api.StoreCallback callback) {
        apiWrapper.queryCats(query).subscribeOn(Schedulers.io()).flatMap(new Function<List<Cat>, Publisher<Cat>>() {
            @Override
            public Publisher<Cat> apply(@NonNull List<Cat> cats) throws Exception {
                return apiWrapper.findCutest(cats);
            }
        }).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function<Cat, Publisher<String>>() {
            @Override
            public Publisher<String> apply(@NonNull Cat cat) throws Exception {
                return apiWrapper.storeCat(cat);
            }
        }).observeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                LogUtil.d(TAG, "th=" + Thread.currentThread().getId());
                callback.onCatStored(s);
            }
        });
    }

    void testObserable() {
        Observable<String> observable = Observable.just("hello", "obserable");
        Disposable subscribe = observable.delay(5, TimeUnit.SECONDS).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                LogUtil.d(TAG, s);
            }
        });
        listComposite.add(subscribe);
        listComposite.dispose();
    }

    void testFlowable() {
        Flowable<String> just = Flowable.just("hello", "flowable");
        just.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                LogUtil.d(TAG, s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        just.subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                LogUtil.d(TAG, s);
            }
        });
        saveCutestCat("hhh", new Api.StoreCallback() {
            @Override
            public void onCatStored(String uri) {
                LogUtil.d(TAG, "get the result =" + uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                LogUtil.d(TAG, "get the result failed =" + e.toString());
            }
        });

        // thread
        apiWrapper.runThread(new RxRunnable<String>() {

            @Override
            public String run() {
                LogUtil.d(TAG, "sleep");
                SystemClock.sleep(5000);
                LogUtil.d(TAG, "wake up");
                return "wake up";
            }

            @Override
            public void onUI(String s) {
                LogUtil.d(TAG, "receive msg : " + s);
            }

            @Override
            public void onError(Throwable error) {

            }
        });

    }

    private void testObseravle2() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {
                e.onNext("hahahha");
            }
        }, BackpressureStrategy.BUFFER).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                LogUtil.d(TAG, s);
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
