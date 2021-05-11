package pineapple.demo01_match

object ClassDemo05 {

	def main(args: Array[String]): Unit = {
		val arr1 = Array(1, 2, 3)
		val arr2 = Array(0)
		val arr3 = Array(0, 1, 2, 3, 4, 5)

		arr1 match {
			case Array(1, x, y) => println(s"匹配到数组：长度为3，首元素为1，剩下两个元素为$x, $y")
			case Array(0) => println("匹配到数组：长度为1，且只有一个元素0")
			// 下划线表示任意数据
			case Array(0, _*) => println("匹配到数组")
			case _ => println("未匹配")
		}
	}
}