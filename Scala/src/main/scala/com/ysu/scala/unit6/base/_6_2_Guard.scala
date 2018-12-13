package com.ysu.scala.unit6.base

/**
  *
  * created by bing57592     
  * 2018-09-11 12:38
  */
object _6_2_Guard {
  def main(args: Array[String]): Unit = {
    val op = "+-3a*"
    var result = 0;
    for (x <- op) {
      // op是个字符串, 那么x <- op 这样的话, x就自动为一个char元素了
      // MatchError: 如果模式匹配没有覆盖到某项元素
      x match {
        case '+' => println(123)
        case '-' => result = 200
        case '*' => result = 1000
        case _ if Character.isDigit(x) => println("是真SB")
        case _ => println("SB")
      }
      println(result)
    }
  }
}
