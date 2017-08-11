package com.vic.applib.test

import com.vic.applib.utils.UIUtil

/**
 * Created by Vic on 2017/6/29 0029.
 */
class ActivityTest {
    fun doTest():Unit{
        val test = RxJava()
        test.doTest()
        println("screen size ${UIUtil.getScreenSize()[0]}*${UIUtil.getScreenSize()[1]}")
    }
}