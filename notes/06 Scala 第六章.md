# Scala 第六章



## 章节目标

1. 掌握类和对象的定义
2. 掌握访问修饰符和构造器的用法
3. 掌握main方法的实现方式
4. 掌握伴生对象的使用
5. 掌握定义工具类的案例



## 1. 类和对象

### 1.1 相关概念

什么是面向对象？

`面向对象是一种编程思想，它是基于面向过程的，强调的是以对象为基础完成各种操作`

面向对象的三大思想特点是什么？

- 更复合人们的思考习惯
- 把复杂的事情简单化
- 把程序员从执行者变成指挥者

> 面试题：什么是面向对象？
>
> 思路：概述，特点，举例，总结

### 1.2 创建类和对象

用 `class` 来创建类，用 `new`来创建对象

![image-20210310111133710](https://i.loli.net/2021/03/12/69BiLDyUfj5SZPh.png)

![image-20210310111205337](https://i.loli.net/2021/03/12/WjxFQPBufXtYaeD.png)

![image-20210310111311067](https://i.loli.net/2021/03/12/nJ9x1ycjEQlF28G.png)

```scala
package com.pineapple.demo01_oop

/**
 * 案例：演示类和对象的创建
 */
object ClassDemo02 {

    // 1. 创建Person类
    class Person {}

    // 2. 定义main方法，作为程序的主入口
    def main(args: Array[String]): Unit = {
        // 3. 创建Person类型的对象
        val p = new Person()
        // 4. 打印对象
        println(p)
    }
}
```

```scala
com.pineapple.demo01_oop.ClassDemo02$Person@1fbc7afb
```



### 1.3 创建类的简写形式

**用法**

- 如果类是空的，没有如何成员，可省略 {}
- 如果构造器的参数为空，可以省略()

```scala
package com.pineapple.demo01_oop

/**
 * 案例：演示类和对象的简写形式
 */
object ClassDemo03 {

    // 1. 创建Person类
    class Person

    // 2. 定义main方法，作为程序的主入口
    def main(args: Array[String]): Unit = {
        // 3. 创建Person类型的对象
        val p = new Person
        // 4. 打印对象
        println(p)
    }
}
```

```scala
com.pineapple.demo01_oop.ClassDemo03$Person@1fbc7afb
```



## 2. 定义和访问成员变量

 ```scala
package com.pineapple.demo02_field

/**
 * 案例：演示在类中如何定义成员变量
 */
object ClassDemo01 {

    // 1. 创建Person类
    class Person {
        // 2. 定义姓名和年龄字段
        // 方式一：普通写法
        // val name:String = ""
        // 方式二：采用类型推断
        var name = "" // 姓名
        var age = 0 // 年龄
    }

    // 3. 定义main方法，作为程序的主入口
    def main(args: Array[String]): Unit = {
        // 4. 创建Person类型的对象，空参构造，可以不写 ()
        val p = new Person
        // 5. 给对象的成员变量赋值
        p.name = "张三"
        p.age = 23
        // 6. 打印属性值
        println(p.name, p.age)
    }
}
 ```



## 3. 使用下划线初始化成员变量

### 3.1 用法

- 在定义 `var` 类型的成员变量时，可以使用 `_` 来初始化成员变量
  - String => null
  - Int => 0
  - Boolean => false
  - Double => 0.0
- `val`类型的成员变量，必须要自己手动初始化

### 3.2 示例

```scala
package com.pineapple.demo02_field

/**
     * 案例：演示通过下划线来初始化成员变量
     */
object ClassDemo02 {

    class Person {
        // 方式一：普通写法
        // val name:String = ""
        // 方式二：采用类型推断
        // var name = ""
        // 方式三：采用下划线来初始化成员变量值
        var name: String = _
        var age: Int = _
    }

    def main(args: Array[String]): Unit = {
        val p = new Person
        p.name = "Pineapple"
        p.age = 20
        println(p.name, p.age)
    }
}
```



### 4. 定义和访问成员方法

```scala
package com.pineapple.demo03_method

/**
     * 案例：演示如何在类中定义成员方法
     */
object ClassDemo01 {

    class Customer {
        var name: String = _
        var sex: String = _

        def printHello(msg: String): Unit = println(msg)
    }

    def main(args: Array[String]): Unit = {
        val c = new Customer
        c.name = "Pineapple"
        c.sex = "Male"
        println(c.name, c.sex)
        c.printHello("Hello, Scala")
    }
}
```



## 5. 访问权限修饰符

- 在Java中的访问控制，同样适用于Scala，可以在成员前面添加 private/protected 关键字来控制成员的可见性

- 在Scala中，`没有public关键字`，默认没有被标识 private或protected 的成员都是公共的

  > 注意：在Scala中的权限修饰符只有：private、private[this]、protected、默认四种

```scala
package com.pineapple.demo04_access

/**
 * 案例：演示访问权限修饰符
 */
object ClassDemo01 {

    class Person {
        private var name: String = _
        private var age: Int = _

        def getName: String = name

        def setName(name: String): Unit = this.name = name

        def getAge: Int = age

        def setAge(age: Int): Unit = this.age = age
    }

    def main(args: Array[String]): Unit = {
        val p = new Person
        //        p.name = "张三"  报错，private修饰的变量只能在本类中访问
        p.setName("Pineapple")
        p.setAge(20)
        println(p.getName, p.getAge)
    }
}
```



## 6. 类的构造器

### 6.1 分类

- 主构造器
- 辅助构造器

### 6.2 主构造器

**语法**

```scala
class 类名(var/val 参数名: 类型 = 默认值, val/var 参数名: 类型 = 默认值) {
    // code
}
```

> 注意：
>
> - 主构造器的参数列表直接定义在类名后面，添加了val/var表示直接通过主构造器定义成员变量
> - 构造器列表可以指定默认值
> - 创建实例，调用构造器可以指定字段进行初始化
> - 整个class 中除了字段定义和方法定义的代码都是构造代码

```scala
package com.pineapple.demo05_constructor

object ClassDemo01 {

    class Person(val name: String = "Pineapple", val age: Int = 20) {
        println("调用主构造器了！")

        override def toString = s"Person($name, $age)"
    }

    def main(args: Array[String]): Unit = {
        val p1 = new Person()
        println(p1)
        
        val p2 = new Person(age = 23)
        println(p2)
        
        val p3 = new Person("李四", 24)
        println(p3)
    }
}
```

```scala
调用主构造器了！
Person(Pineapple, 20)
调用主构造器了！
Person(Pineapple, 23)
调用主构造器了！
Person(李四, 24)
```

### 6.3 辅助构造器

主构造器之外的构造器，都叫辅助构造器

**语法**

- 和定义方法一样，也使用 `def` 关键字来定义
- 辅助构造器的名字都是 `this`，且不能修改

```scala
def this(参数名: 类型, 参数名: 类型) {
    // 第一行需要调用主构造器或者其他构造器
    // code
}
```

```scala
package com.pineapple.demo05_constructor

object ClassDemo02 {

    class Customer(val name: String, val address: String) {

        def this(arr: Array[String]) {
            this(arr(0), arr(1))
        }

        override def toString = s"Customer($name, $address)"
    }

    def main(args: Array[String]): Unit = {
        val c1 = new Customer(Array("Pineapple", "NewYork"))
        val c2 = new Customer("Pine", "Beijing")
        println(c1)
        println(c2)
    }
}
```



## 7. 单例对象

Scala中是没有static关键字的，想要定义类似于Java中的static变量方法，就要使用到Scala中的单例对象 `object`

### 7.1 定义单例对象

单例对象表示全局仅有一个对象，也叫`孤立对象`。定义单例对象和定义类很像，就是把class换成object

**格式**

```scala
object 单例对象名{}
```

> 注意：
>
> - 在object中定义的成员变量类似于Java中的静态变量，在内存中都只有一个对象
> - 在单例对象中，可以直接使用 `单例对象名.`的形式调用成员

  **示例**

```scala
package com.pineapple.demo06_object

/**
 * 案例：演示如何创建单例对象
 */
object ClassDemo01 {

    object Dog {
        val leg_num = 4
    }

    def main(args: Array[String]): Unit = {
        println(Dog.leg_num)
    }
}
```

### 7.2 在单例对象中定义方法

单例对象的成员方法类似于Java中的静态方法

```scala
package com.pineapple.demo06_object

/**
 * 案例：演示在单例对象中定义成员方法
 */
object ClassDemo02 {

    object PrintUtil {

        def printSplitter(): Unit = println("-" * 15)
    }

    def main(args: Array[String]): Unit = {
        PrintUtil.printSplitter()
    }
}
```



## 8. main方法

Scala程序中运行程序必须要有main方法。Java中main方法的静态的，而在Scala中没有静态static关键字。所以Scala中的main方法必须放到一个单例对象object中。

### 8.1 定义main方法

```scala
def main(args: Array[String]): Unit = {
    // code
}
```

```scala
package com.pineapple.demo07_main

/**
 * 案例：演示通过main方法定义程序入口
 */
object ClassDemo01 {
    def main(args: Array[String]): Unit = {
        println("Scala")
    }
}
```

### 8.2 继承App特质

创建一个object，继承自App特质`(Trait)`，然后将需要编写在main方法中的代码，卸载object的构造方法内。

```scala
object 单例对象名 extends App {
    // code
}
```

```scala
package com.pineapple.demo07_main

/**
 * 案例：通过继承App特质的方式，定义程序入口
 */
object ClassDemo02 extends App {
    println("Scala")
}
```



## 9. 伴生对象

在Java中，经常会有一些类，同时有实例成员又有静态成员。例如：

```java
public class Generals {

    private static final String armsName = "青龙偃月刀";

    public void toWar() {
        // 打仗
        System.out.println("武将拿着" + armsName + ", 上阵杀敌");
    }

    public static void main(String[] args) {
        new Generals().toWar();
    }
}
```

### 9.1 定义伴生对象

一个class和object具有同样的名字。这个object成为称为对象，这个class称为伴生类

- 伴生对象要和伴生类名字一样
- 伴生对象和伴生类在同一个文件中
- 伴生对象和伴生类可以互相访问private属性

```scala
package com.pineapple.demo08_companion

/**
 * 案例：演示如何定义伴生对象
 */
object ClassDemo01 {

    class Generals {

        def toWar(): Unit = println(s"武将拿着${Generals.armsName}，上阵杀敌")
    }

    object Generals {

        private val armsName = "青龙偃月刀"
    }

    def main(args: Array[String]): Unit = {
        val c = new Generals
        c.toWar()
    }
}
```

### 9.2 private[this]访问权限

如果某个成员的权限设置为private[this]，表示只能在当前类中访问。`伴生对象也不可以访问`。

```scala
package com.pineapple.demo08_companion

/**
 * 案例：演示private[this]访问权限修饰符
 */
object ClassDemo02 {

    class Person(private var name: String)
//    class Person(private[this] var name: String) 这样写会报错

    object Person {

        def printPerson(p: Person): Unit = println(p.name)
    }

    def main(args: Array[String]): Unit = {
        val p = new Person("Pineapple")
        Person.printPerson(p)
    }

}
```

### 9.3 apply方法

在Scala中，支持创建对象的时候，`免new`的操作。通过对伴生对象的apply方法实现

#### 9.3.1 格式

**定义apply方法的格式**

```scala
object 伴生对象名 {
    def apply(参数名: 参数类型, 参数名: 参数类型...) = new 类(..)
}
```

**创建对象**

```scala
val 对象名 = 伴生对象名(参数1, 参数2)
```

```scala
package com.pineapple.demo08_companion

object ClassDemo03 {

    class Person(var name: String, var age: Int) {

        override def toString = s"Person($name, $age)"
    }

    object Person {

        def apply(name: String, age: Int): Unit = {

        }
    }

    def main(args: Array[String]): Unit = {
        val p: Unit = Person("Pineapple", 20)
        println(p)
    }
}
```



## 10. 案例：定义工具类

Scala中工具类的概念和Java中是一样的，都是

- 构造方法全部私有化，目的是不让外界通过构造方法来创建工具类的对象

- 成员全部是静态化，意味着外界可以通过 "类名." 的形式来访问工具类中的内容

  > 综上所属，在Scala中只有`object`单例对象满足上述的要求

```scala
package com.pineapple.demo09_utils

import java.text.SimpleDateFormat
import java.util.Date

/**
 * 案例：定义日期工具类
 */
object ClassDemo01 {

    object DataUtils {
        var sdf: SimpleDateFormat = _

        def date2String(date: Date, template: String): String = {
            sdf = new SimpleDateFormat(template)
            sdf.format(date)
        }

        def string2Date(dateString: String, template: String): Date = {
            sdf = new SimpleDateFormat(template)
            sdf.parse(dateString)
        }
    }

    def main(args: Array[String]): Unit = {
        println(DataUtils.date2String(new Date(), "yyyy-MM-dd"))
        println(DataUtils.string2Date("1314年5月21日", "yyyy年MM月dd日"))
    }
}
```