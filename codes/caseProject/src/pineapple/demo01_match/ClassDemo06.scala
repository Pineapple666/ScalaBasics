package pineapple.demo01_match

object ClassDemo06 {

	def main(args: Array[String]): Unit = {
		val list1 = List(0)
		val list2 = List(0, 1, 2, 3)
		val list3 = List(22, 33)

		list1 match {
			case List(0) => println("匹配列表：只包含一个元素0的列表")
			case List(0, _*) => println("匹配列表：以元素0开头，其他元素无所谓的列表")
			case List(x, y) => println(s"匹配列表：只包含两个任意元素的列表这里元素为：$x, $y")
			case _ => println("为匹配")
		}

		list2 match {
			case 0 :: Nil => println("匹配列表：只包含一个元素0的列表")
			// tail表示除了第一个元素的所有元素
			case 0 :: tail => println("匹配列表：以元素0开头，其他元素无所谓的列表")
			case x :: y :: Nil => println(s"匹配列表：只包含两个任意元素的列表这里元素为：$x, $y")
			case _ => println("为匹配")
		}
	}
}