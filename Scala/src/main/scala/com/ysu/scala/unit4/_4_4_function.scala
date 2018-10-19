package com.ysu.scala.unit4

/**
  * 重中之重
  * created by bing57592
  * 2018-09-09 22:59
  */
object _4_4_function {
  def main(args: Array[String]): Unit = {
    var p4 = 10;
    def p5 = 10;
    println(p4)
    println(p5)
    println("----------------------------------------")
    var p7 = (int: Int, int2: Int) => {}

    def p8 = () => {}

    println(p7)
    println(p8)
  }

  //def 函数名(参数名1: 参数类型1, 参数名2: 参数类型2) : 返回类型 = {函数体}
  def function1(pageIndex: Int, pageSize: Int): Unit = {
    //我只会这个就行了. (此处三个感叹号)
    return // 指明返回值类型时, 才可以return
  }

  def function2(a: Int, b: String) = {

  }

  // 和function1的区别: 这样定义, 着重强调的是过程(强调NMB啊强调)
  def function3(a: Int, b: String) {
    println()
  }

  // 变长参数, 类似(Object obj...)
  def function5(int: Int*): Unit = {

  }
}
