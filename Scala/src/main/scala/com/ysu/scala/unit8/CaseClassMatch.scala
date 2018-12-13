package com.ysu.scala.unit8

/**
  * 样例类:
  * case类在模式匹配和actor中经常使用到, 当一个类被定义成case类后, Scala会自动创建一个伴生对象
  * 并实现一系列方法. 如下:
  * 1. 实现了apply方法, 意味着不需要使用new 关键字就能创建该类对象.
  * 2. 实现了unapply方法, 可以通过模式匹配来获取类属性, 是Scala中抽取器的实现和模式匹配的关键方法
  * 3. 实现了类构造器的getter方法(构造参数默认声明为val), 但是当构造参数是var类型时, 会同时实现
  * ---getter()方法和setter()方法.
  * 4. 默认实现了toString()方法, equals()方法, hashCode()方法
  *
  * 样例类中的copy方法和带名参数:
  * 1. copy创建一个与现有对象属性相同的新对象. 并且可以通过带名参数来修改某些属性.
  *
  * 说明: 这里的 Dollar，Currencry, NoAmount  是样例类。
  *
  * @Author bing57592
  * @Date 2018-12-11 01:53
  */
object CaseClassMatch {
    def main(args: Array[String]): Unit = {
        method1
    }

    private def method1 = {

        abstract class Amount

        case class Dollar(value: Double)
        case class Currency(value: Double, unit: String) extends Amount
        case object NoAmount extends Amount

        var v1 = Dollar(1000.0)
        var v2 = Currency(1000, "RMB")
        var v3 = NoAmount

//          // 这里不带for循环, 报错.
//          val result = v1 match {
//              //说明
//              case Dollar(v) => "$" + v
//              //说明
//              case Currency(v, u) => v + " " + u
//              case NoAmount => ""
//          }
//          println(v1 + ": " + result)

        // 这里为什么, 带for循环就能正常化运行, 如果不带for循环, 会编译出错, 为啥呢?
        for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
            val result = amt match {
                /**
                  * 说明:
                  * 1. 这里会出发Dollar对象的unapply()方法.
                  * 2. 将amt传给unapply()方法, 返回一个some或者None
                  * 3. 返回的结果会赋值给v
                  */
                case Dollar(v) => "$" + v
                //说明
                case Currency(v, u) => v + " " + u
                case NoAmount => ""
            }
            println(amt + ": " + result)
        }
    }

    private def method2 = {

        abstract class Amount

        case class Dollar(value: Double)
        case class Currency(value: Double, unit: String) extends Amount
        case object NoAmount extends Amount

        val amt = Currency(29.95, "RMB")
        val amt1 = amt.copy() //创建了一个新的对象，但是属性值一样
        val amt2 = amt.copy(value = 19.95) //创建了一个新对象，但是修改了货币数量
        val amt3 = amt.copy(unit = "英镑")//创建一个新对象, 修改了货币单位
        println(amt)
        println(amt2)
        println(amt3)

    }

}
