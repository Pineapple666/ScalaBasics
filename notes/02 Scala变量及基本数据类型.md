# Scala变量及基本数据类型

## 章节目标

1.  掌握变量，字符串的定义和使用
2.  掌握数据类型的划分和数据类型转换的内容
3.  掌握键盘录入功能
4.  理解Scala中的常量，标识符相关内容



## 1. 输出语句和分号

### 1.1 输出语句

#### 方式一：换行输出

```scala
println("内容")
```

#### 方式二：不换行输出

```scala
print("内容")
```

注意：`不管是print1n()，还是print()语句，都可以同时打印多个值.格式为: print1n(值1，值2，值3...)`

### 1.2 分号

​		Scala语句中，单行代码最后的分号可写可不写。如果是多行代码写在一行，则中间的分号不能省略，最后一条代码的分号可省略不写。

实例：

```scala
println("He11o，scala! ")   			//最后的分号可写可不写
println("He11o"); print1n("scala")  //如果多行代码写在一行，则前边语句的分号必须写，最后一条语句的分号可以省略不写.
```

```scala
scala> print("Hello World!")
Hello World!
scala> print("Hello World!");
Hello World!
scala> println("Hello World!")
Hello World!

scala> println("Hello World!");
Hello World!

scala> println(1, 2, "Hello", "Scala")
(1,2,Hello,Scala)

scala> println("Hello"); println("World!"); println("scala")
Hello
World!
scala

scala> println("Hello") println("World!") println("scala")
                        ^
       error: value println is not a member of Unit
```



## 2. Scala的常量

### 2.1 概述

​		常量指的是：在程序的运行过程中，其值不能发生改变的量。

### 2.2 分类

-   字面值常量（常用的有以下几种）
    -   整型常量
    -   浮点型常量
    -   字符型常量
    -   字符串常量
    -   布尔常量
    -   空常量
-   自定义常量（稍后解释）

### 2.3 代码演示

```scala
scala> println(10, 20, 30)    // 整型常量
(10,20,30)

scala> println(10.3, 2.1)     // 浮点型常量
(10.3,2.1)

scala> println('a')           // 字符常量
a

scala> println("abc")         // 字符串常量
abc

scala> println(true, false)   // 布尔常量
(true,false)

scala> println(null)          // 空常量
null
```



## 3. Scala中的变量

### 3.1 概述

​		我们将来每一天编写scala程序都会定义变量,那什么是变量，它又是如何定义的呢？

​		变量，指的就是在程序的执行过程中，其值可以发生改变的量.定义格式如下：

### 3.2 语法格式

Java变量定义

```scala
int i = 0
```

在scala中，可以使用`val`或者`var`来定义变量，语法格式如下：

```scala
val/var i:Int = 0
```

其中

-   val定义的是不可重新赋值的变量，也是自定义变量
-   var定义的是可重新赋值的变量

注意：`scala中定义变量时，类型卸载变量名后面`

### 3.3 实例

**需求：**定义一个变量保存一个人的名字 "tom"

```scala
scala> val name:String = "tom"
val name: String = tom

scala> name = "jim"
            ^
       error: reassignment to val

scala> var name:String = "tom"
var name: String = tom

scala> name = "jim"
// mutated name

scala> name
val res16: String = jim
```

注意：优先使用`val`定义变量，如果变量需要被重新赋值，才使用var

### 3.5 使用类型推断来定义变量

scala的语法要比Java简洁，我们可以使用一种更简洁的方式来定义变量。

#### 示例

使用更简洁的语法定义一个变量保存一个人的名字 "tom"

#### 参考代码

```scala
scala> val name = "tom"
val name: String = tom

scala> val age = 23
val age: Int = 23
```

scala可以自动根据变量的值来自动推断变量的类型，这样编写代码更加简洁。



## 4. 字符串

scala提供多种定义字符串的方式，将来我们可以根据需要来选择最方便的定义方式。

-   使用双引号
-   使用插值表达式
-   使用三引号

### 4.1 使用双引号

语法

```scala
val/var 变量名 = "字符串"
```

#### 示例

有一个人的名字叫 "hadoop"，请打印他的名字及名字长度。

#### 参考代码

```scala
scala> val name = "hadoop"
val name: String = hadoop

scala> println(name, name.length)
(hadoop,6)
```

### 4.2 使用从插值表达式

