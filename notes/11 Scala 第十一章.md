# Scala 第十一章

## 章节目标

1. 掌握模式匹配的相关内容
2. 掌握option类型及偏函数的用法
3. 掌握异常处理的用法
4. 理解正则表达式的作用
5. 理解提取器的用法
6. 掌握随机职业案例



## 1. 模式匹配

适用范围：

- 判断固定值
- 类型查询
- 快速获取数据

### 1.1 简单模式匹配

一个匹配模式包含了一系列备选项，每个备选项都开始于关键字`case`，且每个备选项都包含了一个模式及一到多各表达式。箭头符号 `=>` 隔开了模式和表达式。

**格式	**

```scala
变量 match {
    case "常量1" => 表达式1
    case "常量2" => 表达式2
    case "常量3" => 表达式3
    case _ => 表达式4		// 默认匹配项
}
```

有点类似于C/C++、Java等语言的switch case

**示例	**

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo01.scala
请录入一个字符串(单词):
hadoop
大数据分布式存储计算框架
---------------
大数据分布式存储计算框架
```

### 1.2 匹配类型

根据不同的数据类型来执行不同的逻辑	

**格式**

```scala
对象名 match {
    case 变量名1: 类型1 => 表达式1
    case 变量名2: 类型2 => 表达式2
    case 变量名3: 类型3 => 表达式3
    ...
    case _ => 表达式4
}
```

> ```
> 当进行case校验时，如果变量没有在表达式中使用，则可以用 _ 代替
> ```

示例：

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo02.scala
1.3 是一个Double类型的数据
Double
```

### 1.3 守卫

守卫是指在case语句中添加`if条件判断`

**格式	**

```scala
变量 match {
    case 变量名1 if条件1 => 表达式1
    case 变量名1 if条件2 => 表达式2
    case 变量名1 if条件3 => 表达式3
    case _ => 表达式4		// 默认匹配项
}
```

示例：

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo03.scala
请录入一个整数：
2
[0-3]
```

### 1.4 匹配样例类

通过匹配样例类快速获取样例类中的成员数据

**格式	**

```scala
对象名 match {
    case 样例类型1(字段1, 字段2, 字段n) => 表达式1
    case 样例类型2(字段1, 字段2, 字段n) => 表达式2
    case 样例类型3(字段1, 字段2, 字段n) => 表达式3
    ...
    case _ => 表达式4
}
```

>注意：
>
>- 样例类的小括号中，编写的字段个数要和该样例类的字段个数保持一致
>- 通过match进行模式匹配的时候，要匹配的对象必须声明为：Any类型

示例：

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo04
Order类型的对象, id=66
```

### 1.5 匹配集合

Scala还能匹配数组，元组，集合（列表，集，映射）等

#### 1.5.1 示例一：匹配数组

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo05.scala
匹配到数组：长度为3，首元素为1，剩下两个元素为2, 3
```

#### 1.5.2 示例二：匹配列表

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo6.scala
匹配列表：只包含一个元素0的列表
匹配列表：以元素0开头，其他元素无所谓的列表
```

#### 1.5.3 案例三：匹配元组

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo07.scala
匹配元组：长度为3，开头为1，其他元素为：2, 3
```

### 1.6 变量声明中的模式匹配

在定义变量时，可以使用匹配模式快速获取数据。例如：快速从数组，列表中获取数据

```scala
package com.pineapple.demo01_match

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
```

```bash
$ scala ClassDemo08.scala
(1,2,3)
---------------
(0,1)
(0,1)
```

### 1.7 匹配for表达式

使用匹配模式匹配for表达式，可以实现快速获取指定数据

```scala
package com.pineapple.demo01_match

object ClassDemo09 {

	def main(args: Array[String]): Unit = {
		val map1 = Map("张三" -> 23, "李四" -> 24, "王五" -> 23, "赵六" -> 26)
		for ((k, v) <- map1 if v == 23) println(k, v)
		println("-" * 15)

		for ((k, 23) <- map1) println(k, 23)
	}
}
```

```bash
(张三,23)
(王五,23)
---------------
(张三,23)
(王五,23)
```



## 2. Option类型

### 2.1 概述

实际开发中，在返回一些数据时，难免会遇到`空指针异常(NullPointerException)`，遇到一次就处理一次相对来讲还是比较繁琐的。在Scala中，我们返回某些数据时，可以返回一个Option类型的对象来封装具体的数据，从而实现有效的避免空指针异常。

2.2 格式

Scala中，Option类型表示可选值。这种类型的数据有两种形式：

- Some(x)：表示实际的值

  ![image-20210511093454286](https://raw.githubusercontent.com/Pineapple666/TyporaImage/main/img/image-20210511093454286.png)
  
- None：表示没有值

  ![image-20210511094941385](https://raw.githubusercontent.com/Pineapple666/TyporaImage/main/img/image-20210511094941385.png)

  > 注意：使用getOrElse()方法，当值为None时可以指定一个默认值

### 2.3 实例

```scala
package pineapple.demo02_option

object ClassDemo01 {

