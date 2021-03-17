package com.pineapple.demo08_exercise

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val student = List(("张三", 37, 90, 100), ("李四", 90, 73, 81), ("王五", 60, 90, 76), ("赵六", 59, 21, 72), ("田七", 100, 100, 100))
        // 获取语文分大于60
        val chineseList = student.filter(_._2 >= 60)
        println(chineseList)

        // 总成绩，x出现四次，不可用下划线优化
        val countList = student.map(x => x._1 -> (x._2 + x._3 + x._4))
        println(countList)

        // 总成绩排序
        val sortList = countList.sortWith((x, y) => x._2 > y._2)
        println(sortList)
    }
}