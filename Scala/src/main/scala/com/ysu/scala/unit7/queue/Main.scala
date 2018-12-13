package com.ysu.scala.unit7.queue

import scala.collection.mutable

/**
  * 队列Queue-基本介绍
  * 队列的说明:
  * 1. 队列是一个有序列表, 在底层可以用数组或者链表实现.
  * 2. 输入和输出要遵循 "先进先出" 的原则. 即: 先存入队列的数据要先取出, 后存入队列的数据要后取出.
  * 3. 在Scala 中, 由设计者直接给我们提供队列类型的使用.
  *
  * @Author bing57592 
  * @Date 2018-12-08 03:28
  */
object Main {
  def main(args: Array[String]): Unit = {

    // 初始化一个队列
    var queue1 = new mutable.Queue[Any]
    println(queue1)

    // +=  向队列中添加元素
    var queue2 = queue1 += 1
    println(queue2)


    // ++= 向队列中追加List
    var list3 = List(2, 4, 5)
    var queue3 = queue2 ++= list3
    println(queue3)

    // 从队列中删除元素(返回被删除了的元素)
    var element = queue3.dequeue()
    println(element + " --- " + queue3)

    // enqueue(): 依次向队列中添加元素
    var queue5 = queue3.enqueue(7, 9, 8) // 7, 9, 8 依次进入队列中
    println(queue3)
    var queue6 = queue3.enqueue(List(2001, 2005, 2009))
    println(queue3)

    // 返回队列的第一个元素 && 返回队列的最后一个元素
    println(queue3.head)
    println(queue3.last)
  }
}
