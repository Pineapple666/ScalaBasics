package com.pineapple.demo03_list

object ClassDemo08 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        val list2 = List(3, 4, 5, 6)
        // 并集
        val unionList = list1.union(list2)
        // 在并集的基础上去重
        val distinctList = unionList.distinct
        // 交集
        val intersectList = list1.intersect(list2)
        // 差集
        val diffList = list1.diff(list2)

        println(unionList)
        println(distinctList)
        println(intersectList)
        println(diffList)
    }
}