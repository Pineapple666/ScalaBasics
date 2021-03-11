package com.pineapple {
    class Employee {
        // private[com]解释：
        // private的意思是：name这个成员变量只能在本类（Employee）中直接被访问
        // [com]的意思是：name成员变量可以在com包下的任意类中访问
        private[com] var name = "Pineapple"
        var age = 20

        private[pineapple] def sayHello(): Unit = println("Hello, Scala")
    }

    package scala {
        object ClassDemo04{
            def main(args: Array[String]): Unit = {
                val e = new Employee
                println(e)
                println(e.name, e.age)
                e.sayHello()
            }
        }
    }
}