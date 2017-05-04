package com.example.rx5;

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
                apiWrapper.queryCats(query).map(new Func<List<Cat>, Cat>() {
                    @Override
                    public Cat call(List<Cat> cats) {
                        return findCutest(cats);
                    }
                }).start(new Callback<Cat>() {
                    @Override
                    public void onResult(Cat cat) {
                        apiWrapper.store(cat).start(new Callback<Uri>() {
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
