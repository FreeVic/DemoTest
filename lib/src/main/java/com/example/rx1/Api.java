package com.example.rx1;

import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public interface Api {
    public List<Cat> queryCats(String query);
    public Uri store(Cat cat);
}
