package com.ysu.scala.unit5

/**
  * 折叠, 化简, 扫描
  * created by bing57592     
  * 2018-09-10 21:38
  */
object _5_8_Unnamed {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5) //reduce: 聚合
    //reduceLeft: 从左往右聚合
    val list1_1 = list1.reduceLeft(_ - _); // 这个叫化简
    // 这个函数的结果, 会传递到第一个参数上
    var list1_2 = list1.reduceLeft((x, y) => x - y) // 同list1_1
    println(list1_1)
    println(list1_2)

    //reduceRight: 从右往左聚合
    val i2 = list1.reduceRight(_ - _) // 从右往左操作
    println(list1_1)
    println(i2)


    println("------------------------------------")

    // 折叠 化简 flod
    // fold函数将上一步返回的值作为函数的第一个参数继续传递参与运算，直到list中的所有元素被遍历。
    // 可以把reduceLeft看做简化版的foldLeft。相关函数：fold，foldLeft，foldRight，可以参考reduce的相关方法理解。
    val list4 = List(1, 9, 2, 8)
    val result4 = list4.fold(5)((sum, y) => sum + y) // 5 + 1 + 9 + 2 + 8 (5指的是初始值); 当初始值是0时, 使用reduceLeft
    println(result4)


    println("------------------------------------")
    //
    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
    //m +  (“一” -> 1, “首” -> 1, “哈” -> 1)
    val i7 = (Map[Char, Int]() /: sentence) ((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))
    println(i7)

    println("------------------------------------")
    var result9 = (1 to 10).scanLeft(0)(_ + _)
    println(result9)

  }
}
