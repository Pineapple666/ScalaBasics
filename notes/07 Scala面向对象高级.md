# Scala面向对象高级



## 章节目标

- 掌握继承和抽象类
- 掌握匿名内部类的用法
- 了解类型转换的内容
- 掌握动物类案例



## 1. 继承

### 1.1 语法

- Scala中使用 `extends`关键字来实现继承
- 可以在子类中定义父类中没有的字段和方法，或者重写父类的方法
- 类和单例对象都可以有父类

```scala
class/object A extends B {
    // code
}
```

**叫法**

- A类称为：子类，派生类
- B类称为：父类，基类

### 1.2 类继承

```scala
package com.pineapple.demo01_extends

object ClassDemo01 {

    class Teacher {
        var name: String = _
        var age: Int = _

        def eat(): Unit = println("人要吃饭")
    }

    class Student extends Teacher

    def main(args: Array[String]): Unit = {
        val t = new Teacher
        t.name = "刘老师"
        t.age = 33
        println(t.name, t.age)
        t.eat()
        println("-" * 15)
        val s = new Student
        s.name = "Pineapple"
        s.age = 20
        println(s.name, s.age)
        s.eat()
    }
}
```

### 1.3 单例对象的继承

```scala
package com.pineapple.demo01_extends

object ClassDemo02 {

    class Person {
        var name: String = _

        def sayHello(): Unit = println(s"Hello, ${name}")
    }

    object Student extends Person

    def main(args: Array[String]): Unit = {
        Student.name = "Pineapple"
        Student.sayHello()
    }
}
```

### 1.4 方法重写

#### 1.4.1 概述

Scala代码中可以在子类中使用 override 来重写父类的成员，也可以使用 super 来引用父类的成员。

#### 1.4.2 注意事项

可以使用 override来重写一个 val 字段，不可以重写一个 var 修饰的变量

#### 1.4.3 示例

```scala
package com.pineapple.demo02_override

object ClassDemo01 {

    class Person {
        val name = "张三"
        var age = 23

        def sayHello(): Unit = println(s"Hello, $name, i know your age is $age")
    }

    class Student extends Person {
        override val name = "李四"
        override var age = 30

        override def sayHello(): Unit = println(s"age $age, name $name")
    }

    def main(args: Array[String]): Unit = {
        val s = new Student
        println(s.age)
    }
}
```

运行时报错

```scala
overriding variable age in class Person of type Int;
 variable age cannot override a mutable variable
        override var age = 30
```

var 定义的变量前是不能用override修饰的

```scala
package com.pineapple.demo02_override

object ClassDemo01 {

    class Person {
        val name = "张三"
        var age = 23

        def sayHello(): Unit = println(s"Hello, $name, i know your age is $age")
    }

    class Student extends Person {
        override val name = "李四"
        age = 20

        override def sayHello(): Unit = {
            super.sayHello()
            println(s"age $age, name $name")
        }
    }

    def main(args: Array[String]): Unit = {
        val s = new Student
        s.sayHello()
    }
}
```



## 2. 类型推断

有时候，我们设计的程序，要根据变量的类型来执行对应的逻辑

![image-20210310211204151](/home/pineapple/.config/Typora/typora-user-images/image-20210310211204151.png)

两种方式：

- isInstanceOf
- getClass/classOf

### 2.1 isInstanceOf, asInstanceOf

**概述**

- isInstanceOf：判断对象是否为指定类的对象
- asInstanceOf：将对象转换为指定类型

**格式**

```scala
// 判断对象是否为指定类型
val trueOrFalse: Boolean = 对象.isinstanceOf[类型]

// 将对象转换为指定类型
val 变量 = 对象.asInstanceOf[类型]
```

### 2.2 案例

```scala
package com.pineapple.demo03_change

object ClassDemo01 {

    class Person

    class Student extends Person {

        def sayHello(): Unit = println("Hello, Student!")
    }

    def main(args: Array[String]): Unit = {
        /*
        多态：
        概述：同一个事物在不同时刻表现出来的不同形态，状态
        弊端：父类引用不能直接使用子类的特有成员
         */
        val p: Person = new Student
        // p.sayHello() 报错，父类引用不能直接使用子类的特有成员

        // 解决方案：
        if (p.isInstanceOf[Student]) {
            val s = p.asInstanceOf[Student]
            // 上面相当于：val s: Student = new Student
            s.sayHello()
        }
    }
}
```

### 2.3 getClass和classOf

