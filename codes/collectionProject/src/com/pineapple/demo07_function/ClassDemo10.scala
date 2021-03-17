package com.pineapple.demo07_function

object ClassDemo10 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 10).toList
        // 使用reduce计算所有元素的和
        val list2 = list1.reduce(_ - _)
        println(list2)

        val list3 = list1.reduceLeft(_ - _)
        println(list3)

        val list4 = list1.reduceRight(_ - _)
        println(list4)
    }
}