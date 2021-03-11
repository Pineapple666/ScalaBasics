package com.pineapple.demo05_inner

object ClassDemo01 {

    abstract class Person {

        def sayHello(): Unit
    }

    def show(person: Person): Unit = person.sayHello()

    def main(args: Array[String]): Unit = {
        // 对成员方法仅调用一次的时候，使用匿名内部类
        new Person {
            override def sayHello(): Unit = println("Hello, Scala")
        }.sayHello()

        // 多态
        val person: Person = new Person {
            override def sayHello(): Unit = println("Hello, Scala")
        }

        show(person)
    }
}