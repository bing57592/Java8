package com.ysu.scala.unit6.implicits

/**
  *
  * @Author bing57592 
  * @Date 2018-12-07 00:53
  */
object ImplicitValue {
  def main(args: Array[String]): Unit = {
    implicit val name: String = "urok"

    def function1(implicit name: String): Unit = {
      println(name)
    }

    function1
  }


}
