package com.ysu.scala.unit10

/**
  * 递归翻转字符串
  *
  * @Author bing57592 
  * @Date 2018-12-14 01:42
  */
object Exercise3 {
	def main(args: Array[String]): Unit = {
		val str = "bing57592"
		val res = reverse(str)
		println(res)
	}

	def reverse(str: String): String = {
		if (str.length == 1) str else reverse(str.tail) + str.head
	}
}
