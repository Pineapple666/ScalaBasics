# Scala流程控制

## 章节目标

1. 掌握分支结构的格式和用法
2. 掌握for循环和while循环的格式和用法
3. 掌握控制跳转语句的用法
4. 掌握循环案例
5. 理解do.while循环的格式和用法

## 1. 流程控制结构

### 1.1 概述

流程控制可以合理的规划代码，避免代码重复执行，错误判断等。

### 1.2 分类

- 顺序结构

- 分支结构

- 选择结构

  > 注意：Scala和Java的流程控制结构是基本一致的



## 2. 顺序结构

### 2.1 概述

顺序结构是指：程序是按照从上至下，从左至右的顺序，依次逐行执行的，中间没有任何判断和跳转。

如图：

![image-20210309145327054](https://i.loli.net/2021/03/12/zl8icIkKjYq9hJX.png)

> 注意：顺序结构是Scala的默认流程控制结构

### 2.2 代码演示

```scala
scala> println("start");println("hello");println("scala");println("end")
start
hello
scala
end

scala> println(10 + 10 + "hello" + 10 + 10)
20hello1010
```



## 3.选择结构(if语句)

### 3.1 概述

选择结构是指：某些代码的执行需要依赖于特定的判断条件，如果判断条件成立，则代码执行，否则，代码不执行。

### 3.2 分类

- 单分支
- 双分支
- 多分支

### 3.3 单分支

只有一个判断条件的 if 语句

#### 3.3.1 格式

```scala
if(关系表达式) {
    // code
}
```

> 注意：关系表达式不管多么复杂，结果一定是Boolean类型

#### 3.3.2 执行流程

![image-20210309150311220](https://i.loli.net/2021/03/12/sfAH4I6mSxyYaoU.png)

#### 3.3.3 示例

**需求：**

​		定义一个变量记录学生的成绩，如果成绩大于等于60分，则打印：分数及格

**参考代码：**

```scala
scala> val score = 60
score: Int = 60

scala> if(score >= 60) {
     |   println("成绩及格")
     | }
成绩及格
```

### 3.4 双分支

```scala
scala> val score = 61
score: Int = 61

scala> if(score >= 60) {
     |     println("成绩及格！！！")
     | } else {
     |     println("成绩不及格！！！")
     | }
成绩及格！！！
```

### 3.5 多分支

![image-20210309151422445](https://i.loli.net/2021/03/12/9wHPcJZAbfGtQLB.png)

```scala
scala> val score = 91
score: Int = 91

scala> if(score >= 90 && score <= 100) {
     |     println("奖励VR设备一套")
     | } else if(score >= 80 && score < 90) {
     |     println("奖励考试卷一套")
     | } else if(score >= 0 && score < 80) {
     |     println("奖励组合拳一套")
     | } else {
     |     println("滚蛋回家！！！")
     | }
奖励VR设备一套

scala> val score = 81
score: Int = 81

scala> if(score >= 90 && score <= 100) {
     |      |     println("奖励VR设备一套")
     |      | } else if(score >= 80 && score < 90) {
     |      |     println("奖励考试卷一套")
     |      | } else if(score >= 0 && score < 80) {
     |      |     println("奖励组合拳一套")
     |      | } else {
     |      |     println("滚蛋回家！！！")
     |      | }
奖励考试卷一套
```

### 3.6 注意事项

- 和Java一样，大括号 {} 内的逻辑代码只有一行，大括号可以省略
- 在scala中，条件表达式也是有返回值的
- 在scala中，没有三元表达式，可以使用if表达式代替三元表达式

```scala
scala> val sex = "male"
sex: String = male

scala> val result = if(sex == "male") 1 else 0
result: Int = 1

scala> println(result)
1
```

### 3.7 嵌套分支

```scala
scala> val a = 10
a: Int = 10

scala> val b = 20
b: Int = 20

scala> val c = 30
c: Int = 30

scala> var max = 0
max: Int = 0

scala> if(a >= b) {
     |     max = if(a >= c) a else c
     | } else {
     |     max = if(b >= c) b else c
     | }

scala> max
res12: Int = 30
```

### 3.8 拓展：块表达式

- Scala中，使用 {} 表示一个块表达式
- 和 if 表达式一样，块表达式也是有值的
- 值就是最后一个表达式的值

```scala
scala> val a = {
     |     println("1 + 1")
     |     1 + 1
     | }
1 + 1
a: Int = 2

scala> println(a)
2
```



## 4. 循环结构

### 4.1 分类

- for
- while
- do.while

### 4.2 for循环

#### 4.2.1 简单循环

```scala
scala> val nums = 1 to 10
nums: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

scala> for(i <- nums) {
     | println("hello scala" + i)
     | }
hello scala1
hello scala2
hello scala3
hello scala4
hello scala5
hello scala6
hello scala7
hello scala8
hello scala9
hello scala10

scala> for(i <- 1 to 10) {println("hello scala" + i)}
hello scala1
hello scala2
hello scala3
hello scala4
hello scala5
hello scala6
hello scala7
hello scala8
hello scala9
hello scala10
```

#### 4.2.2 嵌套循环

```scala
scala> for(i <- 1 to 3) {    // 外循环，控制行数
     |     for(j <- 1 to 5) {    // 内循环，控制列数
     |         print("*")
     |     }
     |     println()
     | }
*****
*****
*****

scala> for(i <- 1 to 3) {
     |     for(j <- 1 to 5) if(j == 5) println("*") else print("*")
     | }
*****
*****
*****

scala> for(i <- 1 to 3; j <- 1 to 5) if(j == 5) println("*") else print("*")
*****
*****
*****
```

#### 4.2.4 守卫

for表达式中，可以添加 if 判断语句，这个 if 判断就称之为守卫。守卫可以让for表达式更加简洁。

**语法**

```scala
for(i <- 表达式/数组/集合 if 表达式) {
    // code
}
```

**示例**

使用 for 表达式打印 1-10 之间能够整除3的数字

**参考代码**

```scala
scala> for(i <- 1 to 10) {
     |     if(i % 3 == 0) println(i)
     | }
3
6
9

scala> for(i <- 1 to 10 if i %3 == 0) println(i)
3
6
9
```

#### 4.2.5 for推导式

Scala中的 for 也是有返回值的，在for循环中，可以用 `yield` 表达式构建出一个集合，我们把使用 yield 的for表达式成为推导式

生成一个集合 10, 20, 30 , ..., 100

```scala
scala> val nums = for(i <- 1 to 10) yield i * 10
nums: scala.collection.immutable.IndexedSeq[Int] = Vector(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

scala> println(nums)
Vector(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
```

### 4.3 while循环

```scala
scala> var i = 1
i: Int = 1

scala> while(i <= 10) {
     |    println(i)
     |    i += 1
     | }
1
2
3
4
5
6
7
8
9
10
```

### 4.4 do.while循环

> 注意：
>
> 1. do.while循环不管判断条件是否成立，循环体都会执行一次
> 2. for循环，while循环都是如果判断条件不成立，则循环体不执行

```scala
scala> var i = 1
i: Int = 1

scala> do {
     |     println(i)
     |     i += 1
     | } while(i <= 10)
1
2
3
4
5
6
7
8
9
10
```

### 4.5 break和continue

- 在Scala中，类似Java和C++的break和continue关键字被移除了
- 如果一定使用break和continue，就需要使用 `scala.util.control` 包下的breakable和break方法

#### 4.5.1 实现break

1. 导包：`import scala.util.control.Breaks._`
2. 使用 breakable 将 for表达式包起来
3. for表达式中需要退出循环的地方，添加 break() 方法调用

```scala
import scala.util.control.Breaks._

object Demo {
    def main(args: Array[String]){
        breakable(
            for (i <- 1 to 10) 
                if(i == 5) break() else println(i)
        )
    }
}
```

```bash
$ scala Demo.scala 
1
2
3
4
```

#### 4.5.2 实现continue

continue的实现与break类似，但有一点不同：

> 注意：
>
> 1. 实现break是用breakable{}将整个表达式包起来
> 2. 而实现continue是用breakable{}将for表达式的循环体包起来就可以了

```scala
import scala.util.control.Breaks._

object Demo {
    def main(args: Array[String]){
        for(i <- 1 to 10) {
            breakable {
                if(i % 3 == 0) break() else println(i)
            }
        }
    }
}
```

```bash
$ scala Demo.scala 
1
2
4
5
7
8
10
```



## 5. 综合案例

### 5.1 九九乘法表

```scala
scala> for(i <- 1 to 9) {
     |     for(j <- 1 to i) {
     |         print(s"${j} * ${i} = ${i * j}\t")
     |     }
     |     println()
     | }
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25	
1 * 6 = 6	2 * 6 = 12	3 * 6 = 18	4 * 6 = 24	5 * 6 = 30	6 * 6 = 36	
1 * 7 = 7	2 * 7 = 14	3 * 7 = 21	4 * 7 = 28	5 * 7 = 35	6 * 7 = 42	7 * 7 = 49	
1 * 8 = 8	2 * 8 = 16	3 * 8 = 24	4 * 8 = 32	5 * 8 = 40	6 * 8 = 48	7 * 8 = 56	8 * 8 = 64	
1 * 9 = 9	2 * 9 = 18	3 * 9 = 27	4 * 9 = 36	5 * 9 = 45	6 * 9 = 54	7 * 9 = 63	8 * 9 = 72	9 * 9 = 81	

scala> for(i <- 1 to 9; j <- 1 to i) {
     |     print(s"${j} * ${i} = ${i * j}\t")
     |     if(i == j) println()
     | }
1 * 1 = 1	
1 * 2 = 2	2 * 2 = 4	
1 * 3 = 3	2 * 3 = 6	3 * 3 = 9	
1 * 4 = 4	2 * 4 = 8	3 * 4 = 12	4 * 4 = 16	
1 * 5 = 5	2 * 5 = 10	3 * 5 = 15	4 * 5 = 20	5 * 5 = 25	
1 * 6 = 6	2 * 6 = 12	3 * 6 = 18	4 * 6 = 24	5 * 6 = 30	6 * 6 = 36	
1 * 7 = 7	2 * 7 = 14	3 * 7 = 21	4 * 7 = 28	5 * 7 = 35	6 * 7 = 42	7 * 7 = 49	
1 * 8 = 8	2 * 8 = 16	3 * 8 = 24	4 * 8 = 32	5 * 8 = 40	6 * 8 = 48	7 * 8 = 56	8 * 8 = 64	
1 * 9 = 9	2 * 9 = 18	3 * 9 = 27	4 * 9 = 36	5 * 9 = 45	6 * 9 = 54	7 * 9 = 63	8 * 9 = 72	9 * 9 = 81
```

### 5.2 模拟登录

```scala
import scala.io.StdIn
import scala.util.control.Breaks._

object Demo {

    var uname = ""
    var pw = ""


    def main(args: Array[String]){
        breakable(
            for (i <- 1 to 3) {
                println("请输入您的账号：")
                uname = StdIn.readLine()
                println("请录入您的密码：")
                pw = StdIn.readLine()
                if (uname == "itcast" && pw == "heima"){
                    println("登录成功，开始学习Scala")
                    break()
                } else {
                    if (i == 3) println("您的账号已经被锁定，请与管理员联系")
                    else println("用户名或者密码错误，请重新录入，您还有" + (3 - i) + "次机会")
                }
            }
        )
    }
}
```

```bash
$ scala Demo.scala 
请输入您的账号：
haha
请录入您的密码：
aa
用户名或者密码错误，请重新录入，您还有2次机会
请输入您的账号：
aa
请录入您的密码：
hah
用户名或者密码错误，请重新录入，您还有1次机会
请输入您的账号：
itcast
请录入您的密码：
heima
登录成功，开始学习Scala
```













