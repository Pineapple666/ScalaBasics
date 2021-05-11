# Scala 第八章



## 章节目标

- 能够使用trait独立完成适配器，模板方法，职责链设计模式
- 能够独立叙述trait的构造机制
- 能够了解trait继承class的写法
- 能够独立完成程序员案例



## 1. 特质入门

### 1.1 概述

有些时候，我们会遇到一些特定的需求，即：在不影响当前继承体系的情况下，对某些类（或者某些对象）的功能进行加强，例如：有猴子类和大象类，它们都有姓名，年龄以及吃的功能，但是部分的猴子经过马戏团的训练后，学会了骑独轮车，那这个骑独轮车的功能不能定义到父类（动物类或者子类中），而是定义到`特质`中。而Scala中的特质，只要用关键字`trait`修饰

### 1.2 特点

- 特质可以提高代码的复用性

- 特质可以提高代码的拓展性和可维护性

- 类与特质之间是继承关系，只不过类与类之间只支持`单继承`，但是类与特质之间，`既可以单继承，也可以多继承`

- Scala的特质中可以有普通字段，抽象字段，普通方法，抽象方法

  > 注意：
  >
  > - 如果特质中只有抽象内容，这样的特质叫：瘦接口
  > - 如果特之中既有抽象内容，又有具体内容，这样的特质叫：富接口

### 1.3 语法

**定义特质**

```scala
trait 特质名称 {
    // 普通字段
    // 抽象字段
    
    // 普通方法
    // 抽象方法
}
```

**继承特质**

```scala
class 类 extends 特质1 with 特质2 {
    // 重写抽象字段
    // 重写抽象方法
}
```

> 注意：
>
> - scala中不管是类还是特质，继承关系用的都是`extends` 关键字
> - 如果继承多个特质（trait），则特质名之间使用`with` 关键字隔开

### 1.4 示例：类继承单个特质

```scala
package com.pineapple.demo01_trait

object ClassDemo01 {

    trait Logger {

        def log(msg: String)
    }

    class ConsoleLogger extends Logger {

        override def log(msg: String): Unit = println(msg)
    }

    def main(args: Array[String]): Unit = {
        val cl = new ConsoleLogger
        cl.log("类继承单个特质")
    }
}
```

### 1.5 案例：类继承多个特质

```scala
package com.pineapple.demo01_trait

object ClassDemo02 {

    trait MessageSender {

        def send(mes: String)
    }

    trait MessageReceiver {

        def receive()
    }

    class MessageWorker extends MessageSender with MessageReceiver {

        override def send(mes: String): Unit = println(s"发送消息：$mes")

        override def receive(): Unit = println("消息已收到，我很好，谢谢")
    }

    def main(args: Array[String]): Unit = {
        val mw = new MessageWorker
        mw.send("Hello, how are you")
        mw.receive()
    }
}
```

### 1.6 示例：object继承trait

```scala
package com.pineapple.demo01_trait

object ClassDemo02 {

    trait MessageSender {

        def send(mes: String)
    }

    trait MessageReceiver {

        def receive()
    }

    class MessageWorker extends MessageSender with MessageReceiver {

        override def send(mes: String): Unit = println(s"发送消息：$mes")

        override def receive(): Unit = println("消息已收到，我很好，谢谢")
    }

    def main(args: Array[String]): Unit = {
        val mw = new MessageWorker
        mw.send("Hello, how are you")
        mw.receive()
    }
}
```

### 1.7 示例trait中的成员

```scala
package com.pineapple.demo01_trait

object ClassDemo04 {

    trait Hero {
        var name: String = "关羽"
        var arms: String

        def eat(): Unit = println("吃酒喝肉，养精蓄锐")

        def toWar(): Unit
    }

    class Generals extends Hero {

        override var arms: String = "青龙偃月刀"

        override def toWar(): Unit = println(s"武将${name}带着武器$arms，上阵杀敌")
    }

    def main(args: Array[String]): Unit = {
        val g = new Generals
        g.eat()
        g.toWar()
    }
}
```



## 2. 对象混入trait

有些时候，我们希望在不改变类继承体系的情况下，对对象的功能进行临时增强或者拓展，这个时候可以考虑使用对象混入技术了。所谓的对象混入指的是：在Scala中，类和特质之间无任何的继承关系，但是可以通过特定的关键字，让该类对象具有指定特质中的成员。

### 2.1 语法

```scala
val/var 对象名 = new 类 with 特质
```

### 2.2 示例

```scala
package com.pineapple.demo02_blending

object ClassDemo01 {

    trait Logger {

        def log(msg: String): Unit = println(msg)
    }

    class User

    def main(args: Array[String]): Unit = {
        val u = new User with Logger
        u.log("对象混入")
    }
}
```



## 3. 使用trait实现适配器模式

### 3.1 设计模式简洁

**概述	**

