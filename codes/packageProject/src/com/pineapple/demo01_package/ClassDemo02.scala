//package com.pineapple.demo01_package

package com.pineapple {

    import scala.Student

    class Person

    class Teacher

    object ClassDemo02 {
        def main(args: Array[String]): Unit = {
            // 上层访问下层内容
            val s = new Student
            println(s)
        }
    }

    package scala {

        import com.pineapple

        class Person

        class Student

        //        object ClassDemo02 {
        //            def main(args: Array[String]): Unit = {
        //                // 测试下层访问上层内容
        //                val t = new Teacher
        //                println(t)
        //
        //                val s = new Student
        //                println(s)
        //
        //                // 就近访问
        //                val p = new Person
        //                println(p)
        //
        //                // 明确访问上层的类
        //                val p2 = new pineapple.Person
        //                println(p2)
        //            }
        //        }

    }

}
