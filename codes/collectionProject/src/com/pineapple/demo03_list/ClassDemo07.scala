package com.pineapple.demo03_list

object ClassDemo07 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        println(list1.toString)
        println(list1) // 简写形式，打印对象默认调用 toString

        println("-" * 15)

        println(list1.mkString)
        // 添加分隔符
        println(list1.mkString(":"))
        println(list1.mkString("，"))
    }
}