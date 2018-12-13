package com.ysu.scala.unit7.highorder

/**
  * 定义一个不可变类Pair[T, S], 带一个swap方法. 返回组件交换过位置的新对偶
  *
  * @Author bing57592 
  * @Date 2018-12-10 00:03
  */
object Exercise1 {
  def main(args: Array[String]): Unit = {
    var res = Pair(1, 5).swap
    println(res)
  }
}

class Pair[T, S](val t: T, s: S) {
  def swap(): Unit = {
    new Pair(s, t)
  }

  override def toString = s"Pair($t, $swap)"
}
