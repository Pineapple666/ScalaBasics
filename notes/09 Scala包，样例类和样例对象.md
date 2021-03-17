# Scala 包，样例类和样例对象



## 章节目标

- 理解包的相关内容
- 掌握样例类，样例对象的使用
- 掌握计算器案例



## 1. 包

### 1.1 简介

用`package`修饰

> 注意：
>
> 1. 编写Scala源代码时，包名和源码所在的目录结构可以不一致
>
> 2. 编译后，字节码文件和包名路径会保持一致（由编译器自动完成）
>
> 3. 包名由数字，大小写英文字母，_（下划线），$（美元符）组成，多级包之间用 . 隔开，一般是公司域名反写。
>
>    例如：com.itheima.demo01，cn.itcast.demo02

### 1.2 示例

![image-20210311154629939](https://i.loli.net/2021/03/12/B32IEkuYzUpPVMd.png)

![image-20210311154853882](https://i.loli.net/2021/03/12/PCciny5zs1qA23j.png)

![image-20210311155109810](https://i.loli.net/2021/03/12/r93Ee4nFyADUZX7.png)

### 1.3 作用域

Scala的包也是支持嵌套的，具体的访问规则（作用域）如下

1. 下层可以直接访问上层的内容

   即：在Scala中，子包可以直接访问父包中的内容

2. 上层访问下层内容时，可以通过 `导包(import)` 或者写全包名的形式实现

3. 如果上下层有相同的类，使用时将采用就近原则来访问

   即：上下层的类重名时，优先使用下层的类，如果明确需要访问上层的类，可通过上层路径 + 类名的形式实现

```scala
//package com.pineapple.demo01_package

package com.pineapple {

    import scala.Student

    class Person

    class Teacher

    object ClassDemo02 {
        def main(args: Array[String]): Unit = {
            // 上层访问下层内容
            val s = new Student
            println(s)
        }
    }

    package scala {

        import com.pineapple

        class Person

        class Student

        //        object ClassDemo02 {
        //            def main(args: Array[String]): Unit = {
        //                // 测试下层访问上层内容
        //                val t = new Teacher
        //                println(t)
        //
        //                val s = new Student
        //                println(s)
        //
        //                // 就近访问
        //                val p = new Person
        //                println(p)
        //
        //                // 明确访问上层的类
        //                val p2 = new pineapple.Person
        //                println(p2)
        //            }
        //        }

    }

}
```

### 1.4 包对象

包中可以定义子包，也可以定义类或特质，但是Scala中不允许直接在包中定义变量或者方法，这是因为JVM的局限导致的，包对象可以解决此问题

#### 1.4.1 概述

在Scala中，每个包都有一个包对象，`包对象的名字和包名必须一致`，并且它们之间是`平级`关系，不能嵌套定义。

> 注意：
>
> 1. 包对象也要定义到父包中，这样才能实现`包对象和包的平级`关系
> 2. 包对象一般用于对`包的功能进行补充，增强`等

#### 1.4.2 格式

```scala
package 包名1 {			// 父包
    package 包名2 {		// 子包
        
    }
    
    package object 包名2 {// 包名2的包对象
        
    }
}
```

#### 1.4.3 示例

```scala
package com.pineapple {
    package scala {

        class A

        trait B

        //        var name = ""   // 无法在包中定义对象和方法，指定定义类和特质

        package object scala {
            var name = "Pineapple"

            def sayHello(): Unit = println("Hello, Scala")
        }

        object ClassDemo03 {
            def main(args: Array[String]): Unit = {
                println(scala.name)
                scala.sayHello()
            }
        }

    }

}
```

### 1.5 包的可见性

在Scala中，我们也是可以通过访问权限修饰符（private、protected、默认），来限定包中一些成员的访问权限的

**格式**

```scala
访问权限修饰符[包名]		// 例如：private[com] var name = ""
```

```scala
package com.pineapple {
    class Employee {
        // private[com]解释：
        // private的意思是：name这个成员变量只能在本类（Employee）中直接被访问
        // [com]的意思是：name成员变量可以在com包下的任意类中访问
        private[com] var name = "Pineapple"
        var age = 20

        private[pineapple] def sayHello(): Unit = println("Hello, Scala")
    }

    package scala {
        object ClassDemo04{
            def main(args: Array[String]): Unit = {
                val e = new Employee
                println(e)
                println(e.name, e.age)
                e.sayHello()
            }
        }
    }
}
```

### 1.6 包的引用

#### 1.6.1 概述

在Scala中，导入包也是通过关键字`import`来实现的，但是Scala中的import功能更加强大，更加灵活，他不在局限于只能编写在文件顶部，而是可以编写到Scala文件中任何你需要的地方。且Scala默认引入了`java.lang`包，`scala`包和`Predef`包。

#### 1.6.2 注意事项

1. Scala也并不是完全引入了scala和Predef包中的全部内容，有部分内容还需要导包

   例如：

   ```scala
   import scala.io.StdIn
   ```

2. import可以写在Scala代码的任何地方，缩小了import的作用范围，提高效率

3. 在Scala中，导入某个包的所有类和特质，要通过`_（下划线）`来实现

   ```scala
   import scala._
   ```

4. 如果仅仅是需要某个包中的某几个类或者特质，可以通过`选取器（就是一对大括号）`来实现

   ```scala
   import scala.collection.mutable.{HashSet, TreeSet}  // 表示只引入HashSet和TreeSet
   ```

5. 如果引入的多个包中含有相同的类，则可以通过`重命名或者隐藏`的方式解决

   - `重命名`的格式，类似于Python中的 as

     ```scala
     import 包名1.包名2.{原始类名=>新类名, 原始类名=>新类名}
     ```

   - `隐藏`的格式

     ```scala
     import 包名1.包名2.{原始类名=>_, _}
     
     import java.util.{HashSet=>_, _} 表示引入java.util包下除了HashSet类之外的所有类
     ```

     

```scala
package com.pineapple.demo01_package

import java.util
import scala.collection.mutable

object ClassDemo05 {

    def main(args: Array[String]): Unit = {
        // 导入import java.util.HashSet类
        //        import java.util.HashSet
        //
        //        val hs = new util.HashSet()
        //        println(hs.getClass)

        // 导入java.util包下的所有内容
        //        import java.util._
        //
        //        val list = new ArrayList()
        //        val hs = new HashSet()
        //        println(list.getClass, hs.getClass)

        // 只导入java.util包下的ArrayList和HashSet类
        //        import java.util.{ArrayList, HashSet}
        //
        //        val list = new ArrayList()
        //        val hs = new HashSet()
        //        println(list.getClass, hs.getClass)

        // 通过重命名的方式，解决多个包中类名重复问题
//        import java.util.{HashSet => JavaHashSet}
//        import scala.collection.mutable.HashSet
//
//        val hs = new HashSet()
//        val jhs = new JavaHashSet()
//        println(hs.getClass, jhs.getClass)

        // 隐藏不需要的类
        import java.util.{HashMap=>_,_}
        import scala.collection.mutable.HashSet

        val hs = new HashSet()
        println(hs.getClass)
    }
}
```



## 2.样例类

在Scala中，样例类是一种特殊类，一般是用于保存数据的（类似Java POJO）类，在并发编程以及Spark、Flink这些框架中会经常使用它。

### 2.1 格式

```scala
case class 样例类名([var/val] 成员变量名1: 类型1, 成员变量名2: 类型2, 成员变量名3: 类型3) {}
```

- 如果不写，则变量的默认修饰符是val，即val是可以省略不写的
- 如果要实现某个成员变量值可以被修改，则需要手动添加var来修饰此变量

### 2.2 示例

```scala
package com.pineapple.demo02_case

object ClassDemo01 {

    case class Person(name: String = "张三", var age: Int = 23) {}

    def main(args: Array[String]): Unit = {
        val p = new Person
        println(s"修改前：${p.name}, ${p.age}")

        //        p.name = "李四"       // 这样写会报错，因为在定义成员变量值没有用val或var修饰，系统默认用val
        p.age = 30
        println(s"修改后：${p.name}, ${p.age}")
    }
}
```

### 2.3 样例类中的默认方法

#### 2.3.1 简介

当我们定义了一个样例类后，编译器会自动帮助我们生成一些方法，常用的如下：

- apply()

  - 让我们快速的使用类名来创建对象，`省去new`关键字
  - 如：`val p = Person`

- toString()

  - 和Java中的一样打印对象时调用，默认打印属性值

- equals()

  - 可以让我们通过直接使用 `==` 来比较两个样例类对象的所有成员变量值是否相等
  - 例如L`p1 == p2`比较的是两个对象的值是否相等，而不是地址 

- hashCode()

  - 用来获取对象的哈希值。即：同一对象哈希值肯定相同，不同对象哈希值一般不同

  - 例如：

    ```scala
    val p1 = new Person("张三", 23)
    val p2 = new Person("张三", 23)
    println(p1.hashCode() == p2.hashCode())		// 结果为：true
    ```

- copy()

  - 可以用来快速创建一个属性相同的实例对象，还可以使用带名参数的形式给指定的成员变量赋值

  - 例如：

    ```scala
    val p1 = new Person("张三", 23)
    val p2 = p1.copy(age = 24)
    println(p1)		// 张三，23
    println(p2)		// 张三，24
    ```

- unapply()

  - 一般用作 `提取器`

#### 2.3.2 示例

```scala
package com.pineapple.demo02_case

object ClassDemo02 {

    case class Person(var name: String, var age: Int) {}

    def main(args: Array[String]): Unit = {
        val p1 = Person("张三", 23)
        println(p1)

        val p2 = Person("张三", 23)
        println(p1 == p2)

        // 同一个对象哈希肯定相同，不同对象哈希值一般不同
        println(p1.hashCode, p2.hashCode)
        // 举例：内容不同，哈希值相同
        println("重地".hashCode, "通话".hashCode)
        println("重地1".hashCode, "通话1".hashCode)

        // copy()，快速构建一个类似的对象
        val p3 = p2.copy(age = 30)
        println(p3)
    }
}
```



## 3. 样例对象

在Scala中，`用case修饰的单例对象就叫：样例对象，而且它没有主构造器`，它主要用在这两个地方

1. 当做枚举值使用

   > 枚举：就是一些固定值，用来统一项目规范的

2. 作为没有任何参数的消息传递

   > 注意：这点目前先了解即可，后续讲解Akka并发编程时会详细讲解

### 3.1 格式

```scala
case object 样例对象名
```

### 3.2 示例

```scala
package com.pineapple.demo02_case

object ClassDemo03 {

    trait Sex

    case object Male extends Sex

    case object Female extends Sex

    case class Person(var name:String, var sex:Sex) {}

    def main(args: Array[String]): Unit = {
        val p = Person("张三", Female)
        println(p)
    }
}
```



## 4. 案例：计算器

### 4.1 需求

定义样例类Calculate，并在其中添加4个方法，分别用来计算两个整数的加减乘除操作

### 4.2 示例

```scala
package com.pineapple.demo02_case

object ClassDemo04 {

    case class Calculate(a: Int, b: Int) {

        def add(): Int = a + b

        def subtract(): Int = a - b

        def multiply(): Int = a * b

        def divide(): Int = a / b
    }

    def main(args: Array[String]): Unit = {
        val c = Calculate(10, 3)
        println("加法：" + c.add())
        println("减法：" + c.subtract())
        println("乘法：" + c.multiply())
        println("除法：" + c.divide())
    }
}
```





























