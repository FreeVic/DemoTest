package com.vic.lib.test

/**
 * Created by Vic on 2017/5/25 0025.
 */
class KotLin: BaseTest() {
    override fun doSubTest() {
        val str = "3+7+myNumber=${sum1(3,7)}"
        println(str)
        sum4()
    }

    // 定义局部变量
//    var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和Java中声明变量的方式一样。
//    val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变
    var a: Int = 1  // 立刻赋值
    var b = 2   // `Int` 类型是自推导的
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
    var str = "kotlin was a good language"
    var result = "print $str"

    // 可空变量及空值检测
    fun sum4():Unit{
        var str: String? = "test"
        println(str)

        var kotLin:KotLin? = KotLin()
        // 可空变量属性值调用必须判空，否则编译不过
//        println("kotlin x="+kotLin.x)
        if(kotLin!=null)
            println("kotlin x="+kotLin.x)
        // 当不为空时执行操作
        str?.let {
            println("str is not null")
        }?:let{
            println("str is null")
        }
        if(str.isNullOrEmpty()) println("str is null") else println("str is not null")

        // 为空和不为空时操作
        println("kotlin is null ? ${kotLin?.x?:"null 了"}")
    }

    // for 循环
    fun sum5():Unit{
        var testList = listOf("a","b","c")
        var code:String? = "haha"
        var map:HashMap<Int,String> = hashMapOf(Pair(1,"one"), Pair(2,"two"),3 to "three")
        println("test for each")
        for(item in testList){
            print(" "+item)
        }

        for(index in testList.indices){
            print(" "+testList.get(index))
        }
        // withIndex 库函数
        for((index,value) in testList.withIndex()){
            println("value=$value index=$index")
        }

        for((k,v) in map){
            println("k=$k v=$v")
        }
        // 访问map
        map[3] = "THREE"
        println(map[4]?.length?:"map value is null")
    }

    // 静态方法
    fun sum6():Unit{
        KotLinManager.print()
    }

    // 定义数组
    var names:Array<String> = arrayOf("jenny","trace")
    var address:Array<String?> =  arrayOfNulls(10)
    // 为了避免装箱和拆箱的开销，Kotlin 对基本类型包括 Int、Short、Byte、Long、Float、Double、Char 等基本类型提供了定制版数组类型，写法为 XArray
    var ages:IntArray = intArrayOf(10)

    // 可变参数
    fun sum7(vararg names:String?){
        for(item in names){
            println(item)
        }
    }

    // 三元运算符 kotlin中没有三元运算符  if else 这样的语句也是表达式，这一点与 Java 不同

    fun sum8(){
        var code = 0
        var success:Boolean = false
        code = if(success) 200 else 400
        println(code)
    }
    // main 函数
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("main fun in kotlin")
            var test:BaseTest = KotLin()
            test.doSubTest()
        }
    }

    // 自定义 getter and setter
    var x:Int = 10
        set(value) {field = 300}
        get() = field

    // 延迟初始化
    private val name by lazy{
        300
    }

    // 获取class
    fun sum9(){
        var kotLin:KotLin = KotLin()
        var clazz = kotLin.javaClass
        val clazz2 = KotLin::class.java
    }

    // 值检查与自动转换
    fun sum10(any:Any){
        if(any is String){
            println("any is String length="+any.length)
        }else if(any is Int){
            println("any is Int value="+any)
        }else if(any is KotLin){
            println("any is Kotlin x="+any.x)
        }else{
            println("any is unknown"+any)
        }
    }
    // when 表达式
    fun sum11(any:Any){
        when(any){
            is String -> println("any is String length="+any.length)
            is Int -> println("any is Int value="+any)
            is KotLin -> println("any is Kotlin x="+any.x)
            else -> println("any is unknown"+any)
        }
    }

    // ranges
    fun sum12(){
        var x=9
        var y=10
        if(x in 1..20){
            println("value of x is correct")
        }
        for(i in 1..10 step 2){
            print(" $i")
        }
    }

    // lambda
    fun sum13(){
        var fruits:Array<String> = arrayOf("apple","banana","pear","ahuck")

        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }

    // 数据类
    fun sum14(){
        var customer = Customer("jack", "email@jack.com")
        println(customer)
        customer.email = "email@trace.com"
        customer.name = "trace"
        print(customer)
    }

    // 函数默认参数，将不再需要重载方法，可以这样调用sum15(),sum15(12),如果想只传入c，则应带上参数名sum15(c="haha")
    fun sum15(a: Int? = 1,b:Int?=2, c: String? = "default c"){
        println("a=$a b=$b c=$c")
    }
    // 函数扩展
    fun sum16(){
        externaldMethod()
    }

    // 单例模式

}