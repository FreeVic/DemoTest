package com.vic.lib.rx6;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class Cat implements Comparable<Cat>{
    int cuteness;
    String img;

    @Override
    public int compareTo(Cat o) {
        return Integer.compare(cuteness,o.cuteness);
    }
}
