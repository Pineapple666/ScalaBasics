package pineapple.demo04_regex

object ClassDemo02 {
    def main(args: Array[String]): Unit = {
        // 1. 定义列表，记录所有邮箱
        val emailList = List("38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com", "123afadff.com")
        // 2. 定义正则表达式，来校验邮箱
        val regex = """.+@.+\..+""".r
        // 3. 通过filter方法，过滤出所有不合法的邮箱
        // x表示emailList中的每一个元素
//        val filteredList = emailList.filter(x => regex.findAllMatchIn(x).isEmpty)
        val filteredList = emailList.filter(regex.findAllMatchIn(_).isEmpty)
        // 4. 打印结果
        println(filteredList)
    }
}