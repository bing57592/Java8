package com.ysu.scala.unit3

/**
  * 循环条件 - while循环控制
  * 1. 循环条件是返回一个布尔值的表达式
  * 2. while循环是先判断再执行语句
  * 3. 与if不同, while本身没有值, 即整个while语句的结果是Unit类型的()
  * 4. 因为while中没有返回值, 所以当要用该语句并计算返回结果时, 就不可避免使用变量, 而变量需要声明在
  * ---while循环的内部, 那么就等同于循环的内部对外部的变量造成了影响, 也就违背了函数式编程的重要思想
  * ---(纯函数思想), 所以不推荐使用, 而推荐使用for循环
  *
  * 循环条件 - do while循环控制
  * 1. 不推荐使用, 而推荐使用for循环
  * @Author bing57592 
  * @Date 2018-12-05 21:53
  */
object Loop2_while {
  def main(args: Array[String]): Unit = {
    var i = 1;
    do {
      if (i % 3 == 0) print(i + "\t")
      i += 1
    } while (i <= 100)
  }
}
