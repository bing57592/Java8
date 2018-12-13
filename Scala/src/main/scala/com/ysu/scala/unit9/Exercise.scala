package com.ysu.scala.unit9

/**
  *
  * @Author bing57592 
  * @Date 2018-12-13 12:49
  */
object Exercise {
    def main(args: Array[String]): Unit = {
        def test1(x: Double) = {
            (y: Double) => x * x * y
        }

        val res = test1(2)(3)
    }

    def method2: Unit = {

    }

    /**
      * 编写一个匿名函数, 可以返回2个整数的和, 并输出该匿名函数的类型.
      */
    def method1: Unit = {
        var res = (n1: Int, n2: Int) => {

        }

        var res1 = res(10, 20)

        println(res1)

        val function = () => {
            println(123)
        }
        println(function)
    }

}
