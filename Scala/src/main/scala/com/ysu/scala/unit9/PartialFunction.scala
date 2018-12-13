package com.ysu.scala.unit9

/**
  * 偏函数:
  * 1. 在对符合某个条件, 而不是所有情况进行逻辑操作时, 使用偏函数是一个不错的选择.
  * 2. 将包括在大括号内的一组case语句, 封装为函数, 我们称之为 "偏函数", 它只对会作用于执行类型的参数
  * ---或指定范围值的参数实施计算, 超出范围的值会忽略(未必会忽略, 取决于如何处理)
  * 3. 偏函数在Scala中是一个特质PartialFunction
  *
  * 偏函数总结:
  * 1. 使用构建特质的实现列(使用的方式是PartialFunction的匿名子类)
  * 2. PartialFunction是一个特质
  * 3. 构建偏函数时, 参数形式[Any, Int]是泛型, 第一个表示参数类型, 第二个表示返回类型.
  * 4. 使用偏函数时, 会遍历集合的所有元素, 编译器执行流程时先执行isDefinedAt()
  * ---如果为true, 执行apply方法, 构建一个新的Int对象返回.
  * ---如果为false, 过滤掉这个元素, 不执行apply方法构造新的Int对象.
  * 5. map不支持偏函数, 因为map底层的机制就是循环遍历, 无法过滤处理原来集合的元素.
  * 6. collect 函数支持偏函数.
  *
  * @Author bing57592 
  * @Date 2018-12-12 17:03
  */
object PartialFunction {
    def main(args: Array[String]): Unit = {
        /** 需求: 一个集合, val list = List(1, 2, 3, 4, "abc") 完成如下需求:
          * 1. 将集合list中的所有元素加一, 并返回一个新的集合
          * 2. 要求忽略掉非数字的元素, 即返回的新的集合形式为(2, 3, 4, 5)
          */
        // method1
        // method2

    }

    private def method4: Unit = {
        /**
          * 偏函数的简化形式2
          */
        val list = List(1, 2, 3, 4, "abc")
        val res = list.collect { case i: Int => i + 1 } // 小括号是不可以的.

    }

    private def method3: Unit = {
        /**
          * 偏函数的简化形式1.
          */
        def function: PartialFunction[Any, Int] = {
            case i: Int => i + 1
        }

        val list = List(1, 2, 3, 4, "abc")
        var res = list.collect(function)
    }

    private def method2 {
        val list = List(1, 2, 3, 4, "abc")
        /**
          * 结合 "偏函数总结" 查看源代码.
          */
        val funciton = new PartialFunction[Any, Int] {
            def isDefinedAt(any: Any) = any.isInstanceOf[Int]

            def apply(any: Any) = any.asInstanceOf[Int] + 1
        }
        val list3 = list.collect(funciton)
        println("list3=" + list3) //?
    }

    /**
      * 思路1: map + filter 方式.
      */
    private def method1: Unit = {
        val list = List(1, 2, 3, 4, "abc")

        var res = list.filter(_.isInstanceOf[Int]).map(_.asInstanceOf[Int]).map(_ + 1)
        println(res)


        //思路1,使用map+fliter的思路
        def f1(n: Any): Boolean = {
            n.isInstanceOf[Int]
        }

        def f2(n: Int): Int = {
            n + 1
        }

        def f3(n: Any): Int = {
            n.asInstanceOf[Int]
        }

        val list2 = list.filter(f1).map(f3).map(f2)
        println("list = " + list2)
    }
}
