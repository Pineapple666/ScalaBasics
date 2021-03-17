package com.pineapple.demo07_function

object ClassDemo09 {

    def main(args: Array[String]): Unit = {
        val list1 = List("刘德华" -> "男", "刘亦菲" -> "女", "胡歌" -> "男")
        val map1 = list1.groupBy(x => x._2)
        println(map1)

        // 统计人数
        val map2 = map1.map(x => x._1 -> x._2.length)
        println(map2)
    }
}