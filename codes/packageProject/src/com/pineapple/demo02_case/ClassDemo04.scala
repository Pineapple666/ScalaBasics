package com.pineapple.demo02_case

object ClassDemo04 {

    case class Calculate(a: Int, b: Int) {

        def add(): Int = a + b

        def subtract(): Int = a - b

        def multiply(): Int = a * b

        def divide(): Int = a / b
    }

    def main(args: Array[String]): Unit = {
        val c = Calculate(10, 3)
        println("加法：" + c.add())
        println("减法：" + c.subtract())
        println("乘法：" + c.multiply())
        println("除法：" + c.divide())
    }
}