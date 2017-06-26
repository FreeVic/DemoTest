package com.vic.lib.test

/**
 * Created by Vic on 2017/6/26 0026.
 */
data class Customer(var name: String, var email: String)

// 为KotLin类扩展函数 似乎不能放在Companion Objects中
fun KotLin.externaldMethod(){
    println("this is external method")
}