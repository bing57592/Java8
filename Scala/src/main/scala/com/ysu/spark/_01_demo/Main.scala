package com.ysu.spark._01_demo

/**
  *
  * @Author bing57592 
  * @Date 2018-12-11 22:56
  */
object Main {
	def main(args: Array[String]): Unit = {
		val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
		val iterator = Iterator(list, list, list)

		println(list)
		println(iterator)

		for (elem <- list) {
			println(elem)
		}
		for (elem <- iterator) {
			println(elem)
		}
	}
}