    //1. 定义一个两个数相除的方法，使用Option类型来封装结果
    def divide(a: Int, b: Int): Int = a / b

    def main(args: Array[String]): Unit = {
        //2.打印结果
        val result1 = divide(10, 0)
        println(s"result: ${result1}")
    }
}
```

运行后直接抛出异常：

```scala
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at pineapple.demo02_option.ClassDemo01$.divide(ClassDemo01.scala:6)
	at pineapple.demo02_option.ClassDemo01$.main(ClassDemo01.scala:10)
	at pineapple.demo02_option.ClassDemo01.main(ClassDemo01.scala)
```

使用Option类型后，返回结果可以自定义：

```scala
package pineapple.demo02_option

object ClassDemo01 {

    //1. 定义一个两个数相除的方法，使用Option类型来封装结果
    def divide(a: Int, b: Int): Option[Int] = {
        if (b == 0)
            None
        else
            Some(a / b)
    }

    def main(args: Array[String]): Unit = {
        //2.打印结果
        val result1 = divide(10, 0)
        println(s"result: ${result1}")
    }
}
```

```scala
result: None
```

```scala
package pineapple.demo02_option

object ClassDemo01 {

    //1. 定义一个两个数相除的方法，使用Option类型来封装结果
    def divide(a: Int, b: Int): Option[Int] = {
        if (b == 0)
            None
        else
            Some(a / b)
    }

    def main(args: Array[String]): Unit = {
        //2.打印结果
        //思路一：普通实现
        val result1 = divide(10, 0)
        println(s"result: ${result1}")

        println("-" * 15)

        //思路二：通过模式匹配实现
        result1 match {
            case Some(value) => println(s"商为：${value}")
            case None => println("除数不能为0")
        }

        println("-" * 15)

        //思路三：通过getOrElse()方法实现
        println(result1.getOrElse("除数不能为0"))
    }
}
```

```scala
result: None
---------------
除数不能为0
---------------
除数不能为0
```

把除数改为2后：

```scala
result: Some(5)
---------------
商为：5
---------------
5
```



## 3. 偏函数

### 3.1 定义

偏函数提供了更简洁的语法，可以简化函数的定义。配合集合的函数式编程，可以让代码更加优雅。
所谓的偏函数是指`被包在花括号内没有match的一组case语句`，偏函数是`PartialFunction[A,B]`类型的的一个`实例对象`,其中A代表输入参数类型,B代表返回结果类型.

### 3.2 格式

```scala
val 对象名 = {
    case 值1 => 表达式1
    case 值2 => 表达式2
    case 值3 => 表达式3
}
```

### 3.3 案例一：入门案例

```scala
package pineapple.demo03_partialfunction

object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        // 1. 定义偏函数，根据给定的函数返回对应的字符串
        val pf: PartialFunction[Int, String] = {
            case 1 => "一"
            case 2 => "二"
            case 3 => "三"
            case _ => "未匹配"
        }
        // 2. 调用
        println(pf(1))
        println(pf(2))
        println(pf(3))
        println(pf(100))
    }
}
```

```scala
一
二
三
未匹配
```

### 3.4 示例二：结合map函数使用

```scala
package pineapple.demo03_partialfunction

object ClassDemo02 {
    def main(args: Array[String]): Unit = {
        // 1. 定义一个列表，包含1-10的数字
        val list1 = (1 to 10).toList

        val list2 = list1.map {
            // 2. 将1-3的数字都转换为[1-3]
            case x if x >= 1 && x <= 3 => "[1-3]"
            // 3. 将4-8的数字都转换为[4-8]
            case x if x >= 4 && x <= 8 => "[4-8]"
            // 4. 将其他的数字转换为(8-*)
            case _ => "(8-*)"
        }
        // 5. 打印结果
        println(list2)
    }
}
```

```scala
List([1-3], [1-3], [1-3], [4-8], [4-8], [4-8], [4-8], [4-8], (8-*), (8-*))
```



## 4. 正则表达式

### 4.1 概述

所谓的正则表达式指的是正确的，符合特定规则的式子，它是一门独立的语言,并且能被兼容到绝大多数的编程语言中.在scala中,可以很方便地使用正则表达式来匹配数据。具体如下:

1. Scala中提供了`Regex`类来定义正则表达式.
2. 要构造一个Regex对象，直接使用string类的r方法即可.
3. `建议使用三个双引号来表示正则表达式，不然就得对正则中的反斜杠进行转义`.

### 4.2 格式

```scala
val 正则变量名 = """具体的正则表达式""".r
```

> 注意:使用`findAll`, `Matchln`方法可以获取到所有正则匹配到的数据(字符串).

### 4.3 示例一：校验邮箱是否合法

```scala
package pineapple.demo04_regex

object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        // 1. 定义一个字符串，表示邮箱
        val email = "qq123453@163.com"
        // 2. 定义一个正则表达式，来匹配邮箱是否合法
        val regex = """.+@.+\..+""".r
        // 校验
        // findAllMatchIn 获取所有符合规则的字符串
        if (regex.findAllMatchIn(email).nonEmpty) {
            println(s"${email}是一个合法的邮箱")
        } else
            println(s"${email}是一个非法的邮箱")
    }
}
```

```scala
qq123453@163.com是一个合法的邮箱
```

把邮箱的@符号去掉：

```scala
qq123453163.com是一个非法的邮箱
```

### 4.4 示例二：过滤所有不合法邮箱

```scala
package pineapple.demo04_regex

