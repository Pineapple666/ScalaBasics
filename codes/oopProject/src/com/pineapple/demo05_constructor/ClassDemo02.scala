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