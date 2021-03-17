package com.pineapple.demo07_function

object ClassDemo08 {

    def main(args: Array[String]): Unit = {
        val list1 = List(2, 3, 1, 6, 4, 5)
        // 降序
        val list2 = list1.sortWith((x, y) => {
            x > y
        })
        println(list2)

        // 精简版
        val list3 = list1.sortWith(_ > _)
        println(list3)
    }
}