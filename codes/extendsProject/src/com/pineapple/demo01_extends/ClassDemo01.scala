package com.pineapple.demo01_extends

object ClassDemo01 {

    class Teacher {
        var name: String = _
        var age: Int = _

        def eat(): Unit = println("人要吃饭")
    }

    class Student extends Teacher

    def main(args: Array[String]): Unit = {
        val t = new Teacher
        t.name = "刘老师"
        t.age = 33
        println(t.name, t.age)
        t.eat()
        println("-" * 15)
        val s = new Student
        s.name = "Pineapple"
        s.age = 20
        println(s.name, s.age)
        s.eat()
    }
}