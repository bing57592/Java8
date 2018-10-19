package com.ysu.scala.unit5

import scala.collection.mutable.ArrayBuffer;

/**
  *
  * created by bing57592     
  * 2018-09-10 00:07
  */
object _5_1_Array {
  def main(args: Array[String]): Unit = {
    var array1 = new Array[Int](10);
    println(array1.mkString(", "))

    var array2 = Array(1, 2, 3, 4, 5)

    // 替换
    array2(1) = 10000;
    println(array2.mkString(", "))
    println(array2(3))

    // 追加
    var array2_1 = array2 :+ 99; // 后追加
    println(array2_1.mkString(", "))
    var array2_2 = 99 +: array2; // 前追加
    println(array2_2.mkString(", "))
    println("----------------------------------------")

    // 变长数组
    var array3 = new ArrayBuffer[Int](); // 1.可变
    array3.append(1) // 2.追加操作
    array3.append(2)
    array3.append(23)
    println(array3.mkString(", "))



    // hello
  }
}
