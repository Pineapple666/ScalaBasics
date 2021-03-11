package com.pineapple.demo02_field

/**
 * 案例：演示在类中如何定义成员变量
 */
object ClassDemo01 {

    // 1. 创建Person类
    class Person {
        // 2. 定义姓名和年龄字段
        // 方式一：普通写法
        // val name:String = ""
        // 方式二：采用类型推断
        var name = "" // 姓名
        var age = 0 // 年龄
    }

    // 3. 定义main方法，作为程序的主入口
    def main(args: Array[String]): Unit = {
        // 4. 创建Person类型的对象，空参构造，可以不写 ()
        val p = new Person
        // 5. 给对象的成员变量赋值
        p.name = "张三"
        p.age = 23
        // 6. 打印属性值
        println(p.name, p.age)
    }
}