package com.pineapple.demo03_list

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        val list2 = Nil
        val list3 = -2 :: -1 :: Nil

        println(s"list1: $list1")
        println(s"list2: $list2")
        println(s"list3: $list3")
    }
}
