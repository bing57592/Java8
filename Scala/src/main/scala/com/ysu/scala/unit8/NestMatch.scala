package com.ysu.scala.unit8

/**
  * 匹配嵌套结构:
  * 操作原理类似于正则表达式:
  * 最佳实践案例 - 商品捆绑打折出售
  * 现在有一些商品, 使用Scala设计相关的样例类, 完成商品可以捆绑打折出售. 要求:
  *
  * @Author bing57592
  * @Date 2018-12-11 22:02
  */
object NestMatch {
    def main(args: Array[String]): Unit = {
        // 创建样例类:
        abstract class Item
        case class Book(description: String, price: Double) extends Item
        case class Bundle(description: String, discount: Double, item: Item*) extends Item

        val sale = Bundle("书籍", 10,
            Book("漫画", 40),
            Bundle("文学作品", 20,
                Book("《阳关》", 80),
                Book("《围城》", 30)))
    }

    /**
      * 知识点3: 不使用_* 绑定剩余Item 到 rest
      */
    private def method3: Unit = {
        // 创建样例类:
        abstract class Item
        case class Book(description: String, price: Double) extends Item
        case class Bundle(description: String, discount: Double, item: Item*) extends Item

        val sale = Bundle("书籍", 10,
            Book("漫画", 40),
            Bundle("文学作品", 20,
                Book("《阳关》", 80),
                Book("《围城》", 30)))

        val result2 = sale match {
            //说明因为没有使用 _* 即明确说明没有多个Bundle,所以返回的rest，就不是WrappedArray了。
            case Bundle(_, _, art@Book(_, _), rest) => (art, rest)
        }
        println(result2)
        println("art = " + result2._1)
        println("rest = " + result2._2)

    }


    /**
      * 知识点2: 通过@表示法将嵌套的值绑定到变量. _* 绑定剩余Item到rest
      */
    private def method2: Unit = {
        // 创建样例类:
        abstract class Item
        case class Book(description: String, price: Double) extends Item
        case class Bundle(description: String, discount: Double, item: Item*) extends Item

        val sale = Bundle("书籍", 10,
            Book("漫画", 40),
            Bundle("文学作品", 20,
                Book("《阳关》", 80),
                Book("《围城》", 30)))

        val result2 = sale match {
            case Bundle(_, _, art@Book(_, _), rest@_*) => (art, rest)
        }
        println(result2)
        println("art = " + result2._1)
        println("rest= " + result2._2)
    }

    /**
      * 知识点1: 将descr绑定到第一个Article的描述
      */
    private def method1: Unit = {
        // 创建样例类:
        abstract class Item
        case class Book(description: String, price: Double) extends Item
        case class Bundle(description: String, discount: Double, item: Item*) extends Item
        /**
          * 说明:
          * 1. sale就是一捆商品(书)
          * 2. 该捆包含的商品有Book("漫画", 40),
          * ---Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
          */
        val sale =
            Bundle("书籍", 10,
                Book("漫画", 40),
                Bundle("文学作品", 20,
                    Book("《阳关》", 80),
                    Book("《围城》", 30)))
        val res = sale match {
            // 如果我们进行对象匹配时, 不想接受某些值, 则使用_忽略即可.  _* 表示忽略所有.
            case Bundle(_, _, Book(desc, price), _*) => (desc, price)
        }
        println(res._1)
    }
}
