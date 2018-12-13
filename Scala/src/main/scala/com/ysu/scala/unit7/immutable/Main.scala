package com.ysu.scala.unit7.immutable

/**
  * 不可变集合:
  * Scala默认使用不可变集合, 对于几乎所有的集合类, Scala都同时提供了可变和不可变版本.
  * scala不可变集合, 就是这个集合本身不可以改变. 类似Java的数组, 不可以动态增长
  *
  * @Author bing57592 
  * @Date 2018-12-07 21:36
  */
object Main {
  def main(args: Array[String]): Unit = {
    // new 是关键字, [Int]指定可以存放的数据类型; (5)表示数组长度5不可变
    var arr1 = new Array[Int](5)
    println(arr1.length)

    // 遍历数组
    for (i <- arr1) println(i)

    // 直接将元素插入到数组中, 调用apply方法
    var arr2 = Array(1, 2, "XXX")
    println(arr2)
  }
}
