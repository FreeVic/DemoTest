package com.example.rx4;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;
    public AsyncJob<String> saveTheCutestCat(final String query){
       return new AsyncJob<String>() {
           @Override
           public void start(final Callback<String> callback) {
               apiWrapper.queryCats(query).start(new Callback<List<Cat>>() {
                   @Override
                   public void onResult(List<Cat> cats) {
                       Cat cutest = findCutest(cats);
                       apiWrapper.store(cutest).start(new Callback<String>() {
                           @Override
                           public void onResult(String uri) {
                               callback.onResult(uri);
                           }

                           @Override
                           public void onError(Exception e) {
                                callback.onError(e);
                           }
                       });
                   }

                   @Override
                   public void onError(Exception e) {
                        callback.onError(e);
                   }
               });
           }
       };
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
