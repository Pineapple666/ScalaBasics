package com.pineapple.demo04_constructor

object ClassDemo01 {

    trait Logger {
        println("执行Logger构造器")
    }

    trait MyLogger extends Logger {
        println("执行MyLogger构造器")
    }

    trait TimeLogger extends Logger {
        println("执行TimeLogger的构造器")
    }

    class Person {
        println("执行Person的构造器")
    }

    class Student extends Person with MyLogger with TimeLogger {
        println("执行Student类的构造器")
    }

    def main(args: Array[String]): Unit = {
        val s = new Student
    }
}
