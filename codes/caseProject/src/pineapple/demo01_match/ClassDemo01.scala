package pineapple.demo01_match

import scala.io.StdIn

object ClassDemo01 {

	def main(args: Array[String]): Unit = {
		println("请录入一个字符串(单词):")
		val s = StdIn.readLine()

		val result = s match {
			case "hadoop" => "大数据分布式存储计算框架"
			case "zookeeper" => "大数据分布式协调服务框架"
			case "spark" => "大数据分布式内存计算框架"
			case _ => "未匹配"
		}

		println(result)
		println("-" * 15)

		// 简写
		s match {
			case "hadoop" => println("大数据分布式存储计算框架")
			case "zookeeper" => println("大数据分布式协调服务框架")
			case "spark" => println("大数据分布式内存计算框架")
			case _ => println("未匹配")
		}
	}
}