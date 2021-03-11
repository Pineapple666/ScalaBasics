package com.pineapple.demo01_oop

/**
 * 案例：演示类和对象的创建
 */
object ClassDemo02 {

    // 1. 创建Person类
    class Person {}

    // 2. 定义main方法，作为程序的主入口
    def main(args: Array[String]): Unit = {
        // 3. 创建Person类型的对象
        val p = new Person()
        // 4. 打印对象
        println(p)
    }
}