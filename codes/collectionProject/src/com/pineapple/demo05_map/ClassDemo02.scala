package com.pineapple.demo05_map

import scala.collection.mutable

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val map1 = mutable.Map("张三" -> 23, "李四" -> 24)
        map1("张三") = 30
        println(map1)
    }
}