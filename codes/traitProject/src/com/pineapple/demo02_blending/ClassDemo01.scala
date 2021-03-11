package com.pineapple.demo02_blending

object ClassDemo01 {

    trait Logger {

        def log(msg: String): Unit = println(msg)
    }

    class User

    def main(args: Array[String]): Unit = {
        val u = new User with Logger
        u.log("对象混入")
    }
}