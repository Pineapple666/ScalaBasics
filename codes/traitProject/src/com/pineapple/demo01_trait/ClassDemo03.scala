package com.pineapple.demo01_trait

object ClassDemo03 {

    trait Logger {

        def log(mes: String)
    }

    trait Warning {

        def warn(msg: String)
    }

    object ConsoleLogger extends Logger with Warning {

        override def log(msg: String): Unit = println("控制台日志信息：" + msg)

        override def warn(msg: String): Unit = println("控制台警告信息：" + msg)
    }

    def main(args: Array[String]): Unit = {
        ConsoleLogger.log("我是一条普通日志信息")
        ConsoleLogger.warn("我是一条警告信息")
    }
}