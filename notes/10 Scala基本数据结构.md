# Scala 基本数据结构



## 章节目标

1. 掌握数组，元组相关知识点
2. 掌握列表，集，映射相关知识点
3. 了解迭代器的用法
4. 掌握函数式编程
5. 掌握学生成绩单案例



## 1. 数组

### 1.1 概述

数组就是用来`存储多个同类型元素的容器`，每个元素都有编号（也叫：下标，脚标，索引），且编号都是从0开始数的。Scala中有两种数组，定长数组和边长数组。

### 1.2 定长数组

#### 1.2.1 特点

1. 数组的长度不允许改变
2. 数组的内容是可变的

#### 1.2.2 语法

- 格式一：通过指定长度定义数组

  ```scala
  val/var 变量名 = new Array[元素类型](数组长度)
  ```

- 格式二：通过指定元素定义数组

  ```scala
  val/var 变量名 = Array(元素1, 元素2, 元素3...)
  ```

> 注意：
>
> 1. 在Scala中，数组的泛型使用`[]`来指定
> 2. 使用数组名(索引)来获取数组中的元素
> 3. 数组元素是有默认值的，Int:0, Double:0.0, String: null
> 4. 通过数组名.length 或者 数组名.size 来获取数组的长度

#### 1.2.3 示例

```scala
package com.pineapple.demo01_array

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val arr1 = new Array[Int](10)
        arr1(0) = 11
        println(arr1(0))
        println("-" * 15)

        val arr2 = Array("Java", "Scala", "Python")
        println(arr2.length)
        println(arr2.size)
    }
}
```

### 1.3 变长数组

#### 1.3.1 特点

数组的长度和内容都是可变的，可以往数组中添加、删除元素

#### 1.3.2 语法

- 创建变长数组，需要先导入ArrayBuffer类

  ```scala
  import scala.collection.mutable.ArrayBuffer
  ```

- 定义格式一：创建空的ArrayBuffer变长数组

  ```scala
  val/var 变量名 = ArrayBuffer[元素类型]()
  ```

- 定义格式二：创建带有初始元素的ArrayBuffer变长数组

  ```scala
  val/var 变量名 = ArrayBuffer(元素1, 元素2, 元素3...)
  ```

#### 1.3.3 示例一：定义变长数组

```scala
package com.pineapple.demo01_array

import scala.collection.mutable.ArrayBuffer

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val arr1 = ArrayBuffer[Int]()
        val arr2 = ArrayBuffer("Hadoop", "Storm", "Spark")

        println(arr1)
        println(arr2)
    }
}
```

#### 1.3.4 示例二：增删改元素

针对Scala中的变长数组，可通过下述方式来修改数组中的内容

**格式**

- +=添加单个元素
- -=删除单个元素
- ++=追加一个数组到变长数组中
- --=移除变长数组中的指定多个元素

**示例**

```scala
package com.pineapple.demo01_array

import scala.collection.mutable.ArrayBuffer

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val arr1 = ArrayBuffer("Hadoop", "Spark", "Flink")
        arr1 += "Flume"
        arr1 -= "Hadoop"
        arr1 ++= Array("Hive", "Sqoop")
        arr1 --= Array("Sqoop", "Spark")
        println(arr1)
    }
}
```

### 1.4 遍历数组

**概述**

遍历数组的方式：

1. 索引
2. for表达式

**示例**

```scala
package com.pineapple.demo01_array

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val arr1 = Array(1, 2, 3, 4, 5)
        for (i <- 0 to arr1.length - 1) println(arr1(i))

        println("-" * 15)

        for (i <- 0 until arr1.length) println(arr1(i))

        println("-" * 15)

        for (i <- arr1) println(i)
    }
}
```

### 1.5 数组常用算法

**概述**

- sum()
- max()
- min()
- sorted() 排序，返回一个新的数组（升序）
- reverse() 反转，返回一个新的数组

**示例**

```scala
package com.pineapple.demo01_array

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val arr1 = Array(4, 1, 6, 5, 2, 3)
        println(s"sum: ${arr1.sum}")
        println(s"max: ${arr1.max}")
        println(s"min: ${arr1.min}")
        val arr2 = arr1.sorted
        val arr3 = arr1.reverse     // 先升序再反转，其实就相当于降序

        for (i <- arr1) println(i)
        println("-" * 15)
        for (i <- arr2) println(i)
        println("-" * 15)
        for (i <- arr3) println(i)
    }
}
```



