package com.ysu.scala.unit9

/**
  * 控制抽象:
  * 需求: 如何实现将一段代码(从形式上看), 作为参数传递给高阶函数, 在高阶函数内部执行这段代码. 其使用
  * -----的形式如breakable{}
  *
  * @Author bing57592 
  * @Date 2018-12-13 23:12
  */
object AbstractControl {
	def main(args: Array[String]): Unit = {
		var x = 10

		def until(condition: => Boolean)(block: => Unit): Unit = {
			// 类似while循环，递归
			if (!condition) {
				block
				until(condition)(block)
			}
			// println("x=" + x)
			// println(condition)
			// block
			// println("x=" + x)
		}

		until(x == 0) {
			x -= 1
			println("x=" + x)
		}

	}
}
