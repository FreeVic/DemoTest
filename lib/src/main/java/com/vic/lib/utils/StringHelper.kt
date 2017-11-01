package com.vic.lib.utils

/**
 * Created by zhangshengli on 2017/10/20.
 */
object StringHelper{
    fun f19(s:String) {
        var a = s
        if (a.isNullOrEmpty()) return
        var str = a.replace("=", "\":\"").replace("+", "\",\"")
        var sb = StringBuilder()
        sb.append("{\"").append(str).append("\"}")
        println(sb.toString())
    }
}