## 2. 元组

元组一般用来存储多个不同类型的值。例如同时存储姓名，年龄，性别，出生年月这些数据。`元组的长度和元素都是不可变的`。可Python一样。

### 2.1 格式

- 格式一：通过小括号实现

  ```scala
  val/var 元组 = (元素1, 元素2, 元素3...)
  ```

- 格式二：通过箭头实现

  ```scala
  var/val 元组 = 元素1->元素2
  ```

  > 注意：上述情况只适用于元素只有两个元素

### 2.2 示例

```scala
package com.pineapple.demo02_tuple

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val tuple1 = ("张三", 23)
        val tuple2 = "李四" -> 24

        println(tuple1)
        println(tuple2)
    }
}
```

### 2.3 访问元组中的元素

1. 通过`元组名._编号`的形式来访问元素中的元组
2. `元组名.productIterator`，获取元组的迭代器，从而实现遍历元组

#### 示例

```scala
package com.pineapple.demo02_tuple

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val tuple1 = "zhangsan" -> "male"
        // 编号
        println(tuple1._1, tuple1._2)
        println("-" * 15)
        
        // 迭代器
        val it = tuple1.productIterator
        for (i <- it) println(i)
    }
}
```



## 3. 列表

列表（List）是Scala中最重要的。存储数据特点是：`有序`，`可重复`。列表也分为不可变列表和可变列表

> 有序的意思并不是排序，而是指元素的存入顺序和取出顺序是一致的

### 3.1 不可变列表

#### 3.1.1 特点

列表的元素、长度不可变

#### 3.1.2 语法

- 格式一：通过`小括号`直接初始化

  ```scala
  val/var 变量名 = List(元素1, 元素2...)
  ```

- 格式二：通过`Nil`创建一个空列表

  ```scala
  val/var 变量名 = Nil
  ```

- 格式三：使用`::`方法实现

  ```scala
  val/var 变量名 = 元素1 :: 元素2 :: Nil
  ```

#### 3.1.3 示例

```scala
package com.pineapple.demo02_tuple

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        val list2 = Nil
        val list3 = -2 :: -1 :: Nil

        println(s"list1: $list1")
        println(s"list2: $list2")
        println(s"list3: $list3")
    }
}
```

### 3.2 可变列表

#### 3.2.1 特点

列表的元素、长度都是可变的

#### 3.2.2 语法

- 导包

  ```scala
  import scala.collection.mutable.ListBuffer
  ```

  > 小技巧：可变集合都在`mutable`包中，不可变集合都在`immutable`包中（默认导入）

- 格式一：创建可变列表

  ```scala
  val/var 变量名 = ListBuffer[数据类型]()
  ```

- 格式二：通过`小括号`直接初始化

  ```scala
  val/var 变量名 = ListBuffer(元素1, 元素2, 元素3...)
  ```

#### 3.2.3 示例

```scala
package com.pineapple.demo02_tuple

import scala.collection.mutable.ListBuffer

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val list1 = ListBuffer[Int]()
        val list2 = ListBuffer(1, 2, 3, 4)
        println(list1)
        println(list2)
    }
}
```

#### 3.2.4 可变列表的常用操作

- += 添加元素
- ++= 追加一个列表
- -= 删除列表中的某个指定元素
- --= 以列表的形式，删除列表中多个元素
- toList 将可变列表（ListBuffer）转换为不可变列表
- toArray  将可变列表转换为数组

#### 3.2.5 示例

```scala
package com.pineapple.demo03_list

import scala.collection.mutable.ListBuffer

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val list1 = ListBuffer(1, 2, 3)
        println(list1)

        println(list1(1))

        list1 += 4
        println(list1)

        list1 ++= List(5, 6, 7)
        println(list1)

        list1 -= 7
        println(list1)

        list1 --= List(5, 6)
        println(list1)

        val list2 = list1.toList
        val arr = list1.toArray
        println(s"List: $list1")
        println(s"Array: $arr")
    }
}
```