设计模式（Design Pattern）是前辈们对代码开发经验的总结，是解决特定问题的一系列套路。它并不是语法规定，而是一套用来提高代码可复用性、可维护性、可读性、稳健性以及安全性的解决方案。

**分类	**

设计模式一共有23中，分为如下的3类：

- 创建型
  - 需要创建对象的，案例模式，工厂方法模式
- 结构型
  - 类，特质之间的关系架构，常用的模式有：适配器模式，装饰模式
- 行为型
  - 类（或者特质）能够做什么，常用的模式有：模板方法模式，职责链模式

### 3.2 适配器模式

当特质中有多个抽象方法，而我们只需要其中的某一个或几个方法时，不得不将该特质中的所有抽象方法给重写了，这样做很麻烦，针对这中情况，我们可以定义一个抽象类去继承该特质，重写特质中所有的抽象方法，方法体为空。这时候，我们需要使用哪个方法，只需要定义继承抽象类，重写指定方法即可。这个抽象类就叫：适配器。这种设计模式（设计思想）叫：适配器设计模式。

**结构	**

```scala
trait 特质A {
    // 抽象方法1
    // 抽象方法2
    // 抽象方法3
    // 抽象方法4
    ......
}

abstract class 类B extends A {
    // 重写抽象方法1，方法体为空
    // 重写抽象方法2，方法体为空
    // 重写抽象方法3，方法体为空
    // 重写抽象方法4，方法体为空
   	......
}
```

```scala
package com.pineapple.demo03_pattern

object ClassDemo01 {

    trait PlayLOL {

        def top()

        def mid()

        def adc()

        def support()

        def jungle()

        def schoolChild()
    }

    abstract class Player extends PlayLOL {

        override def top(): Unit = {}

        override def mid(): Unit = {}

        override def adc(): Unit = {}

        override def support(): Unit = {}

        override def jungle(): Unit = {}

        override def schoolChild(): Unit = {}
    }

    class GreenHand extends Player {

        override def support(): Unit = println("B键一扣，不死不回城！")

        override def schoolChild(): Unit = println("你骂我，我就挂机！")
    }

    def main(args: Array[String]): Unit = {
        val gh = new GreenHand
        gh.support()
        gh.schoolChild()
    }
}
```



## 4. 使用trait实现模板方法模式

### 4.1 概述

在Scala中，我们可以先定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重新定义该算法的某些特定步骤，这就是：模板方法设计模式。

**优点**

- 拓展性强
  - 父类封装公共部分，可变部分由子类实现
- 符合开闭原则
  - 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应功能

**缺点**

- 类的个数增加，导致系统更加庞大，设计更加抽象
  - 因为要对每个不同的实现都需要定义一个子类
- 提高了代码的阅读难度
  - 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构

### 4.2 格式

```scala
class A {
    
    def 方法名(参数列表) = {	// 具体方法，这里也叫模板方法
        // 步骤1，已知
        // 步骤2，未知，调用抽象方法
        // 步骤3，已知
        // 步骤n
    }
}

class B extends A {
    // 重写抽象方法
}
```

### 4.3 示例

```scala
package com.pineapple.demo03_pattern

object ClassDemo02 {

    trait Template {

        def code()

        def getRuntime: Long = {
            val start = System.currentTimeMillis()
            code()
            val end = System.currentTimeMillis()
            end - start
        }
    }

    class ForDemo extends Template {
        override def code(): Unit = for (i <- 1 to 10000) println("Hello, Scala")
    }

    def main(args: Array[String]): Unit = {
        val fd = new ForDemo
        println(fd.getRuntime)
    }
}
```



## 5.使用trait实现职责链模式

### 5.1 概述

多个trait中出现了同一个方法，而且方法最后都调用了super.该方法名()，当类继承了多个trait后，就可以依次调用多个trait中的此同一个方法了，这就形成了一个调用链。

**执行顺序为：**

1. 按照从右往左的顺序依次执行

   即首先会先从最右边的trait方法开始执行，然后依次往左执行对应trait中的方法

2. 当所有子特质的该方法执行完毕后，最后会执行特质中的此方法

   > 注意：在Scala中，一个类继承多个特质的情况叫`叠加特质`

### 5.2 格式

```scala
trait A {			// 父特质
    
    def show()
}

trait B extends A {
    
    override def show() = {
        // 具体的代码逻辑
        super.show()
    }
}

trait C extends A {
    
    override def show() = {
        // 具体的代码逻辑
        super.show()
    }
}

class D extends B with C {	// 具体的类，用来演示：叠加特质
    
    def 方法名() = {
    	// 具体的代码逻辑
        super.show()
    }
}

/**
	执行顺序为：
		1. 先执行类D中自己的方法
		2. 在执行C中的show()方法
		3. 再执行B中的show()方法
		4. 最后执行特质A中的show()方法
*/
```

### 5.3 示例

