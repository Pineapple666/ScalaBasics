package com.pineapple.demo07_function

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        // 普通写法
        list1.foreach((x: Int) => {
            println(x)
        })
        println("-" * 15)
        // 类型推断
        list1.foreach(x => println(x))
        println("-" * 15)

        // 下划线
        // 如果函数参数只在函数体中出现一次，并且函数体没有涉及到复杂的使用（例如：嵌套），方可使用下划线
        list1.foreach(println(_))

    }
}