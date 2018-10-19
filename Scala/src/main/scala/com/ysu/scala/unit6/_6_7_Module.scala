package com.ysu.scala.unit6

/**
  * 变量声明中的模式
  * created by bing57592     
  * 2018-09-11 20:44
  */
object _6_7_Module {
  def main(args: Array[String]): Unit = {
    //match中每一个case都可以单独提取出来，意思是一样的，如下：
    val (x, y) = (1, 2)
    val (q, r) = BigInt(10) /% 3 //q = 10 / 3; r = 10 % 3
    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr
    println(first, second)
    println("------------------------------------------")

    //样例类:
    //1.构造属性默认为val
    //2.自动完成apply 和 unapply
    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "EUR"), Nothing)) {
      val result = amt match {
        case Dollar(v) => "$" + v
        case Currency(_, u) => u
        case Nothing => ""
      }
      println(amt + ": " + result)
    }
    println("------------------------------------------")

    //copy方法和带名参数
    //copy创建一个与现有对象值相同的新对象, 并可以通过带名参数来修改某些属性. 深度拷贝.
    val amt = Currency(29.95, "EUR")
    val price = amt.copy(value = 19.95)
    println(amt)
    println(price)
    println("------------------------------------------")

    //Case语句的中置(缀)表达式
    //什么是中置表达式？1 + 2，这就是一个中置表达式。如果unapply方法产出一个元组，你可以在case语句中使用中置表示法。比如可以匹配一个List序列。
    List(1, 7, 2, 9) match {
      case first :: second :: rest => println(first + second + rest.length) // 1 + 7 + 2
      case _ => 0
    }
    println("------------------------------------------")

    //匹配嵌套结构
    val sale = Bundle("愚人节大甩卖系列", 10, Article("《九阴真经》", 40), Bundle("从出门一条狗到装备全发光的修炼之路系列", 20, Article("《如何快速捡起地上的装备》", 80), Article("《名字起得太长躲在树后容易被地方发现》", 30)))

    //将descr绑定到第一个Article的描述
    val result1 = sale match {
      case Bundle(_, _, Article(descr, _), _*) => descr
    }
    println(result1) //这个秒懂啊
    //通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
    val result2 = sale match {
      // [变量引用]@[变量实体]
      case Bundle(_, _, art@Article(_, _), rest@_*) => println((art, rest))
    }

    //不使用_*绑定剩余Item到rest
    val result3 = sale match {
      case Bundle(_, _, art@Article(_, _), rest) => println((art, rest))
    }
    println(result3)
    println("------------------------------------------")


    //偏函数: 它只对会作用于指定类型的参数或指定范围值的参数实施计算
    val f: PartialFunction[Char, Int] = {
      case '+' => 1
      case '-' => -1
    }
    println(f('-'))
    println(f.isDefinedAt('0')) //f.isDefinedAt('0') ==> 判断函数是否有能力处理'0'
    if (f.isDefinedAt('0')) {
      println(f('0'))
    }
    println(f('+')) //    println(f('0'))
    println("------------------------------------------")


    // 偏函数(感觉自己理解得有问题)(或者用case)
    val f1 = new PartialFunction[Any, Int] {
      def apply(any: Any) = any.asInstanceOf[Int] + 1 // 如果偏函数被成功调用, 则会返回这个方法的返回值.

      def isDefinedAt(any: Any) = if (any.isInstanceOf[Int]) true else false // 调用这个方法, 如果为true, 返回apply方法的返回值
    }
    val rf2 = List(1, 3, 5, "seven") collect f1
    println(rf2)


  }
}
