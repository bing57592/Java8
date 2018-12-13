package com.ysu.scala.unit7.list

/**
  * 列表List-创建List
  * Scala中list和Java List不一样, 在Java中List 是一个接口, 真正存放数据的是ArrayList, 而Scala 的
  * List 可以直接存放数据, 就是一个object, 默认情况下ZScala的List是不可变的.
  *  1. List 默认为不可变的集合说明
  *  2. List 在Scala 包对象声明的, 因此不需要引入其他包也可以使用
  *  3. val List = scala.collection.immutable.List
  *  4. List 中可以放任何数据类型, 比如array1 的类型为List[Any]
  *  5. 如果希望得到一个空列表, 可以使用Nil对象, 在Scala包对象声明的, 因此不需要引入其他包.
  *
  * @Author bing57592 
  * @Date 2018-12-08 02:54
  */
object Main {
  def main(args: Array[String]): Unit = {
    method2
  }

  /**
    * 向列表中增加元素, 会返回新的列表/集合对象.
    * 注意: Scala中List元素的追加形式非常独特, 和Java不一样
    * :+ 和 +: 这两者, ':'靠近集合那一侧
    * :: 表示向集合中新建集合添加元素. 运算时从右到左. 右边的作为集合, 将其左边作为元素就让到右边集合中
    * ---所以, 最右边的元素必须是一个集合, 而44 :: 55 :: 66 这种操作是错误的.
    */
  private def method2: Unit = {
    var list1 = List(1, 2, 3, "4", 5)
    println(list1)

    // :+ 运算符表示在列表的 最后面 增加数据.
    var list2 = list1 :+ "hello"
    println(list2)

    // +: 运算符表示在列表的 最前面 增加数据
    var list3 = "fuck" +: list2
    println(list3)

    // ::
    var list4 = 4 :: 5 :: 6 :: list3
    println(list4)

    // ::
    var list5 = 55 :: list4 :: 57 :: 59 :: Nil
    println(list5)

    // ::: 目前看到, 可以编译通过的语法, 是 list5:::Nil
    var list6 = 4 :: 5 :: 6 :: list5 ::: Nil
    println(list6)

  }

  private def method1 = {
    val list1 = List(1, 2, 3, 4, 5)
    println(list1)
    // 在package.scala 中对Nil有声明, 声明Nil为一个空集合(而不是null)
    val list2 = Nil
    println(list2)
  }


}
