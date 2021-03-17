package com.pineapple.demo07_function

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        /*
            函数的格式：
                (函数的参数列表) => {函数体}
         */
        list1.foreach((x: Int) => {
            println(x)
        })
        println("-" * 15)
        // 简写
        list1.foreach(x => println(x))
    }
}