package com.pineapple.demo01_array

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val arr1 = new Array[Int](10)
        arr1(0) = 11
        println(arr1(0))
        println("-" * 15)

        val arr2 = Array("Java", "Scala", "Python")
        println(arr2.length)
        println(arr2.size)
    }
}