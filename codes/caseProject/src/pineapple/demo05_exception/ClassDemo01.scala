package pineapple.demo05_exception

object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        try {
            val i = 10 / 0
        } catch {
            // 将异常类型，描述信息，出现位置打印在终端里
            case ex: Exception => ex.printStackTrace()
        } finally {
            println("我是用来释放资源的.")
        }
        println("看看我会不会执行...2333")

        // 抛出异常
        throw new Exception("我是一个异常")
        println("看看我会不会执行...2333")
    }
}