package pineapple.demo03_partialfunction

object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        // 1. 定义偏函数，根据给定的函数返回对应的字符串
        val pf: PartialFunction[Int, String] = {
            case 1 => "一"
            case 2 => "二"
            case 3 => "三"
            case _ => "未匹配"
        }
        // 2. 调用
        println(pf(1))
        println(pf(2))
        println(pf(3))
        println(pf(100))
    }
}