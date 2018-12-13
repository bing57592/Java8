package com.ysu.scala.unit8

/**
  * 对象匹配
  * 对象匹配规则如下:
  * 1. case对象中的unapply方法(提取器)返回some集合则为匹配成功.
  * 2. 返回none集合则为匹配失败.
  *
  * @Author bing57592 
  * @Date 2018-12-11 01:23
  */
object ObjectMatch {
    def main(args: Array[String]): Unit = {
    }

    /**
      * 案例2 的小结
      * 1. 当case 后面的对象提取器方法的参数为多个, 则会默认调用def unapplySeq()方法
      * 2. 如果unapplySeq 返回的是Some, 则匹配成功. (针对这道题, 判断元素的个数为三个, 如果是三个
      * ---则吧三个元素分别取出, 赋值给first, second, third.
      * 3. 其他规则不变.
      */
    private def method2 = {
        object Names {
            def unapplySeq(str: String): Option[Seq[String]] = {
                if (str.contains(",")) Some(str.split(","))
                else None
            }
        }
        val namesString = "Alice,Bob,Thomas"
        //说明
        namesString match {
            case Names(first, second, third) => {
                println("the string contains three people's names")
                // 打印字符串
                println(s"$first $second $third")
            }
            case _ => println("nothing matched")
        }

    }

    /**
      * 对象匹配总结:(对象匹配, 匹配的是unapply方法)
      * 1. 构建对象时, apply会被调用, 比如 val n1 = Square(5)
      * 2. 当将Square(n)写在 case 后时[case Square(n) => xxx], 会默认调用unapply方法(对象提取器)
      * 3. number会被传递给 def unapply(z: Double)的 z 的形参.
      * 4. 如果返回的是Some集合, 则unapply提取器返回的结果会返回给 n 个这个形参.
      * 5. case 中对象的unapply方法(提取器)返回some集合则匹配成功.
      * 6. 返回none集合则匹配失败.
      */
    private def method1 = {
        object Square {
            def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

            def apply(z: Double): Double = z * z
        }

        // 模式匹配使用：
        for (item <- List(36.0, "36")) {
            item match {
                case Square(n) => println(n)
                case _ => println("nothing matched")
            }
        }

    }
}
