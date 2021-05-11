package pineapple.demo01_match

import scala.io.StdIn

object ClassDemo03 {

	def main(args: Array[String]): Unit = {
		println("请录入一个整数：")
		val a = StdIn.readInt()

		// 模式匹配
		a match {
			case x if x >= 0 && x <= 3 => println("[0-3]")
			case x if x >= 4 && x <= 8 => println("[4-8]")
			case _ => println("未匹配")
		}
	}
}