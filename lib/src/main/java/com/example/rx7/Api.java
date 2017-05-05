package com.example.rx7;

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
        void onCatStored(String uri);
        void onStoreFailed(Exception e);
    }

    interface FindCallback{
        void onCatFound(Cat cat);
        void onFindFailed(Exception e);
    }

    public void queryCats(String query, CatsQueryCallback queryCallback);
    public void store(Cat cat, StoreCallback storeCallback);
    public void findCutest(List<Cat> list,FindCallback findCallBack);
}
