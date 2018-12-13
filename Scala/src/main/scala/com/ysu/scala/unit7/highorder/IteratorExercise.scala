package com.ysu.scala.unit7.highorder

/**
  *
  * @Author bing57592 
  * @Date 2018-12-09 18:43
  */
object IteratorExercise {
  def main(args: Array[String]): Unit = {
    var list = List(1, 2, 3, 4, 5)
    var iterator = list.iterator
    for (elem <- iterator) {
      println(elem)
    }
  }
}
