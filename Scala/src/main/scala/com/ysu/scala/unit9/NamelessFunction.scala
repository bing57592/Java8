package com.ysu.scala.unit9

/**
  * 匿名函数
  * 没有名字的函数就是匿名函数, 可以通过函数表达式来设置匿名函数
  *
  * @Author bing57592 
  * @Date 2018-12-13 12:51
  */
object NamelessFunction {
    def main(args: Array[String]): Unit = {
        var res1 = (n1: Int, n2: Int) => {
            n1 + n2
        }

        def f(n1: Int, n2: Int) = {
            n1 + n2
        }

        var res2 = f(1, 2)
        println(res1)
        println(res2)
    }
}
