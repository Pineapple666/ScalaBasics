package com.pineapple.demo04_access

/**
 * 案例：演示访问权限修饰符
 */
object ClassDemo01 {

    class Person {
        private var name: String = _
        private var age: Int = _

        def getName: String = name

        def setName(name: String): Unit = this.name = name

        def getAge: Int = age

        def setAge(age: Int): Unit = this.age = age
    }

    def main(args: Array[String]): Unit = {
        val p = new Person
        //        p.name = "张三"  报错，private修饰的变量只能在本类中访问
        p.setName("Pineapple")
        p.setAge(20)
        println(p.getName, p.getAge)
    }
}