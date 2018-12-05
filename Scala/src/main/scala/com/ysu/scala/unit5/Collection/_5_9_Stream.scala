package com.ysu.scala.unit5.Collection

/**
  * stream了解即可, 没人用
  * created by bing57592     
  * 2018-09-11 12:04
  */
object _5_9_Stream {
  def main(args: Array[String]): Unit = {
    //使用 #:: 得到一个stream: stream只存运算规则, 不存数据
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1) //定义一个numsForm:Stream
    //传递一个值, 并打印stream集合
    val stream1 = numsForm(10)
    println(stream1)

    //tail的每一次使用，都会动态的向stream集合按照规则生成新的元素
    println(stream1.tail) //(11,?)这里, 10之后, 没有元素, 执行一次stream, 然后吐出(11,?)
    println(stream1.tail) //(11,?)这里, 由于上一步操作, 10之后又个11, 根据lazy执行的原则, 不会执行stream
    println("------------------------------------")

    //使用map映射stream的元素并进行一些计算
    println(numsForm(5).map(x => {
      println((x * x))//这行代码, 作为方法的返回, 由最外部的println()打印出来
    }))

  }
}
