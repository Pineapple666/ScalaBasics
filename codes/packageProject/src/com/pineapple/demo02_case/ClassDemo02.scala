package com.pineapple.demo02_case

object ClassDemo02 {

    case class Person(var name: String, var age: Int) {}

    def main(args: Array[String]): Unit = {
        val p1 = Person("张三", 23)
        println(p1)

        val p2 = Person("张三", 23)
        println(p1 == p2)

        // 同一个对象哈希肯定相同，不同对象哈希值一般不同
        println(p1.hashCode, p2.hashCode)
        // 举例：内容不同，哈希值相同
        println("重地".hashCode, "通话".hashCode)
        println("重地1".hashCode, "通话1".hashCode)

        // copy()，快速构建一个类似的对象
        val p3 = p2.copy(age = 30)
        println(p3)
    }
}