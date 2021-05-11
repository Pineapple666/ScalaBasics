package pineapple.demo01_match

object ClassDemo07 {

	def main(args: Array[String]): Unit = {
		val tuple1 = (1, 2, 3)
		val tuple2 = (3, 4, 5)

		tuple1 match {
			case (1, x, y) => println(s"匹配元组：长度为3，开头为1，其他元素为：$x, $y")
			case (x, y, 5) => println(s"匹配元组：长度为3，结尾为5，其他元素为：$x, $y")
			case _ => println("未匹配")
		}
	}
}