object ClassDemo02 {
    def main(args: Array[String]): Unit = {
        // 1. 定义列表，记录所有邮箱
        val emailList = List("38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com", "123afadff.com")
        // 2. 定义正则表达式，来校验邮箱
        val regex = """.+@.+\..+""".r
        // 3. 通过filter方法，过滤出所有不合法的邮箱
        // x表示emailList中的每一个元素
//        val filteredList = emailList.filter(x => regex.findAllMatchIn(x).isEmpty)
        val filteredList = emailList.filter(regex.findAllMatchIn(_).isEmpty)
        // 4. 打印结果
        println(filteredList)
    }
}
```

```scala
List(123afadff.com)
```

### 4.5 示例三：获取邮箱运营商

```scala
package pineapple.demo04_regex

object ClassDemo03 {
    def main(args: Array[String]): Unit = {
        // 1. 定义列表，记录邮箱"38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com"，"123afadff.com"
        val emailList = List("38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com", "123afadff.com")
        // 2. 使用正则表达式进行模式匹配，匹配出来邮箱运营商的名字
        // 2.1 定义正则表达式，校验邮箱
        val regex = """.+@(.+)\..+""".r
        // 2.2 通过模式匹配，获取邮箱运营商
        val list2 = emailList.map {
            case x@regex(company) => company
            case x => "未匹配"
        }
        // 2.3 打印结果
        println(list2)
    }
}
```

```scala
List(qq, gmail, 163, 未匹配)
```



## 6. 异常处理

### 6.1 捕获异常

#### 格式

与Java类似

```scala
try {
    // 可能出现异常的代码
}
catch {
    case ex:异常类型1 => // 代码
    case ex:异常类型2 => // 代码
}
finally {
    // 代码
}
```

### 6.2 抛出异常

```scala
throw new Exception("异常描述信息")
```

### 6.3 示例

```scala
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
```

```scala
java.lang.ArithmeticException: / by zero
	at pineapple.demo05_exception.ClassDemo01$.main(ClassDemo01.scala:6)
	at pineapple.demo05_exception.ClassDemo01.main(ClassDemo01.scala)
我是用来释放资源的.
看看我会不会执行...2333
Exception in thread "main" java.lang.Exception: 我是一个异常
	at pineapple.demo05_exception.ClassDemo01$.main(ClassDemo01.scala:16)
	at pineapple.demo05_exception.ClassDemo01.main(ClassDemo01.scala)
```



## 7. 提取器

### 7.1 概述

我们之前已经使用过Scala中非常强大的模式匹配功能了，通过模式匹配，我们可以快速获取样例类对象中的成员变量值。例如:

```scala
package com.pineapple.demo01_match

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
```

但并不是所有的类都能进行这样的模式匹配，想要模式匹配必须实现一个提取器

> 注意：
>
> 1. 提取器指的就是unapply()方法
> 2. 样例类自动实现了apply()、unapply()方法，无需手动定义

### 6.2 格式

要想实现一个提取器，只需要在该类的伴生对象中实现一个unapply()方法即可

**语法格式**

```scala
def unapply(stu: Student): Option[(类型1, 类型2, 类型3...)] = {
    if (stu != null) {
        Some ((变量1, 变量2, 变量3...))
    } else {
        None
    }
}
```

![image-20210511165614422](https://raw.githubusercontent.com/Pineapple666/TyporaImage/main/img/image-20210511165614422.png)



![image-20210511165628432](https://raw.githubusercontent.com/Pineapple666/TyporaImage/main/img/image-20210511165628432.png)

### 6.3 示例

```scala
package pineapple.demo_extractor

object ClassDemo01 {

    class Student(var name: String, var age: Int)

    object Student {

        // apply() 根据给定的字段，将其封装成一个Student对象
        def apply(name: String, age: Int) = new Student(name, age)

        // unapply() 根据传入的学生对象，获取其对应的各个属性值
        def unapply(s: Student): Option[(String, Int)] = {
            if (s == null)
                None
            else
                Some(s.name, s.age)
        }
    }


    def main(args: Array[String]): Unit = {
        // 3. 创建学生类对象
        // 方式一：
        val s1 = new Student("张三", 23)
        // 方式二：免new
        val s2 = Student("李四", 24)

        // 4. 获取对象中的各个属性值，然后打印
        // 方式一：普通获取
        println(s1.name, s1.age)

        println("-" * 15)

        // 方式二：直接调用unapply
        println(Student.unapply(s1))

        // 方式三：通过模式匹配获取
        s1 match {
            case Student(name, age) => println(s"${name}, ${age}")
            case _ => println("未匹配")
        }
    }
}
```

```scala
(张三,23)
---------------
Some((张三,23))
张三, 23
```