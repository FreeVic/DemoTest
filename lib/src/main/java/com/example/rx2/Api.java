package com.example.rx2;

import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onQueryFailed(Exception e);
    }

    interface StoreCallback{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }

    public List<Cat> queryCats(String query,CatsQueryCallback queryCallback);
    public Uri store(Cat cat,StoreCallback storeCallback);
}
