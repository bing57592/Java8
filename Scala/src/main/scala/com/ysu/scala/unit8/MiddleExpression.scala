package com.ysu.scala.unit8

/**
  * case语句中的中置表达式:
  * 基本介绍
  * 什么是中置表达式? 1 + 2, 这就是个中置表达式. 如果unapply方法产出一个元组, 则可以在case语句中
  * 使用中置表达式 param1 :: param2 的方式, 匹配一个List的序列.
  *
  * @Author bing57592 
  * @Date 2018-12-11 21:53
  */
object MiddleExpression {
    def main(args: Array[String]): Unit = {
        List(1, 3, 5, 9) match {
            //修改并测试
            //1.两个元素间::叫中置表达式,至少first，second两个匹配才行.
            //2.first 匹配第一个 second 匹配第二个, rest 匹配剩余部分(5,9)
            // first :: second 只是其中一种方式
            case first :: second :: rest => {
                println(first + ":" + second + ":" + rest.length) // 1:3:2
            } //
            case _ => println("匹配不到...")
        }
    }
}
