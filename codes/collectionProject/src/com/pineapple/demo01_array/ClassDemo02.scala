package com.pineapple.demo01_array

import scala.collection.mutable.ArrayBuffer

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val arr1 = ArrayBuffer[Int]()
        val arr2 = ArrayBuffer("Hadoop", "Storm", "Spark")

        println(arr1)
        println(arr2)
    }
}