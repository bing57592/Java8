package com.ysu.scala.unit6

/**
  * 用switch来类比是不严谨的
  * created by bing57592     
  * 2018-09-11 12:34
  */
object _6_1_Switch {
  def main(args: Array[String]): Unit = {
    val op = "+"
    var result = 0 ;
    op match{
      case "+" => result = 100
      case "-" => result = 200
      case "*" => result = 1000
    }
    println(result)
  }
}
