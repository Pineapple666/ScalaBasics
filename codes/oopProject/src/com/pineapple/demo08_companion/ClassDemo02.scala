package com.pineapple.demo08_companion

/**
 * 案例：演示private[this]访问权限修饰符
 */
object ClassDemo02 {

    class Person(private var name: String)
//    class Person(private[this] var name: String) 这样写会报错

    object Person {

        def printPerson(p: Person): Unit = println(p.name)
    }

    def main(args: Array[String]): Unit = {
        val p = new Person("Pineapple")
        Person.printPerson(p)
    }

}