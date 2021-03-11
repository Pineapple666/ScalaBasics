package com.pineapple.demo04_abstract

object ClassDemo02 {

    abstract class Person {
        val occupation: String
    }

    class Student extends Person {
        override val occupation: String = "学生"
    }

    class Teacher extends Person {
        override val occupation: String = "老师"
    }

    def main(args: Array[String]): Unit = {
        val student = new Student
        val teacher = new Teacher
        println(student.occupation, teacher.occupation)
    }
}