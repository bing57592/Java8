package com.ysu.scala.unit7.highorder

/**
  * 集合元素的过滤-filter
  * filter: 将符合要求的数据(筛选)放置到新的集合中.
  *
  * @Author bing57592 
  * @Date 2018-12-08 20:29
  */
object FilterExercise {
  def main(args: Array[String]): Unit = {
    /**
      * 将 val list = List("Alice", "Bob", "Nick") 集合中手指母为'A'的筛选到新的集合
      */
    val list1 = List("Alice", "Bob", "Nick")
    var res1 = list1.filter(x => x.toCharArray.apply(0) == 'A')
    var res11 = list1.filter(x => x.startsWith("A")) // 和上边的是等价的. 新的API
    println(res1)
  }
}
