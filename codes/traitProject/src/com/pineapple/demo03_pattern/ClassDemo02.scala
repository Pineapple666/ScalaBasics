package com.pineapple.demo03_pattern

object ClassDemo02 {

    trait Template {

        def code()

        def getRuntime: Long = {
            val start = System.currentTimeMillis()
            code()
            val end = System.currentTimeMillis()
            end - start
        }
    }

    class ForDemo extends Template {
        override def code(): Unit = for (i <- 1 to 10000) println("Hello, Scala")
    }

    def main(args: Array[String]): Unit = {
        val fd = new ForDemo
        println(fd.getRuntime)
    }
}