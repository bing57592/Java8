package com.ysu.scala.unit7.highorder

import scala.collection.mutable


/**
  *
  * 映射Map-基本介绍:
  * HashMap 是一个散列表, 它存储的内容是键值对(key-value)映射, Java中HashMap是无序的.
  * Scala 中的Map介绍
  * Scala 中Map 和Java 类似, 也是一个散列表, 它存储的内容也是键值对(key-value)映射, Scala中不可变
  * 的Map是有序的, 可变的Map是无序的.
  *
  * @Author bing57592
  * @Date 2018-12-08 14:36
  */
object MapExercise {
  def main(args: Array[String]): Unit = {

  }

  /**
    * 将 val names = List("Alice", "Bob", "Nick")中的所有单词, 全部转换成字母大写,
    * 返回到一个新List中去.
    */
  private def method2 = {
    val names = List("Alice", "Bob", "Nick")
    val res = names.map(x => x.toUpperCase)
    println(res)
  }

  /**
    * 使用map映射函数, 解决问题
    */
  private def method1 = {
    /**
      * 看一个实际需求:
      * 要求: 请将List(3, 5, 7)中所有的元素都 * 2 , 将结果放到一个新的集合中返回, 即要求新的
      * List(6, 10, 14). --> 引申出Map映射操作:
      *
      *
      * Map映射操作:
      * 在Scala中可以通过map映射操作来解决: 将集合中的每一个元素通过指定功能 (函数) 映射 (转化) 成
      * 新的结果集合, 这里其实就是所谓的将函数作为参数传递给另一个参数, 这就是函数式编程的特点.
      *
      * 以HashSet为例说明
      * def map[B](f:(A) => (B): HashSet[B]
      * 1. 这个就是map映射函数集合类型都有
      * 2. [B]是泛型
      * 3. f: (A) => B 是一个高阶函数, 后面详解
      * 4. HashZSet[B] 就是返回的新的集合
      */
    var map = mutable.Map((1, 5), (2, 11), (4, 66))
    var list1 = List(3, 5, 7)
    println(list1)

    /**
      * list1.map(mul)解析:
      * 1. 将list1的集合遍历, 传给mul函数.
      * 2. 将运算结果放到一个新的集合中, 并返
      **/
    var list2 = list1.map(mul)
    println(list2)
    var list3 = list2.map(x => x * 100)
    println(list3)
  }

  def mul(n: Int): Int = {
    n * 2
  }
}