scala中，可以使用插值表达式来定义字符串，有效避免大量字符串的拼接。

语法

```scala
val/var 变量名 = s"${变量/表达式}字符串"
```

>   注意：
>
>   -   在定义字符串前添加`s`
>   -   在字符串中，可以使用`${}`来引用变量或者编写表达式

#### 示例

请定义若干个变量，分别保存："zhangsan"、23、"male"，定义一个字符串，保存这些信息。

打印输出: name=zhangsan, age=23，sex=male

#### 参考代码

```scala
scala> val name = "zhangsan"
val name: String = zhangsan

scala> val age = 23
val age: Int = 23

scala> val sex = "male"
val sex: String = male

scala> val result1 = "name=" + name + ", age=" + age + ", sex=" + sex
val result1: String = name=zhangsan, age=23, sex=male

scala> val result2 = s"name=${name}, age=${age}, sex=${sex}"
val result2: String = name=zhangsan, age=23, sex=male
```

### 4.3 使用三引号

如果有大段的文本需要保存，就可以使用三引号来定义字符串。例如:保存一大段的SQL语句。三个引号中间的所有内容都将作为字符串的值。T

语法

```scala
val/var 变量名 = """字符串1
"""
```

#### 示例

定义一个字符串，保存一下SQL语句

```mysql
select
	*
from
	t_user
where
	name = "zhangsan"
```

打印该SQL语句

#### 参考代码

```scala
scala> val sql = """
     | select
     |   *
     | from
     |   user
     | where
     |   name = "zhangsan"
     | """
val sql: String =
"
select
  *
from
  t_user
where
  name = "zhangsan"
"
```

### 4.4 扩展：惰性赋值

在企业的大数据开发中，有时候会编写非常复杂的SQL语句，这些SQL语句可能有几百行甚至上千行。这些SQL语句，如果直接加载到JVM中，会有很大的内存开销,如何解决这个问题呢?
当有一些变量保存的数据较大时，而这些数据又不需要马上加载到JVM内存中。就可以使用`惰性赋值`来提高效率。

语法

```scala
lazy val/var 变量名 = 表达式
```

#### 示例

在程序中需要执行—条以下复杂的SQL语句，我们希望只有用到这个SQL语句才加载它。

```scala
"""insert overwrite table adm.itcast_adm_personas
select
a. user_id，aluser_name,a.user _sex,
a.user_birthday ,a.user _age,
a.conste1lation,a.province,
a.city，
a.city_leve1,a.hex_mail,a.op_mail，a.hex_phone,a.fore_phone,a.figure_mode1,a.stature_mode1,b.first_order _time,b.1ast_or der _time,
d . month1_hour025_cnt,d .month1_hour627_cnt,d .month1_hour829_cnt,d .month1_hour10212_cnt,d .month1_hour13214_cnt,d.month1_hour 15217_cnt ,d.month1_hour18219_cnt,

```

```scala
scala> lazy val sql = """
     | insert overwrite table adm.itcast_adm_personas
     | select
     | a. user_id，aluser_name,a.user _sex,
     | a.user_birthday ,a.user _age,
     | a.conste1lation,a.province,
     | a.city，
     | a.city_leve1,a.hex_mail,a.op_mail，a.hex_phone,a.fore_phone,a.figure_mode1,a.stature_mode1,b.first_order _time,b.1ast_or der _time,
     | d . month1_hour025_cnt,d .month1_hour627_cnt,d .month1_hour829_cnt,d .month1_hour10212_cnt,d .month1_hour13214_cnt,d.month1_hour 15217_cnt ,d.month1_hour18219_cnt,
     | """
lazy val sql: String // unevaluated

scala> println(sql)

insert overwrite table adm.itcast_adm_personas
select
a. user_id，aluser_name,a.user _sex,
a.user_birthday ,a.user _age,
a.conste1lation,a.province,
a.city，
a.city_leve1,a.hex_mail,a.op_mail，a.hex_phone,a.fore_phone,a.figure_mode1,a.stature_mode1,b.first_order _time,b.1ast_or der _time,
d . month1_hour025_cnt,d .month1_hour627_cnt,d .month1_hour829_cnt,d .month1_hour10212_cnt,d .month1_hour13214_cnt,d.month1_hour 15217_cnt ,d.month1_hour18219_cnt,
```



## 5. 标识符

