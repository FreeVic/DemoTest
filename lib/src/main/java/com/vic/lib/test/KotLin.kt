package com.vic.lib.test

/**
 * Created by Vic on 2017/5/25 0025.
 */
class KotLin: BaseTest() {
    override fun doSubTest() {
        val str = "3+7+myNumber=${sum1(3,7)}"
        println(str)
        sum5()
    }

    // 定义局部变量
    val a: Int = 1  // 立刻赋值
    val b = 2   // `Int` 类型是自推导的
//    val c: Int  // 没有初始化器时要指定类型
    // 定义方法
    fun sum1(a:Int,b:Int):Int{
        return a+b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun sum3(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
        println(result)
    }

    // 字符串模板
    val str = "kotlin was a good language"
    val result = "print $str"

    // 可空变量及空值检测
    fun sum4():Unit{
        val str: String? = "test"
        println(str)

    }

    // for 循环
    fun sum5():Unit{
        val testList = listOf("a","b","c")
        println("test for each")
        for(item in testList){
            print(" "+item)
        }

        for(index in testList.indices){
            print(" "+testList.get(index))
        }
    }



}