package com.ysu.scala.unit8

/**
  *
  * @Author bing57592 
  * @Date 2018-12-12 17:01
  */
object EnumDemo {
    def main(args: Array[String]): Unit = {
        for (item <- Array(Spring, Autumn)) {
            item match {
                case Spring => println("春天")
                case Autumn => println("秋天")
                case _ => println("error")
            }
        }
    }
}

//创建样例类
abstract class Season

case object Spring extends Season

case object Autumn extends Season
