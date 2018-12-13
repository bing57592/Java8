package com.ysu.scala.unit9

/**
  * 高阶函数:
  * 能够接受函数作为参数的函数, 叫做高阶函数, 可以使程序更加健壮
  *
  * 高阶函数小结: def minusxy(x: Int) = (y: Int) => x - y
  * 1. 函数名为 minusxy
  * 2. 该函数返回一个匿名函数 (y: Int) => x - y
  *
  * @Author bing57592 
  * @Date 2018-12-13 12:57
  */
object HigherOrderFunction {
    def main(args: Array[String]): Unit = {
        //        val res = test(_ * 2, 123)
        //        println(res)

        /**
          * 先返回 var func1 = (y: Int) => 3 - y
          * 然后   func1(5), 返回 3 - 5 = -2
          */
        val res = minusxy(3)(5)

        println(res)
    }


    /**
      * 这个函数返回的类型是一个函数
      */
    def minusxy(x: Int) = {
        (y: Int) => x - y
    }

    def test(f: Double => Double, n1: Double) = {
        f(n1)
    }
}
