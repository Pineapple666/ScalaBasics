package com.pineapple.demo05_constructor

object ClassDemo01 {

    class Person(val name: String = "Pineapple", val age: Int = 20) {
        println("调用主构造器了！")

        override def toString = s"Person($name, $age)"
    }

    def main(args: Array[String]): Unit = {
        val p1 = new Person()
        println(p1)

        val p2 = new Person(age = 23)
        println(p2)

        val p3 = new Person("李四", 24)
        println(p3)
    }
}