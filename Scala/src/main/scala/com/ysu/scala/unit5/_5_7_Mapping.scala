package com.ysu.scala.unit5

/**
  * 集合元素和函数的映射关系
  * Function & Element
  * created by bing57592
  * 2018-09-10 21:13
  */
object _5_7_Mapping {
  def main(args: Array[String]): Unit = {
    var list1 = List(1, 2, 1, 2, 3, 1, 4, 5);
    list1.foreach(println(_)) //将list中的元素映射到某一个函数(println这个函数)
    println("------------------------------------")

    //将集合内的所有单词转换为小写
    var list2 = List("ALIENCE", "NEWBEE", "WINGS", "LGD", "LEQUID", "ATGUIGU")
    // map：将集合中的每一个元素映射到某一个函数
    // map: 将集合中的元素全部转换成了小写
    var list2_1 = list2.map(x => x.toLowerCase())
    var list2_2 = list2.foreach(x => x.toLowerCase()) // 用foreach, 不知道和map有啥区别, 反正这个没能实现功能, 返回一个();
    println(list2)
    println(list2_1)
    println(list2_2)

    println("------------------------------------")

    //flatmap：flat即压扁，压平，扁平化，效果就是将集合中的每个元素的子元素映射到某个函数并返回新的集合
    val list3 = List("Alice", "Bob", "Nick")
    println(list3.flatMap(_.toUpperCase()))//将list3压扁, 压到最根本的情况

  }
}
