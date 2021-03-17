package com.pineapple.demo07_function

object ClassDemo11 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 10).toList
        // 100: 表示初始化值
        // (x, y) => x + y 表示函数对象
        val list2 = list1.fold(100)((x, y) => x + y)
        println(list2)

        val list3 = list1.fold(100)(_ + _)
        println(list3)
    }
}