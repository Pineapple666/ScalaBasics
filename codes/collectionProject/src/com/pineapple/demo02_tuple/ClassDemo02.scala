package com.pineapple.demo02_tuple

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val tuple1 = "zhangsan" -> "male"
        // 编号
        println(tuple1._1, tuple1._2)
        println("-" * 15)

        // 迭代器
        val it = tuple1.productIterator
        for (i <- it) println(i)
    }
}