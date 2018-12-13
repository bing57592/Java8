package com.ysu.scala.unit9

/**
  * 闭包:
  * 闭包就是一个函数和与其相关的引用环境组合的一个整体(实体)
  * 在很多语言中, 闭包的本质就是一个对象.
  *
  * 体会闭包的好处:
  * 1. 返回的匿名函数和makeSuffix(suffix string)的suffix变量, 组合成一个闭包, 因为返回的函数引用
  * ---到suffix这个变量
  * 2. 如果使用传统的方法, 也可以轻松实现这个功能, 但是传统方法啊需要每次都传入后缀名. 比如.jpg. 而
  * ---闭包因为可以保留上次引用的某个值, 所以传入一次就可以反复使用.
  *
  * @Author bing57592 
  * @Date 2018-12-13 21:34
  */
object Closure {
	def main(args: Array[String]): Unit = {

	}

	def method2: Unit = {
		/**
		  * 编写一个程序, 具体要求如下:
		  * 1. 编写一个函数makeSuffix(suffix: String)可以接收一个文件后缀名(比如.jpg), 并返回一个闭包
		  * 2. 调用闭包, 可以传入一个文件名, 如果该文件名没有指定的后缀(比如.jpg), 则返回 文件名.jpg,
		  * ---如果已经有.jpg后缀, 则返回原文件名.
		  * 3. 要求使用闭包的方式完成
		  * ---String.endsWith(xx)
		  */
		def makeSuffix(suffix: String) = {
			(string: String) => {
				if (string.endsWith(suffix)) string
				else string + suffix
			}
		}

		val res = makeSuffix(".jpg")
		val res1 = makeSuffix(".jpg")("Hello")
		val res2 = makeSuffix(".jpg")("helo123.jpg")
		println(res1)
		println(res2)
	}

	/**
	  * 在这里, f就是一个闭包.
	  */
	def method1: Unit = {
		def minusxy(x: Int) = {
			(y: Int) => x - y
		}

		val f = minusxy(20)
	}
}
