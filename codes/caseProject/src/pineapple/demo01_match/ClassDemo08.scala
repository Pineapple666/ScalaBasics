package pineapple.demo01_match

object ClassDemo08 {

	def main(args: Array[String]): Unit = {
		val arr1 = (0 to 10).toArray
		val Array(_, x, y, z, _*) = arr1
		println(x, y, z)
		println("-" * 15)

		val list1 = (0 to 10).toList
		val List(a, b, _*) = list1
		val c :: d :: tail = list1
		println(a, b)
		println(c, d)
	}
}