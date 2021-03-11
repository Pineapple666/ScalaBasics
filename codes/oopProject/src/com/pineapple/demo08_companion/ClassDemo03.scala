package com.pineapple.demo08_companion

/**
 * 案例：伴生对象使用apply实现创建对象免new
 */
object ClassDemo03 {

    class Person(var name: String, var age: Int) {

        override def toString = s"Person($name, $age)"
    }

    object Person {

        def apply(name: String, age: Int): Unit = {

        }

    }

    def main(args: Array[String]): Unit = {
        val p: Unit = Person("Pineapple", 20)
        println(p)
    }
}