isInstanceOf只能推断对象是否为`指定类及其子类`，而不能精确的推断出：对象就是指定类的对象。想要更精确，那么就要用getClass和classOf来实现

**用法**

- p.getClass可以精确获取对象的类型
- classOf[类名]可以精确获取数据类型
- 使用 == 操作符可以直接比较类型

**示例**

```scala
package com.pineapple.demo03_change

object ClassDemo02 {

    class Person

    class Student extends Person

    def main(args: Array[String]): Unit = {
        // 通过多态的形式创建student类型的对象
        val person: Person = new Student
        println(person.isInstanceOf[Person])
        println(person.isInstanceOf[Student])
        println(person.getClass == classOf[Person])
        println(person.getClass == classOf[Student])
    }
}
```



## 3. 抽象类

通过abstract关键字实现抽象类

### 3.1 定义

如果类中有抽象字段或抽象方法，那么该类就是抽象类

> - 抽象字段：没有初始化值的变量就是抽象字段
> - 抽象方法：没有方法体法方法就是一个抽象方法

### 3.2 格式

```scala
abstract class 抽象类名 {
    // 定义抽象字段
    val/var 抽象字段名: 类型
    
    // 定义抽象方法
    def 方法名(参数: 类型...): 返回类型
}
```

### 3.3 案例

![image-20210311091244370](/home/pineapple/.config/Typora/typora-user-images/image-20210311091244370.png)

```scala
package com.pineapple.demo04_abstract

object ClassDemo01 {

    abstract class Shape {

        def area(): Double
    }

    class Square(var edge: Double) extends Shape {
        
        override def area(): Double = edge * edge
    }

    class Rectangle(var length: Double, var width: Double) extends Shape {

        override def area(): Double = length * width
    }

    class Circle(var radius: Double) extends Shape {

        override def area(): Double = Math.PI * radius * radius
    }

    def main(args: Array[String]): Unit = {
        val square = new Square(5)
        println(s"Square: ${square.area()}")

        val rectangle = new Rectangle(4, 3)
        println(s"Rectangle: ${rectangle.area()}")

        val circle = new Circle(3)
        println(s"Circle: ${circle.area()}")
    }
}
```

### 3.4 抽象字段

```scala
package com.pineapple.demo04_abstract

object ClassDemo02 {

    abstract class Person {
        val occupation: String
    }

    class Student extends Person {
        override val occupation: String = "学生"
    }

    class Teacher extends Person {
        override val occupation: String = "老师"
    }

    def main(args: Array[String]): Unit = {
        val student = new Student
        val teacher = new Teacher
        println(student.occupation, teacher.occupation)
    }
}
```



## 4. 匿名内部类

匿名内部类是`继承了类的匿名的子类对象`，它可以直接用来创建实例对象。Spark的源代码中大量使用到匿名内部类。

### 4.1 语法

```scala
new 类名() {
    // code
}
```

### 4.2 使用场景

- 当对对象方法（成员方法）仅调用一次的时候
- 可以作为方法的参数进行传递

### 4.3 示例

```scala
package com.pineapple.demo05_inner

object ClassDemo01 {

    abstract class Person {

        def sayHello(): Unit
    }

    def show(person: Person): Unit = person.sayHello()

    def main(args: Array[String]): Unit = {
        // 对成员方法仅调用一次的时候，使用匿名内部类
        new Person {
            override def sayHello(): Unit = println("Hello, Scala")
        }.sayHello()

        // 多态
        val person: Person = new Person {
            override def sayHello(): Unit = println("Hello, Scala")
        }

        show(person)
    }
}
```



## 5. 案例：动物类

```scala
package com.pineapple.demo06_animal

object ClassDemo01 {

    abstract class Animal {
        var name: String = _
        var age: Int = _

        def run(): Unit = println("动物会跑步")

        def eat(): Unit
    }

    class Cat extends Animal {

        override def eat(): Unit = println("猫吃鱼")

        def catchMouse(): Unit = println("猫会抓老鼠")
    }

    class Dog extends Animal {

        override def eat(): Unit = println("狗吃肉")

        def lookHome(): Unit = println("狗会看家")
    }

    def main(args: Array[String]): Unit = {
        val cat: Animal = new Cat
        // val cat: Animal = new Dog
        cat.name = "加菲猫"
        cat.age = 2
        println(cat.name, cat.age)
        cat.run()
        cat.eat()
        if (cat.isInstanceOf[Cat]) {
            val cat2 = cat.asInstanceOf[Cat]
            cat2.catchMouse()
        } else {
            println("您传入的不是猫类对象")
        }
    }
}
```

















