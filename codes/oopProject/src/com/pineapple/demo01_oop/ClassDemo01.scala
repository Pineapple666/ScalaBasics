package com.pineapple.demo01_oop

/**
 * 测试类，演示如何创建类和对象
 */
object ClassDemo01 {

    // main方法，程序的主入口
    def main(args: Array[String]): Unit = {
        // 创建Person类型的对象.
        val p = new Person()
        // 打印对象.
        println(p)
    }
}