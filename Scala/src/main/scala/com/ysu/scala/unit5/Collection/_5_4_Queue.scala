package com.ysu.scala.unit5.Collection

import scala.collection.mutable


/**
  *
  * created by bing57592     
  * 2018-09-10 00:55
  */
object _5_4_Queue {
  def main(args: Array[String]): Unit = {
    var queue1 = new mutable.Queue[Int]();
    queue1.enqueue(1, 2) // 从左到右, 依次进入队列
    println(queue1)
    queue1.dequeue()
    println(queue1)
    println("------------------------------------")
    queue1 ++= List(1, 2, 3, 4) // 从左到右, 向队列中追加一个集合
    println(queue1)

    //拿到队列的第一个元素
    println(queue1.head)
    //拿到队列的最后一个元素
    println(queue1.last)
    //拿到队列除了第一个元素之外的所有元素(这个功能有什么用呢?)
    println(queue1.tail)
  }

}
