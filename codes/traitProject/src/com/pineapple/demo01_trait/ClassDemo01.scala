package com.pineapple.demo01_trait

object ClassDemo01 {

    trait Logger {

        def log(msg: String)
    }

    class ConsoleLogger extends Logger {

        override def log(msg: String): Unit = println(msg)
    }

    def main(args: Array[String]): Unit = {
        val cl = new ConsoleLogger
        cl.log("类继承单个特质")
    }
}
