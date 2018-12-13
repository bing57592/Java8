package com.ysu.scala.unit10

/**
  *
  * 递归获取最大值
  *
  * @Author bing57592 
  * @Date 2018-12-14 01:36
  */
object Exercise2 {
	def main(args: Array[String]): Unit = {
		val list = List(1, 2, 3, 4, 15, 6)

		var result = max(list)
		println(result)
	}

	def max(list: List[Int]): Int = {
		if (list.isEmpty)
			throw new java.util.NoSuchElementException

		if (list.size == 1)
			list.head
		else if (list.head >= max(list.tail)) list.head else max(list.tail)
	}
}
