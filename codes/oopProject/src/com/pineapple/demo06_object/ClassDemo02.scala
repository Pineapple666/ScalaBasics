package com.pineapple.demo06_object

/**
 * 案例：演示在单例对象中定义成员方法
 */
object ClassDemo02 {

    object PrintUtil {

        def printSplitter(): Unit = println("-" * 15)
    }

    def main(args: Array[String]): Unit = {
        PrintUtil.printSplitter()
    }
}