package com.ysu.scala.unit10

/**
  *
  * @Author bing57592 
  * @Date 2018-12-14 01:16
  */
object Exercise1 {
	def main(args: Array[String]): Unit = {
	}

	private def method2 = {
		var start = System.currentTimeMillis()

		def function(num: BigInt, sum: BigInt): BigInt = {
			if (num <= 99999999l) return function(num + 1, sum + num)
			else return sum
		}

		var res = BigInt(0);
		var num = BigInt(1);
		var maxVal = BigInt(99999999l) //BigInt(99999999l)[测试效率大数]while(num<=maxVal){  res += num  num += 1}println("res=" + res)
		function(num, res)
		val end = System.currentTimeMillis()
		println("总共花费了 " + (end - start) + " 毫秒")
	}

	/**
	  * 用传统方法, 计算 [1, 99999999] 的和
	  */
	private def method1 = {
		var start = System.currentTimeMillis()
		var res = BigInt(0);
		var num = BigInt(1);
		var maxVal = BigInt(99999999l) //BigInt(99999999l)[测试效率大数]while(num<=maxVal){  res += num  num += 1}println("res=" + res)
		while (num <= maxVal) {
			res += num
			num += 1
		}
		val end = System.currentTimeMillis()
		println("总共花费了 " + (end - start) + " 毫秒")
	}
}
