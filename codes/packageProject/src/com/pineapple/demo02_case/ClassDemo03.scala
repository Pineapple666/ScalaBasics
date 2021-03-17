package com.pineapple.demo02_case

object ClassDemo03 {

    trait Sex

    case object Male extends Sex

    case object Female extends Sex

    case class Person(var name:String, var sex:Sex) {}

    def main(args: Array[String]): Unit = {
        val p = Person("张三", Female)
        println(p)
    }
}