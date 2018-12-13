package com.ysu.scala.unit7.mutable


import scala.collection.mutable.ArrayBuffer


/**
  * 可变集合(可变数组 / 变长数组):
  * 可变集合, 就是这个集合可以本身是可以变的, 成为一个新的集合.
  * 1. ArrayBuffer 是变长数组, 类似Java的ArrayList
  * 2. val arr2 = ArrayBuffer[Int]() 也是使用的apply方法构建对象
  * 3. def append(elems: A*){appendAll(elems)}接收的是可变参数.
  * 4. 每append 一次, array 在底层会重新分配空间, 进行扩容. array 的内存地址发生变化,
  * ---也就称为新的ArrayBuffer
  *
  * @Author bing57592 
  * @Date 2018-12-07 21:40
  */
object Main {
  def main(args: Array[String]): Unit = {
    // ArrayBuffer无序的(可变)集合, 增加元素使用的是append可变
    var arr1 = ArrayBuffer[Any](0)
    arr1.append(13)
    arr1.append("1234", 1234)
    for (elem <- arr1) {
      println(arr1)
    }
    var array = arr1.toArray
    var buffer = array.toBuffer
    for (elem <- buffer) {
      println(elem)
    }

    val arr = ArrayBuffer("1", "2", "3")
    import scala.collection.JavaConversions.bufferAsJavaList
    // 这是一个Java数组
    val javaArr = new ProcessBuilder(arr)
    // 将Java数组转换为Scala数组
    var scalaArr = javaArr.command()
  }
}
