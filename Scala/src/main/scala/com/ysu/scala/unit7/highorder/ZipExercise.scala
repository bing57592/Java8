package com.ysu.scala.unit7.highorder

/**
  * 拉链
  * 在开发中, 我们需要将两个集合进行对偶元组合并, 可以使用拉链.
  * 注意事项:
  * 1. 拉链的本质就是两个集合的合并操作, 合并后的每个元素是一个对偶元组.
  * 2. 如果两个集合个数不对应, 会造成数据丢失.
  * 3. 集合不限于List, 也可以是其他集合比如Array
  * 4. 如果要取出合并后的各个丢欧元组的数据, 可以遍历. (按元组的方式)
  *
  * @Author bing57592 
  * @Date 2018-12-09 18:36
  */
object ZipExercise {
  def main(args: Array[String]): Unit = {
    var list1 = List(1, 2, 3)
    var list2 = List(4, 5, 6)
    var list3 = list1.zip(list2)
    println(list3)

    for (elem <- list3) {
      println(elem._1 + "__" + elem._2)
    }
  }
}
