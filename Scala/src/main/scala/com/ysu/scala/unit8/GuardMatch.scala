package com.ysu.scala.unit8

/**
  * 守卫
  * 如果想要表达 匹配某个范围的数据, 就需要在模式匹配中增加条件守卫
  *
  * @Author bing57592 
  * @Date 2018-12-11 00:38
  */
object GuardMatch {
    def main(args: Array[String]): Unit = {

    }

    //    + 1 0
    //    - -1 0
    //    3 0 3
    //    ! 0 3
    private def method2 = {
        for (ch <- "+-3!") {
            var sign = 0
            var digit = 0
            ch match {
                case '+' => sign = 1
                case '-' => sign = -1
                case _ => digit = 3
                case _ => sign = 2
            }

            println(ch + " " + sign + " " + digit)
        }
    }

    //    + 1 0
    //    - 1 0
    //    3 0 3
    //    ! 2 0
    private def method1 = {
        for (ch <- "+-3!") {
            var sign = 0
            var digit = 0
            ch match {
                case '+' => sign = 1
                case '-' => sign = 1
                case _ if ch.toString.equals("3") => digit = 3 // 这个if 就是个守卫
                case _ => sign = 2
            }
            println(ch + " " + sign + " " + digit)
        }
    }
}
