package com.ysu.scala.unit5

/**
  *
  * created by bing57592     
  * 2018-09-10 00:42
  */
object _5_3_List {
  def main(args: Array[String]): Unit = {
    var list = Nil;
    // 创建
    var list1 = List(1, 2, 3) // 访问
    println(list1(0))

    // 删除 -> 不能删除
    // 追加 同Array一样
    // 遍历 同Array一样 (不需要mkString(", "))
    // 集合的追加
    var list2_1 = List(1, 2, 3)
    var list2_2 = List(4, 5, 6)

    // :: 追加符号, 将集合追加到最后一个集合中. 所以当最后一个是nil的时候, 其他集合就是并列的关系.
    var list2_3 = list2_1 :: list2_2
    println(list2_3)
    println("----------------------------------------")

    // ::: 追加符号, 将集合内的元素追加到一个集合中
    var list3_1 = List(1, 11, 111)
    var list3_2 = List(2, 2, 22)
    var list3 = list3_1 ::: list3_2
    println(list3)
  }
}
