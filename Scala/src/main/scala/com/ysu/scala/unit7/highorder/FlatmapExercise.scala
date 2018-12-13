package com.ysu.scala.unit7.highorder

/**
  * Flatmap映射: flat即压扁, 压平, 扁平化映射.
  * flatmap: flat即压扁, 压平, 扁平化, 效果就是讲集合中的每个元素的子元素映射到某个函数并返回新的集合
  *
  * @Author bing57592 
  * @Date 2018-12-08 20:18
  */
object FlatmapExercise {
  def main(args: Array[String]): Unit = {
    var list1 = List("AC", "B", "C")
    var res1 = list1.flatMap(x => x)
    println(res1)

    val list2 = List("Alice", "Bob", "Nick")
    var res2 = list2.flatMap(x => x.toUpperCase) // x是 A l i c e... 然后再upper
    println(res2)
  }

}
