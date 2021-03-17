package com.pineapple.demo04_set

import scala.collection.mutable

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val set1 = mutable.Set(1, 2, 3, 4)
        set1 += 5
        println(set1)

        set1 ++= mutable.Set(6, 7, 8)
        println(set1)

        set1 ++= List(9, 10)
        println(set1)

        set1 -= 1
        println(set1)

        set1 --= mutable.Set(3, 5, 7)
        println(set1)

        set1 --= mutable.ListBuffer(2, 6)
        println(set1)
    }
}