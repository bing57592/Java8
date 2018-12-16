package com.ysu.spark._02_rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 文件行数太多的话, 会非常卡.
  * 每10个算子放到一个文件中
  * created by bing57592     
  * 2018-09-17 23:05
  */
object _01_Transformation_02 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
		var sc = new SparkContext(sparkConf)
		// 11. def reduceByKey(func: (V, V) => V): RDD[(K, V)]
		// ==> 返回值的类型必须与输入值一样.
		var rdd7 = sc.makeRDD(1 to 10, 10).union(sc.makeRDD(3 to 15)).map((_, 1))
		var result11 = rdd7.reduceByKey((x, y) => x + y).collect()
		println("--------------------------------------------------")

		// 12. def groupByKey(partitioner: Partitioner): RDD[(K, Iterable[V])]
		// ==> 将相同key的value进行聚集, 聚集成一个List(Iterable--聚集)
		// 与reduceByKey 相比, 这个方法是对value进行聚集(也就不用写函数了), 而reduceByKey是对value进行运算.
		var result12_1 = rdd7.groupByKey().collect() //元素: (1, CompactBuffer(1)), 是一个二元组 param1-key; param2-List
		var result12_2 = rdd7.groupByKey().map({ case (x, y) => (x, y.sum) }).collect() // 有点体会到, 模式匹配的用处了.
		var result12_3 = rdd7.groupByKey().map(item => (item._1, item._2.sum)).collect() // 这里, 和上边的12_2, 是一回事.
		println(result12_3.mkString(", "))
		println("--------------------------------------------------")

		/**
		  *  13. def combineByKey[C](createCombiner: V => C, mergeValue: (C, V) => C, mergeCombiners: (C, C) => C): RDD[(K, C)]
		  * rdd8: 每一位学生的成绩, 求每位学生的平均成绩
		  * combineByKey, 就是根据key分区. 那么,
		  * createCombiner函数表示, 当遇到一个新的key的时候, 将这个[K]对应的[V]类型的数据, 转换为[C]类型的数据, 其中[C]类型为自定义类型
		  * mergeValue函数表示, 当再次遇到这个key的时候, 将[C, V]类型的数据, 转换为[C]类型的数据.
		  * 上边两个函数都已经做完, 则表示数据已经被撸完了, 但下边的函数还没运行.
		  * mergeCombiners函数表示, 当撸完数据之后, 将[C, C]类型的数据, 转换为[C]类型的数据.
		  * 当将所有的[C, C]类型的数据转换为[C]类型数据之后, 整个函数生成一个RDD, 它的类型为: [K, C], 其中[C]类型为自定义类型
		  * 自定义类型::: 即createComnier函数生成的类型.
		  * 来自老师的笔记:
		  * 1. 后面三个函数是针对某一个key聚集起来的
		  * 2. createCombiner: 每个分区都有, 当遇到一个新key的时候, 产生一个新的数据结构.
		  * 3. mergeValue: 每个分区都有, 当遇到就Key的时候调用, 将当前数据合并到数据结构中
		  * 4. mergeCombiners: 全局所有, 合并所有分区中过来的数据,
		  */
		var rdd8 = sc.makeRDD(Array(("a", 50), ("b", 40), ("c", 50), ("a", 70), ("b", 80), ("c", 60), ("a", 80), ("c", 80), ("a", 70)))
		rdd8.combineByKey((_, 1), (c: (Int, Int), v) => (c._1 + v, c._2 + 1), (c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2))

		println("--------------------------------------------------")

		// 14. def aggregateByKey[U: ClassTag](zeroValue: U)(seqOp: (U, V) => U,  combOp: (U, U) => U): RDD[(K, U)]
		// ==> 简单来说, 是combineByKey()的简化版
		var result14 = rdd8.aggregateByKey((0, 0))((c: (Int, Int), v) => (c._1 + v, c._2 + 1), (c1: (Int, Int), c2: (Int, Int)) => (c1._1 + c2._1, c1._2 + c2._2))

		// 15  def foldByKey(zeroValue: V, numPartitions: Int)(func: (V, V) => V): RDD[(K, V)]
		var result15 = rdd8.foldByKey(0)(_ + _) // ==> 基本等同于 13 和 14, 但是foldByKey方法, [V]的类型不能改变
		// 16 def sortByKey(ascending: Boolean = true, numPartitions: Int = self.partitions.length) : RDD[(K, V)]
		// ==> 对[K, V]结构的RDD进行排序, K必须实现Ordering[T]复写Compare方法
		var result16 = null

		println("--------------------------------------------------")

		// 17 def sortBy[K](f: (T) => K, ascending: Boolean = true, numPartitions: Int = this.partitions.length)
		// (implicit ord: Ordering[K], ctag: ClassTag[K]): RDD[T]
		// ==> sortBy使用function产生的key来做排序.
		// PS: result17_1, result17_2 得到的结果是一样的, 可以对比着来理解.
		var rdd9 = sc.makeRDD(1 to 10)
		var result17_1 = rdd9.sortBy(_ % 4)
		var result17_2 = rdd9.map(x => (x % 4, x)).sortByKey().map(_._2)

		// 18 def join[W](other: RDD[(K, W)]): RDD[(K, (V, W))]
		// ==> join, 很好理解, 就是join. 和另外的RDD进行join. 有join, leftOuterJoin(左外连接), rightOuterJoin(右外连接)
		var result18 = null
		// 19 def cogroup[W](other: RDD[(K, W)], numPartitions: Int)
		// 两个RDD共同做groupByKey, 然后再join
		var rdd10 = sc.makeRDD(Array((1, "a"), (2, "b"), (3, "c")))
		var rdd11 = sc.makeRDD(Array((5, 2), (2, 4), (3, 3)))
		var result19 = rdd10.cogroup(rdd11).collect()

		// 20 def cartesian[U: ClassTag](other: RDD[U]): RDD[(T, U)]
		// ==> 笛卡尔积
		var rdd12 = sc.makeRDD(1 to 5)
		var rdd13 = sc.makeRDD(5 to 10)
		var result20 = rdd12.cartesian(rdd13).collect()

		println("--------------------------------------------------")
		sc.stop()
	}
}
