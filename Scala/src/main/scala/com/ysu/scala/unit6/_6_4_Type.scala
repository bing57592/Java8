package com.ysu.scala.unit6

/**
  * 模式匹配 => 类型模式
  *
  * created by bing57592     
  * 2018-09-11 12:48
  */
object _6_4_Type {
  def main(args: Array[String]): Unit = {
    val a = 5
    val obj = if(a == 1) 1
    else if(a == 2) "2"
    else if(a == 3) BigInt(3)
    else if(a == 4) Map("aa" -> 1)
    else if(a == 5) Map(1 -> "aa")
    else if(a == 6) Array(1, 2, 3)
    else if(a == 7) Array("aa", 1)
    else if(a == 8) Array("aa")

    // 类型匹配前边必须加形参 m : Map[String, Int]. 值匹配不需要
    val r1 = obj match {
      case x: Int => x
      case s: String => s.toInt
      case BigInt => -1 //不能这么匹配
      case _: BigInt => Int.MaxValue
      case m: Map[String, Int] => "Map[String, Int]类型的Map集合" //在这里, 会将泛型擦除, 实际生效的是: Map[_, _]
      case m: Map[_, _] => "Map集合"
      case a: Array[Int] => "It's an Array[Int]" //在这里, 泛型没被擦除, 因为在java中, 这不是泛型, 而是int型数组.
      case a: Array[String] => "It's an Array[String]"
      case a: Array[_] => "It's an array of something other than Int"
      case _ => 0
    }
    println(r1 + ", " + r1.getClass.getName)

  }
}