### 3.3 列表的常用操作

#### 3.3.1 格式详解

| 格式      | 功能                                       |
| --------- | ------------------------------------------ |
| isEmpty   | 判断列表是否为空                           |
| ++        | 拼接两个列表，返回一个新列表               |
| head      | 获取列表首个元素                           |
| tail      | 获取列表中除首个元素之外，其他所有元素     |
| reverse   | 队列表进行反转，返回一个新列表             |
| take      | 获取列表中的前缀元素（具体个数可以定义）   |
| drop      | 获取列表中的后缀元素（具体个数可以定义）   |
| flatten   | 对列表进行扁平化操作，返回一个新的列表     |
| zip       | 队列表进行拉链操作，将两个列表合程一个列表 |
| unzip     | 对列表进行拉开操作，讲一个列表拆成两个列表 |
| toString  | 将列表转换成其对应的默认字符串形式         |
| mkString  | 将列表转换成其对应的指定字符串形式         |
| union     | 获取两个列表的`并集`元素，并返回一个新列表 |
| intersect | 获取两个列表的`并集`元素，返回一个新的列表 |
| diff      | 获取两个列表的`差集`元素，返回一个新的列表 |

#### 3.3.2 基础操作

```scala
package com.pineapple.demo03_list

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        println(s"isEmpty: ${list1.isEmpty}")

        val list2 = List(4, 5, 6)
        val list3 = list1 ++ list2
        println(s"list3: $list3")

        println(s"head: ${list1.head}")

        println(s"head: ${list1.tail}")

        println(s"reverse: ${list1.reverse}")

        // 前3个元素都是前缀元素
        println(s"take: ${list1.take(3)}")

        // 除了前三个元素，其它都是后缀元素
        println(s"drop: ${list1.drop(3)}")
    }
}
```

#### 3.3.3 示例二：扁平化（压平）

**概述**

扁平化表示将嵌套列表中的所有具体元素单独的放到一个新列表中：

> 注意：如果某个列表中的所有元素都是列表，那么这样的列表就称之为：嵌套列表

