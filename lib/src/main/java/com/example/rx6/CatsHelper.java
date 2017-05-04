package com.example.rx6;

import com.sun.jndi.toolkit.url.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;
    public AsyncJob<Uri> saveTheCutestCat(final String query){
        AsyncJob<List<Cat>> listAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> catAsyncJob = listAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });
        AsyncJob<Uri> uriAsyncJob = catAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return uriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

    public void save(){
        saveTheCutestCat("").start(new Callback<Uri>() {
            @Override
            public void onResult(Uri uri) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
