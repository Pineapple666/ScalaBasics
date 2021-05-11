package pineapple.demo_extractor

object ClassDemo01 {

    class Student(var name: String, var age: Int)

    object Student {

        // apply() 根据给定的字段，将其封装成一个Student对象
        def apply(name: String, age: Int) = new Student(name, age)

        // unapply() 根据传入的学生对象，获取其对应的各个属性值
        def unapply(s: Student): Option[(String, Int)] = {
            if (s == null)
                None
            else
                Some(s.name, s.age)
        }
    }


    def main(args: Array[String]): Unit = {
        // 3. 创建学生类对象
        // 方式一：
        val s1 = new Student("张三", 23)
        // 方式二：免new
        val s2 = Student("李四", 24)

        // 4. 获取对象中的各个属性值，然后打印
        // 方式一：普通获取
        println(s1.name, s1.age)

        println("-" * 15)

        // 方式二：直接调用unapply
        println(Student.unapply(s1))

        // 方式三：通过模式匹配获取
        s1 match {
            case Student(name, age) => println(s"${name}, ${age}")
            case _ => println("未匹配")
        }
    }
}