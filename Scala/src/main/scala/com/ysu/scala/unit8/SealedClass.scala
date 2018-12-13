package com.ysu.scala.unit8

/**
  * 密封类:
  * 1. 如果想让case类的所有子类都必须在声明该类的相同源文件中定义, 可以将样例类的通用超类声明为sealed
  * ---这个超类称之为密封类;
  * 2. 密封就是不能在其他文件中定义子类.
  *
  * @Author bing57592 
  * @Date 2018-12-12 16:39
  */
object SealedClass {
    def main(args: Array[String]): Unit = {
        abstract sealed class Amount
        case class Dollar(value: Double) extends Amount
        case class Currency(value: Double, unit: String) extends Amount
        case object Nohting extends Amount
    }
}