![image-20210316161909419](https://i.loli.net/2021/03/16/WchD9Q5mLYFiwVK.png)

**示例**

```scala
package com.pineapple.demo03_list

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val list1 = List(List(1, 2), List(3), List(4, 5))

        val list2 = list1.flatten

        println(s"list1: $list1")
        println(s"list2: $list2")
    }
}
```

### 3.3.4 示例三：拉链与拉开

**概述**

- 拉链：将两个列表，组合成一个元素为元组的列表
- 拉开：将一个包含元组的列表，拆解成包含两个列表的元组

示例：

```scala
package com.pineapple.demo03_list

object ClassDemo06 {

    def main(args: Array[String]): Unit = {
        val names = List("张三", "李四", "王五")
        val ages = List(23, 24, 25)
        val list1 = names.zip(ages)
        println(list1)
        
        val tuple1 = list1.unzip
        println(tuple1)
    }
}
```

### 3.3.5 示例四：列表转字符串

**概述**

将列表转换成其对应的字符串形式，可以通过toString方法或者mkString方法实现

- toString：返回list中的所有元素
- mkString：将元素以指定分隔符拼接起来

**示例**

```scala
package com.pineapple.demo03_list

object ClassDemo07 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        println(list1.toString)
        println(list1) // 简写形式，打印对象默认调用 toString

        println("-" * 15)

        println(list1.mkString)
        // 添加分隔符
        println(list1.mkString(":"))
        println(list1.mkString("，"))
    }
}
```

#### 3.3.6 示例五：并集交集，差集

**概述**

- union：表示对两个列表取并集，而且不去重

  > 去重使用distinct实现

- intersect：表示对两个列表取交集

- diff：表示对两个列表取差集

```scala
package com.pineapple.demo03_list

object ClassDemo08 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        val list2 = List(3, 4, 5, 6)
        // 并集
        val unionList = list1.union(list2)
        // 在并集的基础上去重
        val distinctList = unionList.distinct
        // 交集
        val intersectList = list1.intersect(list2)
        // 差集
        val diffList = list1.diff(list2)

        println(unionList)
        println(distinctList)
        println(intersectList)
        println(diffList)
    }
}
```



## 4. 集

### 4.1 概述

Set（也叫：集）代表没有重复元素的集合。特点是唯一，无序

Scala中的集分为两种，一种是不可变集，另一种是可变集。

> 解释：
>
> 1. 唯一的意思是set中的元素不重复
> 2. 无序的意思是set中的元素，添加顺序和取出顺序不一致

### 4.2 不可变集

元素和集合的长度不变

#### 4.2.1 语法

- 格式一：空

  ```scala
  val/var 变量名 = Set[类型]()
  ```

- 格式二：给定元素

  ```scala
  val/var 变量名 = Set(元素1, 2, 3...)
  ```

#### 4.2.2 示例一：创建不可变集

```scala
package com.pineapple.demo04_set

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val set1 = Set[Int]()
        val set2 = Set(1, 1, 2, 3, 3, 4, 8)
        println(set1)
        println(set2)
    }
}
```

```bash
$ scala ClassDemo01.scala
Set()
Set(1, 2, 3, 8, 4)
```

结果体现了两点：唯一和无序

### 4.3 可变集

#### 4.3.1 概述

元素和集的长度可变，需要导包`import scala.collection.mutable.Set`

#### 4.3.2 示例

```scala
package com.pineapple.demo04_set

import scala.collection.mutable

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val set1 = mutable.Set(1, 2, 3, 4)
        set1 += 5
        println(set1)

        set1 ++= mutable.Set(6, 7, 8)
        println(set1)

        set1 ++= List(9, 10)
        println(set1)

        set1 -= 1
        println(set1)

        set1 --= mutable.Set(3, 5, 7)
        println(set1)

        set1 --= mutable.ListBuffer(2, 6)
        println(set1)
    }
}
```

```bash
$ scala ClassDemo02.scala
Set(1, 5, 2, 3, 4)
Set(1, 5, 2, 6, 3, 7, 4, 8)
Set(9, 1, 5, 2, 6, 3, 10, 7, 4, 8)
Set(9, 5, 2, 6, 3, 10, 7, 4, 8)
Set(9, 2, 6, 10, 4, 8)
Set(9, 10, 4, 8)
```



## 5. 映射

映射指的就是Map。它是由键值对(key, value)组成的集合。特点是：键具有唯一性，但是值可以重复。在Scala中，Map也分为不可变Map和可变Map。

> 注意：如果添加重复元素（即：两组元素的键相同）则会用新值覆盖旧值

### 5.1 不可变Map

不可变Map指的是元素，长度都不变

语法

- 方式一：通过箭头实现

  ```scala
  val/var map = Map(键->值, 键->值, 键->值...)
  ```

- 方式二：通过小括号的方式实现

  ```scala
  val/var map = Map((键, 值), (键, 值), (键, 值), (键, 值)...)
  ```

示例

```scala
package com.pineapple.demo05_map

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val map1 = Map("张三" -> 23, "李四" -> 24, "李四" -> 40)
        val map2 = Map(("张三", 23), ("李四", 24), ("李四", 40))
        println(map1)
        println(map2)
    }
}
```

### 5.2 可变Map

元素，长度可变，导包`import scala.collection.mutable.Map`

```scala
package com.pineapple.demo05_map

import scala.collection.mutable

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val map1 = mutable.Map("张三" -> 23, "李四" -> 24)
        map1("张三") = 30
        println(map1)
    }
}
```

```bash
$ scala ClassDemo02.scala
```

### 5.3 Map基本操作

- map(key)：根据键获取其对应的值，键不存在返回None
- map.keys：获取所有键
- map.values：获取所有值
- 遍历map集合：通过for实现
- getOrElse：根据键获取其对应的值，如果键不存在，则返回指定的默认值
- +：增加键值对，并生成一个新的Map
- -：根据键删除其对应的键值对元素，并生成一个新的Map

示例：

```scala
package com.pineapple.demo05_map

import scala.collection.mutable

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val map1 = mutable.Map("张三" -> 23, "李四" -> 24)
        println(s"张三的年龄：" + map1("张三"))
        println(map1.keys)
        println(map1.values)

        for (i <- map1) println(i)

        println(map1.getOrElse("王五", 12))

        map1 += "王五" -> 25
        println(map1)

        map1 -= "李四"
        println(map1)

        map1 += ("李四" -> 23, "王五" -> 12)
        println(map1)
    }
}
```

```bash
$ scala ClassDemo03.scala
张三的年龄：23
Set(张三, 李四)
HashMap(23, 24)
(张三,23)
(李四,24)
12
Map(王五 -> 25, 张三 -> 23, 李四 -> 24)
Map(王五 -> 25, 张三 -> 23)
Map(王五 -> 12, 张三 -> 23, 李四 -> 23)
```



## 6. 迭代器

### 6.1 概述

迭代器（iterator），用来迭代访问集合

### 6.2 注意事项

1. 使用iterator方法可以从集合获取一个迭代器

   > 迭代器中两个方法：
   >
   > - hasNext：查询容器是否右下一个元素
   > - next：返回迭代器的下一个元素，如果没有，抛出NoSuchElementException

2. 每一个迭代器都是有状态的

   > 迭代完后保留在最后一个元素的位置，再次使用抛出NoSuchElementException

3. 可以使用while或for来逐个获取元素

### 6.3 示例

```scala
package com.pineapple.demo06_iterator

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4, 5)
        val it = list1.iterator
        while (it.hasNext) {
            println(it.next())
        }
        println("-" * 15)
        println(it.next())
    }
}
```

```bash
$ scala ClassDemo01.scala
1
2
3
4
5
---------------
Exception in thread "main" java.util.NoSuchElementException: next on empty iterator
	at scala.collection.Iterator$$anon$2.next(Iterator.scala:39)
	at scala.collection.Iterator$$anon$2.next(Iterator.scala:37)
	at scala.collection.LinearSeqLike$$anon$1.next(LinearSeqLike.scala:47)
	at com.pineapple.demo06_iterator.ClassDemo01$.main(ClassDemo01.scala:12)
	at com.pineapple.demo06_iterator.ClassDemo01.main(ClassDemo01.scala)
```



## 7. 函数式编程

- 所谓的函数式编程指的就是`方法的参数列表可以接受函数对象`
- 例如：add(10, 20)就不是函数式编程，而`add(函数对象`这种格式叫函数式编程
- Spark、Flink的代码也会用到函数式编程

| 函数名   | 功能                       |
| :------- | -------------------------- |
| foreach  | 遍历集合                   |
| map      | 对集合进行转换             |
| flatmap  | 对集合进行映射扁平化操作   |
| filter   | 过滤出指定的元素           |
| sorted   | 对集合元素进行默认排序     |
| sortBy   | 对集合按照指定字段排序     |
| sortWith | 对集合进行自定义排序       |
| groupBy  | 对集合元素按照指定条件分组 |
| reduce   | 对集合进行聚合计算         |
| fold     | 对集合元素进行折叠计算     |

### 7.1 示例一：遍历（foreach）

**格式**

```scala
def foreach(f:(A) => Unit): Unit

// 简写形式
def foreach(函数)
```

**说明	**

| foreach | API           | 说明                                                 |
| ------- | ------------- | ---------------------------------------------------- |
| 参数    | f:(A) => Unit | 接受一个函数对象，函数的参数为集合的元素，返回值为空 |
| 返回值  | Unit          | 表示foreach函数的返回值为：空                        |

**执行过程**

![image-20210317101050103](https://i.loli.net/2021/03/17/s4d7nMyO9tRXWuH.png)

```scala
package com.pineapple.demo07_function

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        /*
            函数的格式：
                (函数的参数列表) => {函数体}
         */
        list1.foreach((x: Int) => {
            println(x)
        })
        println("-" * 15)
        // 简写
        list1.foreach(x => println(x))
    }
}
```

```bash
$ scala ClassDemo01.scala
1
2
3
4
---------------
1
2
3
4
```

### 7.2 示例二：简化函数定义

- 方式一：通过`类型推断`来简化函数定义
- 方式二：使用`下划线`

```scala
package com.pineapple.demo07_function

object ClassDemo02 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        // 普通写法
        list1.foreach((x: Int) => {
            println(x)
        })
        println("-" * 15)
        // 类型推断
        list1.foreach(x => println(x))
        println("-" * 15)

        // 下划线
        // 如果函数参数只在函数体中出现一次，并且函数体没有涉及到复杂的使用（例如：嵌套），方可使用下划线
        list1.foreach(println(_))

    }
}
```

```bash
$ scala ClassDemo02.scala
1
2
3
4
---------------
1
2
3
4
---------------
1
2
3
4
```

### 7.3 实例三：映射（map）

集合的映射操作是`将一种数据类型转换为另外一种数据类型的过程`，它在数据计算的时候甚至将来在写Spark和Flink程序时用的最多的操作

> 例如：把List(Int)转换成List[String]

**格式**

```scala
def map[B](f:(A) => B): TraversableOnce[B]

// 简写形式
def map(函数对象)
```

**说明	**

| map方法 | API             | 说明                                                         |
| ------- | --------------- | ------------------------------------------------------------ |
| 泛型    | [B]             | 指定map方法最终返回的集合泛型，可省略                        |
| 参数    | f:(A) => B      | 函数对象，参数列表类型为A（要转换的列表元素），返回值为类型B |
| 返回值  | TraversableOnce | B类型的集合，可省略不写                                      |

**执行过程**

![image-20210317103603340](https://i.loli.net/2021/03/17/8rY6odsBKVfy7Oz.png)

```scala
package com.pineapple.demo07_function

object ClassDemo03 {

    def main(args: Array[String]): Unit = {
        val list1 = List(1, 2, 3, 4)
        // 普通方式
        val list2 = list1.map((x: Int) => {
            "*" * x
        })
        println(list2)

        // 类型推断
        val list3 = list1.map(x => "*" * x)
        println(list3)

        // 下划线
        val list4 = list1.map("*" * _)
        println(list4)
    }
}
```

```bash
$ scala ClassDemo03.scala
List(*, **, ***, ****)
List(*, **, ***, ****)
List(*, **, ***, ****)
```

### 7.4 示例四：扁平化映射（flatMap）

扁平化映射可以理解为先map，然后再flatten

![image-20210317104307389](https://i.loli.net/2021/03/17/GyHUOnEV59JBW2K.png)

> 解释：
>
> - map是将列表中的元素转换为一个List
> - flatten再将整个列表进行扁平化

**格式**

```scala
def flatMap[B](f:(A) => GenTraversableOnce[B]): TraversableOnce[B]

// 简写
def flatMap(f:(A) => 要将元素A转换成集合B的列表)
```

**说明	**

| flatMap方法 | API                            | 说明                                                         |
| ----------- | ------------------------------ | ------------------------------------------------------------ |
| 泛型        | [B]                            | 最终要返回的集合元素类型，可省略不写                         |
| 参数        | f:(A) => GenTraversableOnce[B] | 传入一个函数对象，函数的参数是集合的元素，函数的返回值的一个集合 |
| 返回值      | TraversableOnce[B]             | B类型的集合                                                  |

**示例**

```scala
package com.pineapple.demo07_function

object ClassDemo04 {

    def main(args: Array[String]): Unit = {
        val list1 = List("hadoop hive spark flink flume", "kudu hbase sqoop storm")
        // 获取文本行中的每一个单词，并将每一个单词都放到列表中
        // 方式一：先map，再flatten
        val list2 = list1.map((x: String) => {
            x.split(" ")
        })
        val list3 = list2.flatten
        println(list3)

        // 方式二：直接通过flatMap实现
        val list4 = list1.flatMap(_.split(" "))
        println(list4)
    }
}
```

```bash
$ scala ClassDemo04.scala
List(hadoop, hive, spark, flink, flume, kudu, hbase, sqoop, storm)
List(hadoop, hive, spark, flink, flume, kudu, hbase, sqoop, storm)
```

### 7.5 示例五：过滤(filter)

过滤筛选出符合一定条件的元素

**格式	**

```scala
def filter(f:(A) => Boolean): TraversableOnce[A]

// 简写形式
def filter(f:(A) => 筛选条件)
```

**说明	**

| filter方法 | API              | 说明                                                         |
| ---------- | ---------------- | ------------------------------------------------------------ |
| 参数       | f:(A) => Boolean | 传入一个函数对象，接受一个集合类型的函数，返回布尔类型，满足条件返回true，不满足返回false |
| 返回值     | TraversableOnce  | 符合条件的元素列表                                           |

**执行过程	**

![image-20210317111507811](https://i.loli.net/2021/03/17/DEzgdsTBnb2iXIG.png)

**示例	**

```scala
package com.pineapple.demo07_function

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 9).toList
        val list2 = list1.filter((x: Int) => {
            x % 2 == 0
        })
        println(list2)

        val list3 = list1.filter(_ % 2 == 0)
        println(list3)
    }
}
```

```bash
$ scala ClassDemo04.scala
List(2, 4, 6, 8)
List(2, 4, 6, 8)
```

### 7.6 示例六：排序

| 函数名   | 功能                 |
| -------- | -------------------- |
| sorted   | 对集合元素默认排序   |
| sortBy   | 按照指定字段进行排序 |
| sortWith | 对集合进行自定义排序 |

#### 7.6.1 默认排序

按照升序排列

```scala
package com.pineapple.demo07_function

object ClassDemo06 {

    def main(args: Array[String]): Unit = {
        val list1 = List(3, 9, 6, 1, 2, 5)

        println(list1.sorted)

        println(list1.sorted.reverse)
    }
}
```

```bash
$ scala ClassDemo06.scala
List(1, 2, 3, 5, 6, 9)
List(9, 6, 5, 3, 2, 1)
```

#### 7.6.2 指定字段排序

对列表元素根据传入后的函数转换后，再进行排序

**格式**

```scala
def sortBy[B](f:(A) => B): List[A]

// 简写模式
def sortBy(函数对象)
```

**说明**

| sortBy方法 | API        | 说明                                                         |
| ---------- | ---------- | ------------------------------------------------------------ |
| 泛型       | [B]        | 排序字段的数据类型                                           |
| 参数       | f:(A) => B | 传入函数对象，接受一个集合类型的元素参数，返回B类型的元素进行排序 |
| 返回值     | List[A]    | 返回排序后的了列表                                           |

```scala
package com.pineapple.demo07_function

object ClassDemo07 {

    def main(args: Array[String]): Unit = {
        val list1 = List("01 hadoop", "02 flume", "03 hive", "04 spark")
        val list2 = list1.sortBy(_.split(" ")(1))
        println(list2)
    }
}
```

```bash
$ scala ClassDemo07.scala
List(04 spark, 03 hive, 02 flume, 01 hadoop)
```

7.6.3 自定义排序（sortWith）

根据一个自定义的函数规则来排序

**格式	**

```scala
def sortWith(f:(A, A) => Boolean): List[A]

// 简写
def sortWith(函数对象：表示自定义的比较规则)
```

**说明	**

| sortWith方法 | API                 | 说明                                                         |
| ------------ | ------------------- | ------------------------------------------------------------ |
| 参数         | f:(A, A) => Boolean | 传入一个比较大小的函数对象，接受两个集合类型的元素参数，返回两个元素大小，小于返回true，大于返回false |
| 返回值       | List[A]             | 返回排序后的列表                                             |

**示例	**

```scala
package com.pineapple.demo07_function

object ClassDemo08 {

    def main(args: Array[String]): Unit = {
        val list1 = List(2, 3, 1, 6, 4, 5)
        // 降序
        val list2 = list1.sortWith((x, y) => {
            x > y
        })
        println(list2)

        // 精简版
        val list3 = list1.sortWith(_ > _)
        println(list3)
    }
}
```

```bash
$ scala ClassDemo08.scala
List(6, 5, 4, 3, 2, 1)
List(6, 5, 4, 3, 2, 1)
```

7.7 实例七：分组（groupBy）

将数据按照指定条件进行分组

**格式	**

```scala
def groupBy[K](f:(A) => k): Map[K, List[A]]

// 简写
def groupBy(f:(A) => 代码)
```

**说明	**

| groupBy方法 | API        | 说明                                                         |
| ----------- | ---------- | ------------------------------------------------------------ |
| 泛型        | [K]        | 分组字段的类型                                               |
| 参数        | f:(A) => k | 传入一个函数对象，接受集合元素类型的参数，按照k类型的key进行分组，相同的key放在一组，并返回结果 |
|             |            |                                                              |

**执行过程**

![image-20210317114020955](https://i.loli.net/2021/03/17/KvemChf1J6NcjxA.png)

示例：

```scala
package com.pineapple.demo07_function

object ClassDemo09 {

    def main(args: Array[String]): Unit = {
        val list1 = List("刘德华" -> "男", "刘亦菲" -> "女", "胡歌" -> "男")
        val map1 = list1.groupBy(x => x._2)
        println(map1)

        // 统计人数
        val map2 = map1.map(x => x._1 -> x._2.length)
        println(map2)
    }
}
```

```bash
$ scala ClassDemo09.scala
Map(男 -> List((刘德华,男), (胡歌,男)), 女 -> List((刘亦菲,女)))
Map(男 -> 2, 女 -> 1)
```

### 7.8 示例八：聚合操作

聚合是指将一个列表中的数据合并为一个

- reduce：对集合元素进行聚合计算
- fold：对集合元素进行折叠计算

#### 7.8.1 聚合（reduce）

**格式	**

```scala
def reduce[A1 >: A](op:(A1, A1) => A1): A1

// 简写
def reduce(op:(A1, A1) => A1)
```

**说明	**

| reduce | API               | 说明                                                         |
| ------ | ----------------- | ------------------------------------------------------------ |
| 泛型   | [A1 >: A]         | （下界）A1必须是聚合元素类型的父类，或者和集合相同类型       |
| 参数   | op:(A1, A1) => A1 | 传入函数对象，用来不断进行就和操作，第一个A1类型参数为：当前聚合后的变量，第二个A1类型参数为：当前要聚合的元素 |
| 返回值 | A1                | 列表最终聚合为一个元素                                       |

**执行过程	**

![image-20210317115505144](https://i.loli.net/2021/03/17/xaQzPdwbYrF2UfB.png)

```scala
package com.pineapple.demo07_function

object ClassDemo10 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 10).toList
        // 使用reduce计算所有元素的和
        val list2 = list1.reduce(_ - _)
        println(list2)

        val list3 = list1.reduceLeft(_ - _)
        println(list3)

        val list4 = list1.reduceRight(_ - _)
        println(list4)
    }
}
```

```bash
$ scala ClassDemo10.scala
-53
-53
-5
```

#### 7.8.2 折叠（fold）

fold和reduce很像，只不过多了一个指定初始值参数

**格式	**

```scala
def fold[A1 >: A](z: A1)(op:(A1, A1) => A1): A1

// 简写
def fold(初始值)(op:(A1, A1) => A1)
```

说明

![image-20210317120121349](https://i.loli.net/2021/03/17/2FGPAjgRQdsTaJh.png)

```scala
package com.pineapple.demo07_function

object ClassDemo11 {

    def main(args: Array[String]): Unit = {
        val list1 = (1 to 10).toList
        // 100: 表示初始化值
        // (x, y) => x + y 表示函数对象
        val list2 = list1.fold(100)((x, y) => x + y)
        println(list2)

        val list3 = list1.fold(100)(_ + _)
        println(list3)
    }
}
```

```bash
$ scala ClassDemo11.scala
155
155
```



## 8. 案例：学生成绩单

```scala
package com.pineapple.demo08_exercise

object ClassDemo01 {

    def main(args: Array[String]): Unit = {
        val student = List(("张三", 37, 90, 100), ("李四", 90, 73, 81), ("王五", 60, 90, 76), ("赵六", 59, 21, 72), ("田七", 100, 100, 100))
        // 获取语文分大于60
        val chineseList = student.filter(_._2 >= 60)
        println(chineseList)

        // 总成绩，x出现四次，不可用下划线优化
        val countList = student.map(x => x._1 -> (x._2 + x._3 + x._4))
        println(countList)

        // 总成绩排序
        val sortList = countList.sortWith((x, y) => x._2 > y._2)
        println(sortList)
    }
}
```

```bash
$ scala ClassDemo01.scala
List((李四,90,73,81), (王五,60,90,76), (田七,100,100,100))
List((张三,227), (李四,244), (王五,226), (赵六,152), (田七,300))
List((田七,300), (李四,244), (张三,227), (王五,226), (赵六,152))
```