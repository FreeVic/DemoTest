package com.example.rx4;

import com.sun.jndi.toolkit.url.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;
    public AsyncJob<Uri> saveTheCutestCat(final String query){
       return new AsyncJob<Uri>() {
           @Override
           public void start(final Callback<Uri> callback) {
               apiWrapper.queryCats(query).start(new Callback<List<Cat>>() {
                   @Override
                   public void onResult(List<Cat> cats) {
                       Cat cutest = findCutest(cats);
                       apiWrapper.store(cutest).start(new Callback<Uri>() {
                           @Override
                           public void onResult(Uri uri) {
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
