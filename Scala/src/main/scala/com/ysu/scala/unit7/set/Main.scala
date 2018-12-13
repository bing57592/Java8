package com.ysu.scala.unit7.set

import scala.collection.mutable

/**
  * 集合Set
  *
  * @Author bing57592 
  * @Date 2018-12-08 14:23
  */
object Main {
  def main(args: Array[String]): Unit = {
    method1

  }

  private def method1 = {
    /**
      * 创建一个不可变的Set
      */
    val set = Set(1, 2, 3)
    println(set)

    /**
      * 创建一个可变的Set
      */
    val set1 = mutable.Set(1, 2, 3)
    println(set1)

    /**
      * 向集合中添加元素
      * 方式一: set2.add(4)
      * 方式二: set2 += 6
      * 方式三: set2.+(5)   只有这种方式, 不会对原集合做操作, 而是将操作后的结果生成一个新的集合返回.
      * 如果对象已经存在, 不会重复添加, 也不会报错.
      */
    var set2 = set1
    set2.add(500)
    set2 += 400
    var res = set2.+(600)
    println("set2 = " + set2 + ", res = " + res)

    /**
      * 从集合中删除元素
      * 方式一: set3 -= 5
      * 方式二: set3.remove(6)
      * 方式三: set3.-(333)
      */
    var set3 = set2
    set3.remove(500)
    set3 -= 400
    set3.-(3)
    println(set3)

    /**
      * 集合的遍历
      */
    var set4 = set3
    for (elem <- set4) {
      println(elem)
    }
  }
}
