package pineapple.demo01_match

object ClassDemo04 {

	case class Customer(name: String, age: Int)

	case class Order(id: Int)

	def main(args: Array[String]): Unit = {
		//		val c: Any = Customer("张三", 23)
		val c: Any = Order(66)
		//		val c: Any = List(1, 2, 3)
		c match {
			case Customer(name, age) => println(s"Customer类型的对象, name=$name, age=$age")
			case Order(id) => println(s"Order类型的对象, id=$id")
			case _ => println("未匹配")
		}
	}
}