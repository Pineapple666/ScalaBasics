package com.pineapple.demo05_map

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val map1 = Map("张三" -> 23, "李四" -> 24, "李四" -> 40)
        val map2 = Map(("张三", 23), ("李四", 24), ("李四", 40))
        println(map1)
        println(map2)
    }
}