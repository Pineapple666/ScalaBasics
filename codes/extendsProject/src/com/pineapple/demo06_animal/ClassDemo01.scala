package com.pineapple.demo06_animal

object ClassDemo01 {

    abstract class Animal {
        var name: String = _
        var age: Int = _

        def run(): Unit = println("动物会跑步")

        def eat(): Unit
    }

    class Cat extends Animal {

        override def eat(): Unit = println("猫吃鱼")

        def catchMouse(): Unit = println("猫会抓老鼠")
    }

    class Dog extends Animal {

        override def eat(): Unit = println("狗吃肉")

        def lookHome(): Unit = println("狗会看家")
    }

    def main(args: Array[String]): Unit = {
        val cat: Animal = new Cat
        // val cat: Animal = new Dog
        cat.name = "加菲猫"
        cat.age = 2
        println(cat.name, cat.age)
        cat.run()
        cat.eat()
        if (cat.isInstanceOf[Cat]) {
            val cat2 = cat.asInstanceOf[Cat]
            cat2.catchMouse()
        } else {
            println("您传入的不是猫类对象")
        }
    }
}