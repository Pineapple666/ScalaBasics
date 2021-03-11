package com.pineapple.demo05_extends

object ClassDemo01 {

    class Message {

        def printMsg(): Unit = println("学好Scala，走到哪里都不怕！")
    }

    trait Logger extends Message

    object ConsoleLogger extends Logger

    def main(args: Array[String]): Unit = {
        ConsoleLogger.printMsg()
    }
}