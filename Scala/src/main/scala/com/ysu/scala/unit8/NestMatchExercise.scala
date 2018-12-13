package com.ysu.scala.unit8

/**
  * 1. 商品捆绑可以是单个商品, 也可以是多个商品.
  * 2. 打折时按照折扣xx元进行设计.
  * 3. 能够统计出所有捆绑商品打折后的最终价格.
  *
  * @Author bing57592 
  * @Date 2018-12-12 14:16
  */
object NestMatchExercise {

    def main(args: Array[String]): Unit = {
        val sale = Bundle("书籍", 10,
            Book("漫画", 40),
            Bundle("文学作品", 20,
                Book("《阳关》", 80),
                Book("《围城》", 30)))

        val res = price(sale)
        println(res)
    }

    def price(it: Item): Double = {
        it match {
            case Book(_, p) => p
            //生成一个新的集合,_是将its中每个循环的元素传递到price中it中。递归操作,分析一个简单的流程
            case Bundle(_, disc, its@_*) => its.map(price _).sum - disc
        }
    }

    // 创建样例类:
    abstract class Item

    case class Book(description: String, price: Double) extends Item

    case class Bundle(description: String, discount: Double, item: Item*) extends Item

}