### 5.1 概述

​		实际开发中，我们会编写大量的代码，这些代码中肯定会有变量，方法，类等。那它们该如何命名呢？这就需要用到标识符了。标识符就是用来给变量，方法，类等起名字的。Scala中的标识符和ava中的标识符非常相似。

### 5.2 命名规则

-   必须由`大小写英文字母，数字，下划线_，美元符$`，这四部分任意组成。
-   数字不能开头
-   不能和Scala中的关键字重名
-   最好做到`见名知意`

### 5.3 命名规范

-   变量或方法：从第二个单词开始，每个单词的首字母都大写，其他字母全部小写（小驼峰命名法）。

    ```
    zhangSanAge, Student_Country, getSum
    ```

-   类或特质(Trait)：每个单词的首字母都大写，其他所有字母全部小写（大驼峰命名法）

    ```
    Person, StudentDemo, OrderItems
    ```

-   包：全部小写，一般是公司的域名反写，多级包之间用 . 隔开

    ```
    com.itheima.add, cn.itcast.update
    ```

    

## 6. 数据类型

### 6.1 简述

数据类型是用来约束变量（常量）的取值范围的。Scala也是一门强类型语言，它里边的数据类型绝大多数和ava一样。

我们主要来学习

-   与Java不一样的一些用法
-   Scala中数据类型的继承体系

### 6.2 数据类型

| 基础类型 | 类型说明                 |
| :------- | ------------------------ |
| Byte     | 8位带符号整数            |
| Short    | 16位带符号整数           |
| Int      | 32位带符号整数           |
| Long     | 64位带符号整数           |
| Char     | 16位无符号Unicode字符    |
| String   | Char类型的序列（字符串） |
| Float    | 32位单精度浮点数         |
| Double   | 64位双精度浮点数         |
| Boolen   | true或false              |

>   注意下 Scala和Java的区别
>
>   1.  Scala中所有的类型都使用大写字母开头
>   2.  整型使用`Int`而不是Integer
>   3.  Scala中定义变量可以不写类型，让Scala编译器自动推断
>   4.  Scala中默认的整型是Int，默认的浮点型是：Double

### 6.3 Scala类型层次结构

![image-20210302151931916](C:\Users\18368\AppData\Roaming\Typora\typora-user-images\image-20210302151931916.png)

### 6.4 思考题

一下代码是否有问题？

```scala
val b:Int = null
```

`Scala会解释报错`：Null类型并不能转换为Int类型，说明`Null类型并不是Int类型的子类`



## 7. 类型转换

### 7.1 概述

​		当Scala程序在进行运算或者赋值动作时，范围小的数据类型值会自动转换为范围大的数据类型值，然后再进行计算。例如：1+1.1的运算结果就是一个Double类型的2.1。而有些时候，我们会涉及到一些类似于"四舍五入"的动作，要把一个小数转换成整数再来计算。这些内容就是Scala中的类型转换。

>   Scala中的类型转换分为`值类型的类型转换`和`引用类型的类型转换`，这里我们首先介绍：`值类型的类型转换`
>
>   值类型的类型转换分为：
>
>   -   自动类型转换
>   -   强制类型转换

7.2 自动类型转换

1.  解释

    范围小的数据类型值会自动转换为范围大的数据类型值，这个动作就叫:自动类型转换。
    自动类型转换从小到大分别为：Byte，Short，Char -> Int -> Long -> Float -> Double

2.  示例代码

    ```scala
    scala> val a:Int = 3
    val a: Int = 3
    
    scala> val b:Double = a + 2.21
    val b: Double = 5.21
    
    scala> val c:Int = a + 2.21
                       ^
           error: type mismatch;
            found   : a.type (with underlying type Int)
            required: ?{def +(x$1: ? >: Double(2.21)): ?}
           Note that implicit conversions are not applicable because they are ambiguous:
            both method int2float in object Int of type (x: Int): Float
            and method int2long in object Int of type (x: Int): Long
            are possible conversion functions from a.type to ?{def +(x$1: ? >: Double(2.21)): ?}
                         ^
           error: overloaded method + with alternatives:
             (x: Int)Int <and>
             (x: Char)Int <and>
             (x: Short)Int <and>
             (x: Byte)Int
            cannot be applied to (Double)
    ```

### 7.3 强制类型转换

