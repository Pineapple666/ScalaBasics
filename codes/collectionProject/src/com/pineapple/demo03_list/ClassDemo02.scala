package com.pineapple.demo03_list

import scala.collection.mutable.ListBuffer

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val list1 = ListBuffer[Int]()
        val list2 = ListBuffer(1, 2, 3, 4)
        println(list1)
        println(list2)
    }
}
