package com.vic.lib.rx1;

import java.util.List;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public interface Api {
    public List<Cat> queryCats(String query);
    public String store(Cat cat);
}
