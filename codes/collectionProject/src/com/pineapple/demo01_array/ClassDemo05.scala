package com.pineapple.demo01_array

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val arr1 = Array(4, 1, 6, 5, 2, 3)
        println(s"sum: ${arr1.sum}")
        println(s"max: ${arr1.max}")
        println(s"min: ${arr1.min}")
        val arr2 = arr1.sorted
        val arr3 = arr1.reverse     // 先升序再反转，其实就相当于降序

        for (i <- arr1) println(i)
        println("-" * 15)
        for (i <- arr2) println(i)
        println("-" * 15)
        for (i <- arr3) println(i)
    }
}