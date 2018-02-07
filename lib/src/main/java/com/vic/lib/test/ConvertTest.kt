package com.vic.lib.test

import com.vic.lib.utils.ConvertEncodingUtil

/**
 * Created by eruser on 2018/2/7.
 */
class ConvertTest: BaseTest() {
    override fun doSubTest() {
        val convert = ConvertEncodingUtil("C:\\Users\\eruser\\Desktop\\PersonMoney4Android01", "C:\\Users\\eruser\\Desktop\\LNote")
        convert.convert()
    }
}