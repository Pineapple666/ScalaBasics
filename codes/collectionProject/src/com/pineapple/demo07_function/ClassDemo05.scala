package com.pineapple.demo07_function

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 9).toList
        val list2 = list1.filter((x: Int) => {
            x % 2 == 0
        })
        println(list2)

        val list3 = list1.filter(_ % 2 == 0)
        println(list3)
    }
}