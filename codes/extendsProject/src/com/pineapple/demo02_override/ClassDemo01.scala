package com.pineapple.demo02_override

object ClassDemo01 {

    class Person {
        val name = "张三"
        var age = 23

        def sayHello(): Unit = println(s"Hello, $name, i know your age is $age")
    }

    class Student extends Person {
        override val name = "李四"
        age = 20

        override def sayHello(): Unit = {
            super.sayHello()
            println(s"age $age, name $name")
        }
    }

    def main(args: Array[String]): Unit = {
        val s = new Student
        s.sayHello()
    }
}