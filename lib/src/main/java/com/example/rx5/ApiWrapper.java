package com.example.rx5;

import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class ApiWrapper {
    Api api;
    public AsyncJob<List<Cat>> queryCats(final String query){
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(final Callback<List<Cat>> callback) {
                api.queryCats(query, new Api.CatsQueryCallback() {
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        callback.onResult(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };


    }

    public AsyncJob<String> store(final Cat cat){
        return new AsyncJob<String>() {
            @Override
            public void start(final Callback<String> callback) {
                api.store(cat, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(String uri) {
                        callback.onResult(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };

    }
}
