package com.ysu.scala.unit2

/**
  * 变量声明的基本语法: var | val 变量名 [:变量类型] = 变量值  var: 可变变量, val: 不可变变量
  * 1) 声明变量时，类型可以省略（编译器自动推导,即类型推导.
  * 2) 类型确定后，就不能修改，说明Scala 是强数据类型语言.
  * 3) 在声明/定义一个变量时，可以使用var 或者 val 来修饰， var 修饰的变量可改变，val 修饰的变量不可改 [案例].
  * 4) val修饰的变量在编译后，等同于加上final通过反编译看下底层代码
  *
  * @Author bing57592
  * @Date 2018-12-05 21:05
  */
object Main {
  def main(args: Array[String]): Unit = {
    var a = 10;
    a += 2;
    println(a)


  }
}
