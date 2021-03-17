package com.pineapple.demo03_list

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val list1 = List(List(1, 2), List(3), List(4, 5))

        val list2 = list1.flatten

        println(s"list1: $list1")
        println(s"list2: $list2")
    }
}