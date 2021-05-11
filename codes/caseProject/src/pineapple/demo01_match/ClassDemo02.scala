package pineapple.demo01_match

object ClassDemo02 {

	def main(args: Array[String]): Unit = {
		//		val a: Any = "hadoop"
		val a: Any = 1.3

		val result1 = a match {
			case x: String => s"$x 是一个String类型的数据"
			case x: Int => s"$x 是一个Int类型的数据"
			case x: Double => s"$x 是一个Double类型的数据"
			case _ => "未匹配"
		}

		println(result1)

		// 简写版：当进行case校验时，如果变量没有在表达式中使用，则可以用 _ 代替
		val result2 = a match {
			case _: String => "String"
			case _: Int => "Int"
			case _: Double => "Double"
			case _ => "未匹配"
		}

		println(result2)
	}
}