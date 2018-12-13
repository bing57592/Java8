package com.ysu.scala.unit7.map

import scala.collection.mutable

/**
  *
  *
  * @Author bing57592 
  * @Date 2018-12-08 03:48
  */
object Main {
  def main(args: Array[String]): Unit = {

  }

  /**
    * 关于集合的遍历.
    */
  private def method4 = {
    var map = mutable.Map(("A", 1), ("B", 2), ("C", 3))

    /**
      * 每遍历一次, 返回的元素是Tuple2
      * 取出的时候, 按照元组的方式来取
      */
    for (elem <- map) {
      println("key = " + elem._1 + ", value = " + elem._2)
    }
  }

  /**
    * 关于集合的增加, 修改和删除操作
    */
  private def method3 = {
    var map = mutable.Map(("A", 1), ("B", 2), ("C", 3))
    /**
      * map 是可变的, 才能修改, 否则报错
      * 如果key 存在: 则修改对应的值, key 不存在, 等价于添加一个key-value
      */
    var map1 = map
    map1("A") = 20
    println(map1)

    /**
      * 添加单个元素
      */
    var map2 = map1
    map2 += ("D" -> 4)
    map2 += ("D" -> 2) // 如果已经存在key, 则覆盖.
    println(map2)

    /**
      * 添加多个元素
      */
    var map3 = map2
    map3 += ("X" -> 24, "Y" -> 25, "Z" -> 26)
    println(map3)

    /**
      * 删除元素(一个或多个)
      * "A", "X", "Z", "H" 就是要删除的key
      * 如果key 存在, 就删除, 如果ke不存在, 也不会报错.
      */
    var map4 = map3 - ("A", "X", "Z", "H")
    println(map4)
  }

  /**
    * 关于map获取元素.
    */
  private def method2 = {
    /**
      * 使用map(key)
      * 1. 如果key 存在, 则返回对应的值
      * 2. 如果key 不存在, 则抛出异常
      * 3. 在Java中, 如果key 不存在, 则返回null
      */
    val map1 = Map("Alice" -> 10, "Bob" -> 19, "Chandler" -> 25)
    println(map1("Alice")) // println(map1("Nil")) key not found: Nil
    /**
      * 使用contain方法判断是否存在key, 然后取值
      */
    var map2 = map1
    println(map2.contains("Alice"))

    /**
      * 使用map.get(key).get取值
      * 通过map.get(key)这样的调用返回一个Option对象, 要么是some, 要么是None
      * 1. map.get 方法会将数据进行包装
      * 2. 如果map.get(key) key存在则返回some, 如果key 不存在则返回None
      * 3. 如果map.get(key).get key存在, 返回key 对应的值. 否则, 抛出异常NoSuchElementException
      *
      */
    var map3 = map2
    println(map3.get("Alice"))
    println(map3.get("Alice").get)
    println(map3.get("Fuck U"))

    /**
      * 使用map.getOrElse()取值
      * 如果key存在, 返回key对应的值
      * 如果key不存在, 返回默认值. java中底层有很多类似的操作
      */
    var map4 = map3
    println(map4.getOrElse("Jackson", 1234)) // Jackson: key, 1234: 默认值
  }

  /**
    * 创建一个Map的方式(有如下四种)
    */
  private def method1 = {
    /**
      * 构造不可变映射
      * 1. 从输出结果看到, 输出的顺序和声明的顺序一致
      * 2. 构建Map集合中, 集合中的元素其实是Tuple2 类型
      * 3. 默认情况下(即没有引入其他包的情况下), Map是不可变map
      */
    val map1 = Map("Alice" -> 10, "Bob" -> 19, "Chandler" -> 25)
    for (elem <- map1) {
      println(elem._1)
    }
    /**
      * 构造可变映射
      * 1. 从输出结果看到, 输出的顺序和声明的顺序不一致
      */
    val map2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 19, "Chandler" -> 25)
    println(map2)

    /**
      * 构造一个空的可变映射
      */
    val map3 = new mutable.HashMap[String, Any]()
    println(map3)

    /**
      * 通过对偶元组的方式构造("Alice", 123)这种形式. 和方式一类似
      * 对偶元组: 值含有两个数据的元组
      */
    val map4 = Map(("Alice", 123), ("Bob", 222), ("Tomson", 999))
    println(map4)
  }
}
