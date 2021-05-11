package pineapple.demo04_regex

object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        // 1. 定义一个字符串，表示邮箱
        val email = "qq123453163.com"
        // 2. 定义一个正则表达式，来匹配邮箱是否合法
        val regex = """.+@.+\..+""".r
        // 校验
        // findAllMatchIn 获取所有符合规则的字符串
        if (regex.findAllMatchIn(email).nonEmpty) {
            println(s"${email}是一个合法的邮箱")
        } else
            println(s"${email}是一个非法的邮箱")
    }
}