package com.pineapple.demo01_array

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val arr1 = Array(1, 2, 3, 4, 5)
        for (i <- 0 to arr1.length - 1) println(arr1(i))

        println("-" * 15)

        for (i <- 0 until arr1.length) println(arr1(i))

        println("-" * 15)

        for (i <- arr1) println(i)
    }
}