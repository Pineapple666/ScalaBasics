package pineapple.demo01_match

object ClassDemo09 {

	def main(args: Array[String]): Unit = {
		val map1 = Map("张三" -> 23, "李四" -> 24, "王五" -> 23, "赵六" -> 26)
		for ((k, v) <- map1 if v == 23) println(k, v)
		println("-" * 15)

		for ((k, 23) <- map1) println(k, 23)
	}
}