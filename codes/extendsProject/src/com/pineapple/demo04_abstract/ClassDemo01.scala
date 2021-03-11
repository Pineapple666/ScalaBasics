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