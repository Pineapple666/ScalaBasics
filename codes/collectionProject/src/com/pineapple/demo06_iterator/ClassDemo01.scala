package com.pineapple.demo06_iterator

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4, 5)
        val it = list1.iterator
        while (it.hasNext) {
            println(it.next())
        }
        println("-" * 15)
        println(it.next())
    }
}