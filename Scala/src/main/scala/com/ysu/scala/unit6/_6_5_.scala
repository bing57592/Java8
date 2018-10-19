package com.ysu.scala.unit6

/**
  *
  * created by bing57592     
  * 2018-09-11 12:57
  */
object _6_5_ {
  def main(args: Array[String]): Unit = {

    // 匹配数组(Array)
    for (array <- Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val result = array match {
        case Array(0) => "0"
        case Array(x, y) => x + " " + y
        case Array(x, y, z) => x + " " + y + " " + z
        case Array(0, _*) => "0..."
        case _ => "something else"
      }
      println(result)
    }
    println("------------------------------------")


    // 匹配列表(List) ==> :: 是操作List集合(列表)的符号
    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0"
        case x :: y :: Nil => x + " " + y // _ 和 x 是一样的, 只不过 _ 只能用一次(装逼力Max)
        case 0 :: tail => "0 ..."
        case _ => "something else"
      }
      println(result)
    }
    println("------------------------------------")


    // 匹配元祖(Tuple)
    for (pair <- Array((0, 1), (1, 0), (1, 1))) {
      val result = pair match {
        case (0, _) => "0 ..."
        case (y, 0) => y + " 0"
        case _ => "neither is 0"
      }
      println(result)
    }

  }
}
