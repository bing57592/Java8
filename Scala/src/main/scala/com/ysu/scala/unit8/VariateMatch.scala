package com.ysu.scala.unit8

/**
  * 模式匹配中变量
  * 如果在case 关键字后跟变量名, 那么match前表达式的值会赋给那个变量
  *
  * @Author bing57592 
  * @Date 2018-12-11 00:48
  */
object VariateMatch {
    def main(args: Array[String]): Unit = {
        val ch = 'V'
        ch match {
            case '+' => println("OK +")
            case mychar => println("OK " + mychar) // 如果走了变量, 相当于已经匹配成功.
            case _ => println("OK _")
        }
    }
}
