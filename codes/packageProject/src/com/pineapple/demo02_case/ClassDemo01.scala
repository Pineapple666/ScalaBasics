package com.pineapple.demo02_case

object ClassDemo01 {

    case class Person(name: String = "张三", var age: Int = 23) {}

    def main(args: Array[String]): Unit = {
        val p = new Person
        println(s"修改前：${p.name}, ${p.age}")

        //        p.name = "李四"       // 这样写会报错，因为在定义成员变量值没有用val或var修饰，系统默认用val
        p.age = 30
        println(s"修改后：${p.name}, ${p.age}")
    }
}