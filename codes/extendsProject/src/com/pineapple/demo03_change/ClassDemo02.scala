package com.pineapple.demo03_change

object ClassDemo02 {

    class Person

    class Student extends Person

    def main(args: Array[String]): Unit = {
        // 通过多态的形式创建student类型的对象
        val person: Person = new Student
        println(person.isInstanceOf[Person])
        println(person.isInstanceOf[Student])
        println(person.getClass == classOf[Person])
        println(person.getClass == classOf[Student])
    }
}