# Scala第五章节

## 章节目标

1. 掌握方法的格式和用法
2. 掌握函数的格式和用法
3. 掌握九九乘法表案例

## 1. 方法

### 1.1 语法格式

```scala
def func(arg1:type1, arg2:type2) : [return type] = {
    // code
}
```

> 注意：
>
> - 参数列表的参数类型不能省略
> - 返回值类型可以省略，由Scala编译器自动推断
> - 返回值可以不写 return ，默认就是 {} 块表达式的值

### 1.2 示例

定义一个方法getMax获取两个数的最大值，并返回结果

```scala
object Demo {

  def getMax(a: Int, b: Int): Int = {
    return if (a >= b) a else b
  }

  def main(args: Array[String]) {
    val max = getMax(10, 20)
    println(max)
  }
}
```

```bash
$ scala Demo.scala 
20
```

简单写法

```scala
scala> def getMax(a:Int, b:Int) = if(a >= b) a else b
getMax: (a: Int, b: Int)Int

scala> val max = getMax(10, 20)
max: Int = 20

scala> println(max)
20
```

### 1.3 返回值类型推断

> 注意：定义递归方法，不能省略返回值类型

定义递归方法，求5的阶乘 n! = n * (n-1)!

```scala
scala> def factorial(n:Int) = if (n == 1) 1 else n * factorial(n - 1)
<console>:11: error: recursive method factorial needs result type
       def factorial(n:Int) = if (n == 1) 1 else n * factorial(n - 1)
                                                     ^

scala> def factorial(n: Int): Int = if (n == 1) 1 else n * factorial(n - 1)
factorial: (n: Int)Int

scala> val num = factorial(5)
num: Int = 120
```

### 1.4 惰性方法

当记录方法返回值的变量被声明位lazy时，方法的执行将被推迟，直到我们首次使用该值时，方法才会执行，像这样的方法，就叫：惰性方法。

> 注意：
>
> 1. Java 中并没有提供原生态的 “惰性” 技术，但是可以通过特定的代码结构实现，这种结构称之为：懒加载（也叫延迟加载）
> 2. lazy 不能修饰 var 类型的变量

**使用场景：**

- 打开数据库连接
  - 由于表达式执行代价昂贵，因此我们希望能推迟该操作，知道我们确实需要表达式结果值时才执行它
- 提升某些特定模块的启动时间
  - 为了缩短模块的启动时间，可以将当前不需要的某些工作推迟执行
- 确保对象中的某些字段能优先初始化
  - 为了确保对象中的某些字段能优先初始化，我们需要对其他字段进行惰性花处理

定义一个方法用来获取两个整数和，通过 “惰性” 技术调用该方法，然后打印结果

```scala
scala> def getSum(a: Int, b: Int) = a + b
getSum: (a: Int, b: Int)Int

scala> val sum1 = getSum(10, 20)
sum1: Int = 30

scala> lazy val sum2 = getSum(1, 2)
sum2: Int = <lazy>

scala> println(sum2)
3  
```

### 1.5 方法参数

- 默认参数
- 带名参数
- 边长参数

#### 1.5.1 默认参数

```scala
scala> def getSum(a: Int = 10, b: Int = 20) = a + b
getSum: (a: Int, b: Int)Int

scala> getSum()
res2: Int = 30

scala> getSum(1, 2)
res3: Int = 3

scala> getSum(1, 20)
res4: Int = 21

scala> getSum(1)
res5: Int = 21
```

#### 1.5.2 带名参数

```scala
scala> getSum(a = 1)
res6: Int = 21

scala> getSum(b = 1)
res7: Int = 11
```

#### 1.5.3 边长参数

如果方法的参数是不固定的，可以将该方法的参数定义成边长参数

**语法格式：**

```scala
def funcName(arg: argType*) : returnType = {
    // code
}
```

> 注意：
>
> 1. 在参数类型后面加上一个 `*` 号，表示参数可以是0个或者多个
> 2. 一个方法有且只能有一个边长参数，并且边长参数要放到参数列表的最后边

```scala
scala> def getSum(numbers: Int*) = numbers.sum
getSum: (numbers: Int*)Int

scala> val sum1 = getSum()
sum1: Int = 0

scala> val sum2 = getSum(1, 2, 3, 4, 5)
sum2: Int = 15
```

### 1.6 方法调用方式

- 后缀
- 中缀
- 花括号
- 无括号

> 注意：在编写Spark、Flink程序时，会经常使用到这些方法的调用方式。

#### 1.6.1 后缀调用法

和Java一样

```scala
objectName.funcName(arg)
```

使用 Math.abs() 求绝对值

```scala
scala> Math.abs(-10)
res8: Int = 10
```

#### 1.6.2 中缀调用法

```scala
objectName funcName arg
```

例如： `1 to 10`

```scala
scala> Math abs 20
res9: Int = 20

scala> Math abs (-20)
res11: Int = 20
```

**拓展：操作符即方法**

在Scala中，+ - * / 这些不仅是操作符，也是方法，当执行 `1 + 1`时，就是使用了中缀调用法，调用了 + 方法

#### 1.6.3 花括号调用法

```scala
Math.abs {
    // 表达式1
    // 表达式2
}
```

