package com.pineapple.demo03_pattern

object ClassDemo01 {

    trait PlayLOL {

        def top()

        def mid()

        def adc()

        def support()

        def jungle()

        def schoolChild()
    }

    abstract class Player extends PlayLOL {

        override def top(): Unit = {}

        override def mid(): Unit = {}

        override def adc(): Unit = {}

        override def support(): Unit = {}

        override def jungle(): Unit = {}

        override def schoolChild(): Unit = {}
    }

    class GreenHand extends Player {

        override def support(): Unit = println("B键一扣，不死不回城！")

        override def schoolChild(): Unit = println("你骂我，我就挂机！")
    }

    def main(args: Array[String]): Unit = {
        val gh = new GreenHand
        gh.support()
        gh.schoolChild()
    }
}