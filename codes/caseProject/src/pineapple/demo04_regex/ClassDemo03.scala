package pineapple.demo04_regex

object ClassDemo03 {
    def main(args: Array[String]): Unit = {
        // 1. 定义列表，记录邮箱"38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com"，"123afadff.com"
        val emailList = List("38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com", "123afadff.com")
        // 2. 使用正则表达式进行模式匹配，匹配出来邮箱运营商的名字
        // 2.1 定义正则表达式，校验邮箱
        val regex = """.+@(.+)\..+""".r
        // 2.2 通过模式匹配，获取邮箱运营商
        val list2 = emailList.map {
            case x@regex(company) => company
            case x => "未匹配"
        }
        // 2.3 打印结果
        println(list2)
    }
}