```scala
package com.pineapple.demo03_pattern

object ClassDemo03 {

    trait Handler {

        /**
         *
         * @param data : 用户发起的具体支付数据
         */
        def handle(data: String): Unit = {
            println("具体的处理数据...")
            println(data)
        }
    }

    trait DataValidHandler extends Handler {

        override def handle(data: String): Unit = {
            println("验证数据...")
            super.handle(data)
        }
    }

    trait SignatureValidHandler extends Handler {

        override def handle(data: String): Unit = {
            println("验证签名...")
            super.handle(data)
        }
    }

    /**
     * 叠加特质
     */
    class Payment extends DataValidHandler with SignatureValidHandler {

        def pay(data: String): Unit = {
            println("用户发起支付请求")
            super.handle(data) // 构成调用链
        }
    }

    def main(args: Array[String]): Unit = {
        val p = new Payment
        p.pay("张三给凤姐转账1000元")
    }
}
```



## 6. trait的构造机制

### 6.1 概述

如果遇到一个类继承了某个父类且继承了多个父特质的情况，那该类(子类)，该类的父类，以及该类的父特质之间是如何构造的呢？

### 6.2 构造机制规则

- 每个特质只有`一个无参数`的构造器

  也就是说：trait也有构造器代码，但和类不一样，特质不能有构造器参数

- 遇到一个类继承另一个类、以及多个trait的情况，当创建该类的实例时，它的构造器执行顺序如下：

  1. 执行`父类`的构造器
  2. 按照`从左往右`的顺序，依次执行trait的构造器
  3. 如果trait有父trait，则先执行`父trait`的构造器
  4. 如果多个trait有同样的父trait，则父trait的构造器只初始化一次
  5. 执行子类构造器

### 6.3 示例

```scala
package com.pineapple.demo04_constructor

object ClassDemo01 {

    trait Logger {
        println("执行Logger构造器")
    }

    trait MyLogger extends Logger {
        println("执行MyLogger构造器")
    }

    trait TimeLogger extends Logger {
        println("执行TimeLogger的构造器")
    }

    class Person {
        println("执行Person的构造器")
    }

    class Student extends Person with MyLogger with TimeLogger {
        println("执行Student类的构造器")
    }

    def main(args: Array[String]): Unit = {
        val s = new Student
    }
}
```



## 7. trait继承class

### 7.1 概述

在Scala中，trait（特质）也可以继承class（类）。特质会将class中的成员都继承下来。

### 7.2 格式

```scala
class A {
    // 成员变量
    // 成员方法
}

trait B extends A {  // 特质B
}
```

### 7.3 示例

```scala
package com.pineapple.demo05_extends

object ClassDemo01 {

    class Message {

        def printMsg(): Unit = println("学好Scala，走到哪里都不怕！")
    }

    trait Logger extends Message

    object ConsoleLogger extends Logger

    def main(args: Array[String]): Unit = {
        ConsoleLogger.printMsg()
    }
}
```



## 8. 案例：程序员

![image-20210311145745896](https://i.loli.net/2021/03/12/dC9Q4uk5wPvaInz.png)

```scala
package com.pineapple.demo06_exerise

object ClassDemo01 {

    /**
     * 程序员类，表示所有程序员
     */
    abstract class Programmer {
        var name: String = _
        var age: Int = _

        def eat()

        def skill()
    }

    /**
     * Java程序猿类
     */
    class JavaProgrammer extends Programmer {

        override def eat(): Unit = println("Java程序猿吃大白菜，喝大米粥")

        override def skill(): Unit = println("我精通Java技术")
    }

    /**
     * Python程序猿类
     */
    class PythonProgrammer extends Programmer {

        override def eat(): Unit = println("Python程序猿吃小白菜，喝小米粥")

        override def skill(): Unit = println("我精通Python技术")
    }

    /**
     * 大数据技术
     */
    trait BigData {

        def learningBigData(): Unit = {
            println("来到黑马程序员之后")
            println("我学会了：Hadoop，Zookeeper，Hbase，Hive，Sqoop，Flink，Spark等技术")
        }
    }

    class PartJavaProgrammer extends JavaProgrammer with BigData {

        override def eat(): Unit = println("精通大数据 + Java技术的程序猿，吃牛肉，和牛奶")

        override def skill(): Unit = {
            super.skill()
            learningBigData()
        }
    }

    class PartPythonProgrammer extends PythonProgrammer with BigData {
        override def eat(): Unit = println("精通大数据 + Python技术的程序猿，吃羊肉，和羊奶")

        override def skill(): Unit = {
            super.skill()
            learningBigData()
        }
    }

    def main(args: Array[String]): Unit = {
        val jp = new JavaProgrammer
        jp.eat()
        jp.skill()
        println("-" * 15)

        val pjp = new PartJavaProgrammer
        pjp.eat()
        pjp.skill()
        println("-" * 15)

        val pp = new PythonProgrammer
        pp.eat()
        pp.skill()
        println("-" * 15)

        val ppp = new PartPythonProgrammer
        ppp.eat()
        ppp.skill()
    }
}
```













