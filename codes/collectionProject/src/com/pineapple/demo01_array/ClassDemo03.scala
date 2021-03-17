package com.pineapple.demo01_array

import scala.collection.mutable.ArrayBuffer

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val arr1 = ArrayBuffer("Hadoop", "Spark", "Flink")
        arr1 += "Flume"
        arr1 -= "Hadoop"
        arr1 ++= Array("Hive", "Sqoop")
        arr1 --= Array("Sqoop", "Spark")
        println(arr1)
    }
}