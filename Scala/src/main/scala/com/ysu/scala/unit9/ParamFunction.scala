package com.ysu.scala.unit9

/**
  * 作为参数的函数:
  * 函数作为一个变量传入了另一个函数中
  *
  * 总结:
  * 1. map(plus(_))中的plus(_)就是将plus这个函数作为一个参数传给了map, _这里代表从集合中遍历出来的
  * ---一个元素.
  * 2. plus(_)这里也可以写成plus表示对Array(1, 2, 3, 4)遍历, 将每次遍历的元素传给plus的x
  * 3. 进行 3 + x 运算后, 返回新的Int, 并加入到新的集合中
  * 4. def map[B, That](f: A => B)的声明中的 f: A => B 是一个函数.
  *
  * @Author bing57592 
  * @Date 2018-12-13 12:41
  */
object ParamFunction {
    def main(args: Array[String]): Unit = {
        val res = Array(1, 2, 3, 4).map(plus(_))
        println(res.mkString(", "))
    }

    def plus(x: Int) = 3 + x

}
