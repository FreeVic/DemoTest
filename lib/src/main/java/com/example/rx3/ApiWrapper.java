package com.example.rx3;

import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class ApiWrapper {
    Api api;
    public void queryCats(String query, final Callback<List<Cat>> listCallback){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                listCallback.onResult(cats);
            }

            @Override
            public void onQueryFailed(Exception e) {
                listCallback.onError(e);
            }
        });
    }

    public void store(Cat cat, final Callback<String> uriCallback){
        api.store(cat, new Api.StoreCallback() {
            @Override
            public void onCatStored(String uri) {
                uriCallback.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                uriCallback.onError(e);
            }
        });
    }
}
