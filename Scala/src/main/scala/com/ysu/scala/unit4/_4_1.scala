package com.ysu.scala.unit4

import scala.util.control.Breaks

/**
  *
  * created by bing57592     
  * 2018-09-09 21:23
  */
object _4_1 {
  def main(args: Array[String]): Unit = {
    var a: Int = 10;
    val b = if (a > 5) {
      a
    }

    println(b)
    var looper = new Breaks
    looper.breakable(while (a > 1) {
      a -= 1;
      if (a < 3) {
        looper.break()
        println(a)
      }
    })
  }

  def play(str: String) = {
    println(str)
  }
}
