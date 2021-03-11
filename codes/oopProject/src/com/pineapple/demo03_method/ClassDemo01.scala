package com.pineapple.demo03_method

/**
 * 案例：演示如何在类中定义成员方法
 */
object ClassDemo01 {

    class Customer {
        var name: String = _
        var sex: String = _

        def printHello(msg: String): Unit = println(msg)
    }

    def main(args: Array[String]): Unit = {
        val c = new Customer
        c.name = "Pineapple"
        c.sex = "Male"
        println(c.name, c.sex)
        c.printHello("Hello, Scala")
    }
}