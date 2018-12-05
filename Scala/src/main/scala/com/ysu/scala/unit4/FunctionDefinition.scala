package com.ysu.scala.unit4

/**
  * 定义函数的方式
  *
  * @Author bing57592 
  * @Date 2018-12-05 22:24
  */
object FunctionDefinition {
  def main(args: Array[String]): Unit = {
  }



  /**
    * 编写一个函数/方法.
    */
  def getResult(n1: Int, n2: Int, oper: Char) = {
    var res = 0;
    if (oper == '+') {
      n1 + n2
    } else if (oper == '-') {
      n1 - n2
    } else {
      null
    }
  }

  /**
    * def 函数名 (参数名1: 参数类型1, 参数名2: 参数类型2) [: 返回值类型] = {函数语句}
    * 1. 函数声明的关键字为def
    * 2. 参数列表用逗号隔开.
    * 3. 函数中的语句: 表示为了实现某一功能的代码块
    * 4. 函数可以有返回值, 也可以没有.
    * 5. 返回值形式1:  [() :返回值类型 = {}]   正常返回.
    * 6. 返回值形式2:  [() = {}]              表示返回值类型不确定, 使用类型推导完成.(最常用)
    * 7. 返回值形式3:  [() {}]                表示没有返回值, return不生效.
    **/
  def baseDefinition(v1: Int, v2: Double): Unit = {

  }

  def demo1: Unit = {
    // 输入两个数, 输入一个运算符, 得到结果
    var v1 = 10
    var v2 = 20
    var oper = "+"
    var res = 0
    if (oper == "+") {
      res = v1 + v2
    }
    if (oper == "-") {
      res = v1 - v2
    }
    println(res)
  }

}
