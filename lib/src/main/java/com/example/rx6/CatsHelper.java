package com.example.rx6;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;
    public AsyncJob<String> saveTheCutestCat(final String query){
        AsyncJob<List<Cat>> listAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> catAsyncJob = listAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });
        AsyncJob<String> uriAsyncJob = catAsyncJob.flatMap(new Func<Cat, AsyncJob<String>>() {
            @Override
            public AsyncJob<String> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return uriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

    public void save(){
        saveTheCutestCat("").start(new Callback<String>() {
            @Override
            public void onResult(String uri) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
