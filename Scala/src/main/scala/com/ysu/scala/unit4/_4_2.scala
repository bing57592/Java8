package com.ysu.scala.unit4

import scala.util.control.Breaks

/**
  *
  * created by bing57592     
  * 2018-09-09 21:57
  */
class _4_2 {
  def main(args: Array[String]): Unit = {
    var n = 10;
    val loop = new Breaks
    loop.breakable(while (n > 20) {
      n -= 1;
    })
  }
}