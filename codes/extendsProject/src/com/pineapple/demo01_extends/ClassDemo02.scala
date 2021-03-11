package com.pineapple.demo01_extends

object ClassDemo02 {

    class Person {
        var name: String = _

        def sayHello(): Unit = println(s"Hello, $name")
    }

    object Student extends Person

    def main(args: Array[String]): Unit = {
        Student.name = "Pineapple"
        Student.sayHello()
    }
}