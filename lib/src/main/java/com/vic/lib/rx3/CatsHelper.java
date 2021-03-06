package com.vic.lib.rx3;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;
    public void saveTheCutestCat(String query, final Callback<String> uriCallback){
        apiWrapper.queryCats(query, new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                apiWrapper.store(cutest,uriCallback);
            }

            @Override
            public void onError(Exception e) {
                uriCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
