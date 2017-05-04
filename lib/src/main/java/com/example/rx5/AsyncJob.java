package com.example.rx5;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);

    public <R> AsyncJob<R> map(final Func<T,R> func){
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final Callback<R> callback) {
                source.start(new Callback<T>() {
                    @Override
                    public void onResult(T t) {
                        R mapped = func.call(t);
                        callback.onResult(mapped);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}
