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