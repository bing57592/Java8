package com.ysu.scala.unit7.highorder

/**
  * 流-stream
  * stream 是一个集合. 这个集合, 可以用于存放无穷多个元素, 但是这无穷多个元素并不会一次性生产出来,
  * 而是需要用到多大的空间, 就会动态的生产, 莫为元素遵循lazy规则(即: 要使用结果才可以进行计算的)
  * tail:
  * 使用tail, 会动态的向stream集合按规则生成新的元素
  * 注意:
  * 如果使用流集合, 就不能使用last属性. 因为如果使用last集合就会进行无限循环
  *
  * @Author bing57592 
  * @Date 2018-12-09 20:22
  */
object StreamExercise {
  def main(args: Array[String]): Unit = {
    val res = numsForm(5).map(multi)
    println(res)
  }

  def multi(x: BigInt): BigInt = {
    x * x
  }


  private def method1 = {
    // 创建stream
    var stream1 = numsForm(1)
    println(stream1)

    // 取出第一个元素
    println(stream1.head)
    println(stream1.tail)
    println(stream1)
    println(stream1.last)
  }

  /**
    * 说明:
    * 1. Stream 集合存放的数据类型是BigInt
    * 2. numsForm 是自定义的一个函数, 函数名是程序员指定的.
    * 3. 创建的集合的第一个元素是n, 后续元素生成的规则是 n + 1
    * 4. 后续元素生成的规则是可以程序员指定的, 比如numsForm(n * 4)...
    *
    * @param n
    * @return
    */
  def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)
}
