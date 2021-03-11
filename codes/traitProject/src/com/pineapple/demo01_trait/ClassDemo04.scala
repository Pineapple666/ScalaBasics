package com.pineapple.demo01_trait

object ClassDemo04 {

    trait Hero {
        var name: String = "关羽"
        var arms: String

        def eat(): Unit = println("吃酒喝肉，养精蓄锐")

        def toWar(): Unit
    }

    class Generals extends Hero {

        override var arms: String = "青龙偃月刀"

        override def toWar(): Unit = println(s"武将${name}带着武器$arms，上阵杀敌")
    }

    def main(args: Array[String]): Unit = {
        val g = new Generals
        g.eat()
        g.toWar()
    }
}