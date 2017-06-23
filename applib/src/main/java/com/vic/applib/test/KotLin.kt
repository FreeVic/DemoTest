package com.vic

import android.util.Log
import com.vic.lib.test.BaseTest

/**
 * Created by Vic on 2017/5/25 0025.
 */
class KotLin: BaseTest() {
    override fun doSubTest() {
        val str = "3+7+myNumber=${sum(3,7)}"
        println(str)
        Log.i("Kotlin",str)
    }

    val myNumber:Int = 10;

    fun sum(a:Int,b:Int):Int{
        return a+b+myNumber
    }

}