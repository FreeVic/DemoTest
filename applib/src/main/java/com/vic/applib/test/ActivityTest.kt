package com.vic.applib.test

import com.vic.applib.utils.UIUtil
import com.vic.lib.test.KotLin

/**
 * Created by Vic on 2017/6/29 0029.
 */
class ActivityTest {
    fun doTest():Unit{
        val test = KotLin()
        test.doTest()
        println("screen size ${UIUtil.getScreenSize()[0]}*${UIUtil.getScreenSize()[1]}")
    }
}