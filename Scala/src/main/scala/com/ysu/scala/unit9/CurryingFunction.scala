package com.ysu.scala.unit9

/**
  * 函数的柯里化:
  * 1. 编程过程中, 接受多个参数的函数都可以转换为接收单个参数的函数, 这个转换过程就叫做柯里化.
  * 2. 颗粒话就是证明了函数只需要一个参数而已. 之前的代码已经涉及到柯里化操作了.
  * 3. 柯里化是 "以函数为主题的思想" 发展的必然结果. 即: 柯里化是面向函数编程的必然结果.
  *
  * @Author bing57592 
  * @Date 2018-12-13 22:44
  */
object CurryingFunction {
	def main(args: Array[String]): Unit = {
		/**
		  * 编写一个函数, 接受两个整数, 可以返回两个数的成绩. 要求:
		  * 1. 使用常规方式完成
		  * 2. 使用闭包方式完成
		  * 3. 使用柯里化方式完成
		  */

		var res1 = method1(12, 10)
		var res2 = method2(12)(10)
		var res3 = method3(12)(10)
		println(res1)
		println(res2)
		println(res3)

		println("---------------------------------------")

		/**
		  * 比较两个字符串在忽略大小写的情况下是否相等?
		  */
		val str1 = "str"
		val str2 = "STR"
		var res = compair1(str1.toUpperCase, str2.toUpperCase())
		println(res)

		println(compair2(str1)(str2))

		println("---------------------------------------")

		def eq(s1: String, s2: String): Boolean = {
			s1.equals(s2)
		}

		/**
		  * 该隐式类, 给String新增一个checkEq方法
		  *
		  * @param s
		  */
		implicit class TestEq(s: String) {
			def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
				f(s.toLowerCase, ss.toLowerCase)
			}
		}

//案例演示+说明+简化版(三种形式)
		str1.checkEq(str2)(eq)

	}

	def compair2(n1: String)(n2: String) = {
		n1.toUpperCase().equals(n2.toUpperCase())
	}

	def compair1(n1: String, n2: String): Boolean = {
		n1 equals n2
	}

	def method1(n1: Double, n2: Double) = {
		n1 * n2
	}

	def method2(n1: Double) = {
		(n2: Double) => n1 * n2
	}

	def method3(x: Double)(y: Double) = {
		x * y
	}
}
