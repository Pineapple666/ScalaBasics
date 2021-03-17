package com.pineapple.demo07_function

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        // 普通方式
        val list2 = list1.map((x: Int) => {
            "*" * x
        })
        println(list2)

        // 类型推断
        val list3 = list1.map(x => "*" * x)
        println(list3)

        // 下划线
        val list4 = list1.map("*" * _)
        println(list4)
    }
}