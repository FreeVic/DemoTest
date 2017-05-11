package com.vic.lib.rx2;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    Api api;
    public void saveTheCutestCat(String query){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                api.store(cutest, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(String uri) {
                        // 结果数据
                    }

                    @Override
                    public void onStoreFailed(Exception e) {

                    }
                });
            }

            @Override
            public void onQueryFailed(Exception e) {

            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