> 注意：方法只有一个参数，才能使用花括号调用法

```scala
scala> Math.abs {
     |   println("求绝对值了！")
     |   -40
     | }
求绝对值了！
res14: Int = 40
```

#### 1.6.4 无括号调用法

当方法无参数，且没有返回值，即返回值类型为Unit时，可以这样用：

```scala
scala> def sayHello() = println("Hello, Scala")
sayHello: ()Unit

scala> sayHello()
Hello, Scala

scala> sayHello
Hello, Scala
```

> 注意：
>
> 1. 在Scala中，如果方法的返回值类型是Unit类型，这样的方法称之为`过程`(procedure)
>
> 2. 过程的等号(=) 可以省略不不写
>
>    ```scala
>    scala> def sayHello() { println("Hello, Scala") }
>    sayHello: ()Unit
>    
>    scala> sayHello
>    Hello, Scala
>    ```



## 2. 函数

### 2.1 定义函数

```scala
val funcName = (arg1: argType1, arg2: argType2...) => 函数体
```

> 注意：
>
> - 在Scala中，函数是一个`对象`（变量）
> - 类似于方法，函数也是有参数列表和返回值
> - 函数定义不需要使用`def` 定义
> - 无需制定返回值类型

```scala
scala> val getSum = (a:Int, b:Int) => a + b
getSum: (Int, Int) => Int = <function2>

scala> val sum = getSum(11, 22)
sum: Int = 33
```

### 2.2 方法和函数的区别

在Java中，方法和函数之间没有任何区别，只是叫法不同。但是在Scala中，是有区别的：

- 方法是隶属于类或者对象的，在运行时，它是加载到 JVM 的方法区中

- 可以将函数对象赋值给一个变量，在运行时，它是加载到 JVM 的堆内存中

- 函数是一个对象，继承自FunctionN，对象有apply，curried，toString，tupled这些方法

  > 结论：在Scala中，函数是对象，而方法是属于对象的，所以可以理解为：`方法归属于函数`

```scala
scala> val getSum = (a: Int, b: Int) => a + b
getSum: (Int, Int) => Int = <function2>

scala> def add(a: Int, b: Int) = a+ b
add: (a: Int, b: Int)Int

scala> val a = add
<console>:12: error: missing argument list for method add
Unapplied methods are only converted to functions when a function type is expected.
You can make this conversion explicit by writing `add _` or `add(_,_)` instead of `add`.
       val a = add
               ^
```

### 2.3 方法转换成函数

有时候需要将方法转换为函数。例如：作为变量传递，就需要将方法转换成函数

```scala
val 变量名 = 方法名 _
```

```scala
scala> val a = add _
a: (Int, Int) => Int = <function2>

scala> val sum = a(10, 20)
sum: Int = 30
```



## 3. 案例：打印nn乘法表

```scala
// 方法
scala> def printMT(n: Int) = {
     |   for(i <- 1 to n; j <- 1 to i) {
     |     print(s"${j} * ${i} = ${i * j}\t")
     |     if(i == j) println()
     |   }
     | }
printMT: (n: Int)Unit

scala> import scala.io.StdIn
import scala.io.StdIn

scala> val num = StdIn.readInt
num: Int = 5

scala> printMT(num)
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25

scala> printMT(9)
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25	
1 * 6 = 6	2 * 6 = 12	3 * 6 = 18	4 * 6 = 24	5 * 6 = 30	6 * 6 = 36	
1 * 7 = 7	2 * 7 = 14	3 * 7 = 21	4 * 7 = 28	5 * 7 = 35	6 * 7 = 42	7 * 7 = 49	
1 * 8 = 8	2 * 8 = 16	3 * 8 = 24	4 * 8 = 32	5 * 8 = 40	6 * 8 = 48	7 * 8 = 56	8 * 8 = 64	
1 * 9 = 9	2 * 9 = 18	3 * 9 = 27	4 * 9 = 36	5 * 9 = 45	6 * 9 = 54	7 * 9 = 63	8 * 9 = 72	9 * 9 = 81

// 一行版
scala> def printMT(n: Int) = for(i <- 1 to n; j <- 1 to i) print(s"${j} * ${i} = ${i * j}" + (if(i == j) "\r\n" else "\t"))
printMT: (n: Int)Unit

scala> printMT(3)
1 * 1 = 1
1 * 2 = 2	2 * 2 = 4
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9

// 函数
scala> val printMT = (n: Int) => {
     |   for(i <- 1 to n; j <- 1 to i) {
     |     print(s"${j} * ${i} = ${i * j}\t")
     |     if(i == j) println()
     |   }
     | }
printMT: Int => Unit = <function1>

scala> printMT(4)
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	

scala> printMT(5)
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25	

// 一行版
scala> val printMT = (n: Int) => for(i <- 1 to n; j <- 1 to i) print(s"${j} * ${i} = ${i * j}" + (if(i == j) "\r\n" else "\t"))
printMT: Int => Unit = <function1>

scala> printMT(4)
1 * 1 = 1
1 * 2 = 2	2 * 2 = 4
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16

scala> printMT(5)
1 * 1 = 1
1 * 2 = 2	2 * 2 = 4
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25
```









