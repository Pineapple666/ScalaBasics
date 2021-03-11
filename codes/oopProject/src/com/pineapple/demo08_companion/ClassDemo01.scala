package com.pineapple.demo08_companion

/**
 * 案例：演示如何定义伴生对象
 */
object ClassDemo01 {

    class Generals {

        def toWar(): Unit = println(s"武将拿着${Generals.armsName}，上阵杀敌")
    }

    object Generals {

        private val armsName = "青龙偃月刀"
    }

    def main(args: Array[String]): Unit = {
        val c = new Generals
        c.toWar()
    }
}