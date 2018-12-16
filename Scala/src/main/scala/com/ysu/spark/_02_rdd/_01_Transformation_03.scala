package com.ysu.spark._02_rdd

import org.apache.spark._

/**
  *
  * created by bing57592     
  * 2018-09-18 20:48
  */
object _01_Transformation_03 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
		var sc = new SparkContext(sparkConf)
		// 21 def pipe(command: String): RDD[String]
		// ==> 支持使用外部脚本(如shell, perl, Python等)来处理分区内的数据, 入参为脚本路径
		var rdd1 = sc.makeRDD(1 to 100);
		rdd1.pipe("/opt/datas/abc.sh")

		// 22 def coalesce(numPartitions: Int, shuffle: Boolean = false, partitionCoalescer: Option[PartitionCoalescer] = Option.empty)
		// (implicit ord: Ordering[T] = null) : RDD[T]
		// ==> 改变分区数
		var result22 = null

		// 23 def repartition(numPartitions: Int)(implicit ord: Ordering[T] = null): RDD[T]
		// ==> 重新分区, 重新通过网络随机混洗数据.
		var result23 = null

		// 24 def repartitionAndSortWithinPartitions(partitioner: Partitioner): RDD[(K, V)]
		// ==> [官网推荐]在重新分区的过程中会进行排序. 如果重新分区后还要进行sortBy或者sortByKey操作, 可以直接使用该算子.
		var rdd2 = sc.makeRDD(Array((1, "A"), (2, "V"), (3, "B")))

		// 25 def glom(): RDD[Array[T]]
		// ==> 把每个分区的数据都变成一个数组.
		var rdd3 = sc.makeRDD(1 to 100, 10)
		var result25 = rdd3.glom().collect()

		// 26 def mapValues[U](f: V => U): RDD[(K, U)]
		// ==> 只对key-value结构中的value进行映射(function的映射)
		rdd2.mapValues(x => (x, 1))

		// 27 def subtract(other: RDD[T]): RDD[T]
		// ==> 求差集
		println("--------------------------------------------------")
	}
}
