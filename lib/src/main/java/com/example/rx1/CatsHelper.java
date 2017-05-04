package com.example.rx1;

import com.sun.jndi.toolkit.url.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class CatsHelper {
    Api api;
    public Uri saveTheCutestCat(String query){
        List<Cat> cats = api.queryCats(query);
        Cat cat = findCutest(cats);
        return api.store(cat);
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
