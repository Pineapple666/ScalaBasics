package com.pineapple.demo03_list

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        println(s"isEmpty: ${list1.isEmpty}")

        val list2 = List(4, 5, 6)
        val list3 = list1 ++ list2
        println(s"list3: $list3")

        println(s"head: ${list1.head}")

        println(s"head: ${list1.tail}")

        println(s"reverse: ${list1.reverse}")

        // 前3个元素都是前缀元素
        println(s"take: ${list1.take(3)}")

        // 除了前三个元素，其它都是后缀元素
        println(s"drop: ${list1.drop(3)}")
    }
}