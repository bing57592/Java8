package com.ysu.scala.unit7

/**
  * 高阶函数
  * created by bing57592     
  * 2018-09-11 22:35
  */
object _7_1_ {
  def main(args: Array[String]): Unit = {
    //作为参数的函数: 函数作为一个变量传入到了另一个函数中，那么该作为参数的函数的类型是：function1，即：（参数类型） => 返回类型
    def plus(x: Int) = 3 + x

    val result1 = Array(1, 2, 3, 4).map(plus(_))
    println(result1.mkString(","))
    println("------------------------------------------")


    //匿名函数: 即没有名字的函数，可以通过函数表达式来设置匿名函数。
    val triple = (x: Double) => 3 * x
    println(triple(3))
    println("------------------------------------------")

    //高阶函数--能够接受函数作为参数的函数，叫做高阶函数。
    //(1)高阶函数的使用
    //入参Double, 返回值Double
    def highOrderFunction1(f: Double => Double) = f(10)

    //入参(), 返回值Double
    def minus7(x: Double) = x - 7

    val result2 = highOrderFunction1(minus7)
    println(result2)
    println("------------------------------------------")


    //闭包
    //闭包就是一个函数把外部的那些不属于自己的对象也包含(闭合)进来。
    //这就是一个闭包：
    //1) 匿名函数(y: Int) => x -y嵌套在minusxy函数中。
    //2) 匿名函数(y: Int) => x -y使用了该匿名函数之外的变量x
    //3) 函数minusxy返回了引用了局部变量的匿名函数
    def minusxy(x: Int) = (y: Int) => x - y

    val f1 = minusxy(10)
    //这句话执行之后, f1 = 10 - y, 此时f1是个函数, y还没有被赋值
    val f2 = minusxy(10)

    println(f1(3) + f2(3)) //而当f1(3)之后, 相当于执行函数: 10 - 3, 结果是7
    println(" ")

    def minusxy2(x: Int)(y: Int) = {
      x + y
    }

    //println(minusxy2(1))//和minusxy不是一回事.
    //函数的柯里化(恕我直言, 看不懂)
    //函数编程中，接受多个参数的函数都可以转化为接受单个参数的函数，
    //这个转化过程就叫柯里化，柯里化就是证明了函数只需要一个参数而已。
    //其实我们刚才的学习过程中，已经涉及到了柯里化操作，所以这也印证了，
    //柯里化就是以函数为主体这种思想发展的必然产生的结果。
    def mul(x: Int, y: Int) = x * y

    println(mul(10, 10))

    def mulCurry(x: Int) = (y: Int) => x * y

    println(mulCurry(10)(9))

    def mulCurry2(x: Int)(y: Int) = x * y

    println(mulCurry2(10)(8))


    //2)  柯里化的应用
    //比较两个字符串在忽略大小写的情况下是否相等，注意，这里是两个任务：
    //1、全部转大写（或小写）
    //2、比较是否相等
    //针对这两个操作，我们用一个函数去处理的思想，其实无意间也变成了两个函数处理的思想。示例如下：
    println("------------------------------------------")

    //控制抽象
    //    def runInThread(f1: () => Unit): Unit = {
    //      new Thread {
    //        override def run(): Unit = {
    //          f1()
    //        }
    //      }.start()
    //    }
    //    runInThread(() => {
    //      println("干活咯！")
    //      Thread.sleep(5000)
    //      println("干完咯！")
    //    })
    // 是不是很爽？是不是有点类似线程池的感觉，同一个线程，可以动态的向里面塞不同的任务去执行。
    // 可以再简化一下，省略()，看下如下形式：
    def runInThread(f1: => Unit): Unit = {
      new Thread {
        override def run(): Unit = {
          f1
        }
      }.start()
    }


    runInThread {
      println("干活咯！")
      Thread.sleep(5000)
      println("干完咯！")
    }
    println("------------------------------------------")


  }
}
