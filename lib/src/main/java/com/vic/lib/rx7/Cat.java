package com.vic.lib.rx7;

/**
 * Created by Vic on 2017/5/4 0004.
 */
public class Cat implements Comparable<Cat>{
    int cuteness;
    String img;

    public Cat(int cuteness) {
        this.cuteness = cuteness;
    }

    @Override
    public int compareTo(Cat o) {
        return Integer.compare(cuteness,o.cuteness);
    }
}