1.  解释

    范围大的数据类型值通过一定的格式（强制转换函数）可以将其转换成范围小的数据类型值，这个动作就叫：强制类型转换。

    >   注意：使用强制类型转换的时候可能会造成`精度缺失`问题! 

2.  格式

    ```scala
    val/var 变量名:数据类型 = 具体的值.toXxx		// Xxx表示你想要转换到的数据类型
    ```

3.  参考代码

    ```scala
    scala> val c:Int = (a + 2.21).toInt
    val c: Int = 5
    ```

### 7.4 值类型和String类型之间的相互转换

#### 1. 值类型的数据转换成String类型

**格式一：**

```scala
val/var 变量名:String = 值类型数据 + ""
```

**格式二:**

```scala
val/var 变量名:String = 值类型数据.toString
```

**格式三：`（Scala2.13.0新增）原有的格式一被废弃`**

```scala
val/var 变量名:String = s"$num$str"
```

**示例**

将Int，Double，Boolean类型的数据转换成其对应的字符串形式。

**参考代码：**

```scala
scala> val a = 10
val a: Int = 10

scala> val b = a + ""
                 ^
       warning: method + in class Int is deprecated (since 2.13.0): Adding a number and a String is deprecated. Use the string interpolation `s"$num$str"`
val b: String = 10

scala> val b = s"$a"
val b: String = 10

scala> val c = a.toString
val c: String = 10

scala> println(a+10, b+10, c+10)
(20,1010,1010)
```

#### 2. String类型的数据转换成其对应的值类型

**格式：**

```scala
val/var 变量名:值类型 = 字符串值.toXxx	// Xxx表示你要转换到的数据类型
```

>   注意：
>
>   -   String类型的数据转换成Char类型的数据，方式有点特殊，并不是调用toChar，而是`toCharArray`
>   -   这点目前先了解即可，后续我们详细讲解

**需求：**

​		将字符串类型的整数，浮点数，布尔数据转换成其对应的值类型数据。

**参考代码：**

```scala
scala> val s1 = "123"
val s1: String = 123

scala> val s2 = "12.3"
val s2: String = 12.3

scala> val s3 = "false"
val s3: String = false

scala> val a = s1.toInt
val a: Int = 123

scala> val b = s2.toDouble
val b: Double = 12.3

scala> val c = s3.toBoolean
val c: Boolean = false
```



## 8. 键盘录入

### 8.1 概述

​		前边我们涉及到的数据，都是我们写"死""的，固定的数据，这样做用户体验并不是特别好。那如果这些数据是由用户录入，然后我们通过代码接收，就非常好玩儿了。这就是接下来我们要学习的Scala中的"键盘录入"功能

### 8.2 使用步骤

1.  导包

    >   格式：import scala.io.StdIn

2.  通过`StdIn.readXxx()`来接受用户键盘录入的数据

    >   接收字符串数据：StdIn.readLine()
    >
    >   接收整数数据：StdIn.readInt()

### 8.3 示例

```scala
scala> import scala.io.StdIn
import scala.io.StdIn

scala> println("请录入一个字符串：")
请录入一个字符串：

scala> val str = StdIn.readLine()
val str: String = Hello, Scala!

scala> println("您录入的数据是：" + str)
您录入的数据是：Hello, Scala!

scala> println("请录入一个整数：")
请录入一个整数：

scala> println("您录入的整数是：" + StdIn.readInt())
您录入的整数是：100
```



## 9. 案例：打招呼

### 9.1 概述

需求：提示用户录入他/她的姓名和年龄，接收并打印

### 9.2 具体步骤

1.  提示用户录入姓名
2.  接收用用户录入的姓名
3.  提示用户录入年龄
4.  接收用户录入年龄
5.  将用户录入的数据（姓名和年龄）打印在控制台上

9.3 参考代码

```scala
scala> import scala.io.StdIn
import scala.io.StdIn

scala> println("请录入您的姓名：")
请录入您的姓名：

scala> val name = StdIn.readLine()
val name: String = zhangsan

scala> println("请录入您的年龄：")
请录入您的年龄：

scala> val age = StdIn.readInt()
val age: Int = 20

scala> println(s"大家好，我叫${name}，我今年${age}岁了，很高兴与大家一起学习Scala")
大家好，我叫zhangsan，我今年20岁了，很高兴与大家一起学习Scala
```







































