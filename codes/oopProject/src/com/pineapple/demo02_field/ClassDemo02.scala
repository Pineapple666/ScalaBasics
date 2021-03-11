package com.pineapple.demo02_field

/**
 * 案例：演示通过下划线来初始化成员变量
 */
object ClassDemo02 {

    class Person {
        // 方式一：普通写法
        // val name:String = ""
        // 方式二：采用类型推断
        // var name = ""
        // 方式三：采用下划线来初始化成员变量值
        var name: String = _
        var age: Int = _
    }

    def main(args: Array[String]): Unit = {
        val p = new Person
        p.name = "Pineapple"
        p.age = 20
        println(p.name, p.age)
    }
}