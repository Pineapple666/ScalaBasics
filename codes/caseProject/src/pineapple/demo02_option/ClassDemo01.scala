package pineapple.demo02_option

object ClassDemo01 {

    //1. 定义一个两个数相除的方法，使用Option类型来封装结果
    def divide(a: Int, b: Int): Option[Int] = {
        if (b == 0)
            None
        else
            Some(a / b)
    }

    def main(args: Array[String]): Unit = {
        //2.打印结果
        //思路一：普通实现
        val result1 = divide(10, 2)
        println(s"result: ${result1}")

        println("-" * 15)

        //思路二：通过模式匹配实现
        result1 match {
            case Some(value) => println(s"商为：${value}")
            case None => println("除数不能为0")
        }

        println("-" * 15)

        //思路三：通过getOrElse()方法实现
        println(result1.getOrElse("除数不能为0"))
    }
}