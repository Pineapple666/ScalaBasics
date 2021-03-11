package com.pineapple {
    package scala {

        class A

        trait B

        //        var name = ""   // 无法在包中定义对象和方法，指定定义类和特质

        package object scala {
            var name = "Pineapple"

            def sayHello(): Unit = println("Hello, Scala")
        }

        object ClassDemo03 {
            def main(args: Array[String]): Unit = {
                println(scala.name)
                scala.sayHello()
            }
        }

    }

}