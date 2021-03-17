package com.pineapple.demo07_function

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val list1 = List("hadoop hive spark flink flume", "kudu hbase sqoop storm")
        // 获取文本行中的每一个单词，并将每一个单词都放到列表中
        // 方式一：先map，再flatten
        val list2 = list1.map((x: String) => {
            x.split(" ")
        })
        val list3 = list2.flatten
        println(list3)

        // 方式二：直接通过flatMap实现
        val list4 = list1.flatMap(_.split(" "))
        println(list4)
    }
}