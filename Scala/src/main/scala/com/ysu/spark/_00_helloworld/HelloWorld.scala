package com.ysu.spark._00_helloworld

/**
  * Scala执行流程:
  * 1. object 底层会生成两个类, Hello, Hello$
  * 2. Hello 中有个main函数, 调用Hello$类的一个静态方法, MODULE$
  * 3. Hello$.MODULE$ 对象是静态的, 通过调用该对象来调用Hello$的主函数.
  * 4. 可以理解在main中写的代码, 放在Hello$ 的main, 在底层Scala编译器做了一个包装.
  *
  * @Author bing57592
  * @Date 2018-12-04 01:05
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello world!")
  }
}
