package com.pineapple.demo07_function

object ClassDemo07 {

    def main(args: Array[String]): Unit = {
        val list1 = List("01 hadoop", "02 flume", "03 hive", "04 spark")
        val list2 = list1.sortBy(_.split(" ")(1))
        println(list2)
    }
}