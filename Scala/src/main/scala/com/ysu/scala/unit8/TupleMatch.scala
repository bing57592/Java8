package com.ysu.scala.unit8

/**
  * 匹配元组
  *
  * @Author bing57592 
  * @Date 2018-12-11 01:22
  */
object TupleMatch {
    def main(args: Array[String]): Unit = {
        for (pair <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2))) {
            val result = pair match { //
                case (0, _) => "0 ..." //
                case (y, 0) => y //
                case _ => "other" //.
            }
            println(result)
        }

    }
}
