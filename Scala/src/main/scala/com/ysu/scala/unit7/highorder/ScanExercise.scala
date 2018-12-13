package com.ysu.scala.unit7.highorder

import scala.collection.mutable.ArrayBuffer

/**
  * 扫描:
  * 扫描, 即对某个集合的所有元素做fold 操作, 但是会把产生的所有中间结果放置在一个集合中保存.
  *
  * @Author bing57592 
  * @Date 2018-12-09 00:53
  */
object ScanExercise {
  def main(args: Array[String]): Unit = {
    /**
      * 课堂练习1
      * 将sentence中各个字符, 通过flodLeft存放到一个ArrayBuffer中
      */
    val sentence = "AAAAAAABBBBBBBCCCCCDDDDD"
    val arr = ArrayBuffer[Char]()
    val res = sentence.foldLeft(arr)(putArry)
    println(res)

  }

  def putArry(arr: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    arr.append(c)
    arr
  }

  private def method1 = {
    var list = List(1, 2, 3, 4, 5)
    var vector = list.scanLeft(5)(_ - _)
    println(vector)
  }
}
