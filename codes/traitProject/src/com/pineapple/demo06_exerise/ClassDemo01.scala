package com.pineapple.demo06_exerise

object ClassDemo01 {

    /**
     * 程序员类，表示所有程序员
     */
    abstract class Programmer {
        var name: String = _
        var age: Int = _

        def eat()

        def skill()
    }

    /**
     * Java程序猿类
     */
    class JavaProgrammer extends Programmer {

        override def eat(): Unit = println("Java程序猿吃大白菜，喝大米粥")

        override def skill(): Unit = println("我精通Java技术")
    }

    /**
     * Python程序猿类
     */
    class PythonProgrammer extends Programmer {

        override def eat(): Unit = println("Python程序猿吃小白菜，喝小米粥")

        override def skill(): Unit = println("我精通Python技术")
    }

    /**
     * 大数据技术
     */
    trait BigData {

        def learningBigData(): Unit = {
            println("来到黑马程序员之后")
            println("我学会了：Hadoop，Zookeeper，Hbase，Hive，Sqoop，Flink，Spark等技术")
        }
    }

    class PartJavaProgrammer extends JavaProgrammer with BigData {

        override def eat(): Unit = println("精通大数据 + Java技术的程序猿，吃牛肉，和牛奶")

        override def skill(): Unit = {
            super.skill()
            learningBigData()
        }
    }

    class PartPythonProgrammer extends PythonProgrammer with BigData {
        override def eat(): Unit = println("精通大数据 + Python技术的程序猿，吃羊肉，和羊奶")

        override def skill(): Unit = {
            super.skill()
            learningBigData()
        }
    }

    def main(args: Array[String]): Unit = {
        val jp = new JavaProgrammer
        jp.eat()
        jp.skill()
        println("-" * 15)

        val pjp = new PartJavaProgrammer
        pjp.eat()
        pjp.skill()
        println("-" * 15)

        val pp = new PythonProgrammer
        pp.eat()
        pp.skill()
        println("-" * 15)

        val ppp = new PartPythonProgrammer
        ppp.eat()
        ppp.skill()
    }
}