package com.pineapple.demo05_map

import scala.collection.mutable

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val map1 = mutable.Map("张三" -> 23, "李四" -> 24)
        println(s"张三的年龄：" + map1("张三"))
        println(map1.keys)
        println(map1.values)

        for (i <- map1) println(i)

        println(map1.getOrElse("王五", 12))

        map1 += "王五" -> 25
        println(map1)

        map1 -= "李四"
        println(map1)

        map1 += ("李四" -> 23, "王五" -> 12)
        println(map1)
    }
}