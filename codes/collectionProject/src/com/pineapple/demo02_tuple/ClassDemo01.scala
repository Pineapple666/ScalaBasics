package com.pineapple.demo02_tuple

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val tuple1 = ("张三", 23)
        val tuple2 = "李四" -> 24

        println(tuple1)
        println(tuple2)
    }
}