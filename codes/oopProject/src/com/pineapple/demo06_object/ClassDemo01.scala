package com.pineapple.demo06_object

/**
 * 案例：演示如何创建单例对象
 */
object ClassDemo01 {

    object Dog {
        val leg_num = 4
    }

    def main(args: Array[String]): Unit = {
        println(Dog.leg_num)
    }
}