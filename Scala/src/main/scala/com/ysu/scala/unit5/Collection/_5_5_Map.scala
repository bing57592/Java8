package com.ysu.scala.unit5.Collection

import scala.collection.mutable

/**
  *
  * created by bing57592     
  * 2018-09-10 01:12
  */
object _5_5_Map {
  def main(args: Array[String]): Unit = {
    var map1 = Map("k1" -> 16, "k2" -> 25 , "k1" -> 11) //这是一个不可变集合
    println(map1)
    var map2 = mutable.Map

    // 与map1不同, ("k1",11)不是集合, 而是元祖(虽然不知道两者到底有没有区别)
    var map3 = mutable.Map(("k1", 11), ("k2", 22))
    println("------------------------------------")

    // 取值
    println(map3.get("k1"))
    println(map3("k1"))
    println("------------------------------------")

    // 赋值
    map3("k1") = 22
    println(map3("k1"))

    // 追加 +=
    map3 += ("k1" -> 99);
    println(map3)

    // 删除 -=
    map3 -= ("k1")
    println(map3)
    println("------------------------------------")

    // 追加+ (和追加 += 没啥区别啊)
    var map4 = Map("k11" -> 22, "k33" -> 44)
    var map3_4 = map3 + ("k1" -> 1234); // 这个, map3有"+"的方法, 而("k1"->1234)没有这个方法
    println(map3_4)
    println("------------------------------------") // 遍历
    for (i <- map3_4) {
      println(i._1)
    }
  }
}
