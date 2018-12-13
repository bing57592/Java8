package com.ysu.scala.unit8

/**
  * 类型匹配
  * 可以匹配对象的任意类型, 避免使用isInstanceOf 和 asInstanceOf方法
  * 注意事项:
  * 1. Map[String, Int] 和 Map[Int, String]是两种不同的类型, 其他类推.
  * 2. 在进行类型匹配时, 编译器会预先检测是否有可能的匹配, 如果没有则报错.
  * 3. case a : Int 表示 a = obj. (line_29)
  * 4. 如果case _ 出现在match中间, 则表示隐藏变量名, 即不使用, 而不是表示默认匹配.
  *
  * @Author bing57592 
  * @Date 2018-12-11 00:52
  */
object TypeMatch {
    def main(args: Array[String]): Unit = {
        var a = 7
        for (i <- 1 to 8) {
            a = i
            val obj =
                if (a == 1) 1
                else if (a == 2) "2"
                else if (a == 3) BigInt(3)
                else if (a == 4) Map("aa" -> 1)
                else if (a == 5) Map(1 -> "aa")
                else if (a == 6) Array(1, 2, 3)
                else if (a == 7) Array("aa", 1)
                else if (a == 8) Array("aa")
            var result = obj match {
                case a: Int => a
                case b: Map[String, Int] => "对象是一个[String, Int]的Map集合"
                case c: Map[Int, String] => "对象是一个[Int, String]的Map集合"
                case d: Array[String] => "对象是一个字符串数组Array[String]"
                case e: Array[Int] => "对象是一个数字数组Array[Int]"
                case f: BigInt => Int.MaxValue
                case _ => "啥也不是"
            }
            println(i + " : " + result)
        }
    }
}
