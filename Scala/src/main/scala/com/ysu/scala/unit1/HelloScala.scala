package com.ysu.scala.unit1

/**
  *
  * created by bing57592     
  * 2018-09-09 18:50
  */
object HelloScala {
  def main(args: Array[String]): Unit = {
    val map = Map("Alice" -> 123, "Bob" -> 234)
    val str: String = "";


    val key : String = "alice"

    println(map.get(key));
    println(map(key));

    var range = 10 to 1 ;
    println(range)
  }

}

