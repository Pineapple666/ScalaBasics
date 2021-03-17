package com.pineapple.demo03_list

object ClassDemo06 {

    def main(args: Array[String]): Unit = {
        val names = List("张三", "李四", "王五")
        val ages = List(23, 24, 25)
        val list1 = names.zip(ages)
        println(list1)

        val tuple1 = list1.unzip
        println(tuple1)
    }
}