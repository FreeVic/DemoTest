package com.example.test;

/**
 * Created by Vic on 2017/4/28 0028.
 */
public abstract class BaseTest {
    public void doTest(){
        doSubTest();
    }
    protected abstract void doSubTest();

}
