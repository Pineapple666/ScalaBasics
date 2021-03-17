package com.pineapple.demo03_list

import scala.collection.mutable.ListBuffer

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val list1 = ListBuffer(1, 2, 3)
        println(list1)

        println(list1(1))

        list1 += 4
        println(list1)

        list1 ++= List(5, 6, 7)
        println(list1)

        list1 -= 7
        println(list1)

        list1 --= List(5, 6)
        println(list1)

        val list2 = list1.toList
        val arr = list1.toArray
        println(s"List: $list1")
        println(s"Array: $arr")
    }
}