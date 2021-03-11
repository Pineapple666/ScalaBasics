package com.pineapple.demo03_change

object ClassDemo01 {

    class Person

    class Student extends Person {

        def sayHello(): Unit = println("Hello, Student!")
    }

    def main(args: Array[String]): Unit = {
        /*
        多态：
        概述：同一个事物在不同时刻表现出来的不同形态，状态
        弊端：父类引用不能直接使用子类的特有成员
         */
        val p: Person = new Student
        // p.sayHello() 报错，父类引用不能直接使用子类的特有成员

        // 解决方案：
        if (p.isInstanceOf[Student]) {
            val s = p.asInstanceOf[Student]
            // 上面相当于：val s: Student = new Student
            s.sayHello()
        }
    }
}
