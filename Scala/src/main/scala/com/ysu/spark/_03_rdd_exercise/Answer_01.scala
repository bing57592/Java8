package com.ysu.spark._03_rdd_exercise

import org.apache.spark._
import org.apache.spark.rdd.RDD

/**
  * 格式 ：
  * timestamp        province  city     userid   adid
  * 某个时间点        某个省份   某个城市  某个用户  某个广告
  * 1516609143869    9         4        75       18
  *
  * 用户ID范围: 0 - 99
  * 省份、城市 ID相同 ： 0 - 9
  * adid: 0 - 19
  * *
  * 需求：统计每一个省份点击TOP3的广告ID
  * *
  *
  * created by bing57592
  * 2018-09-18 21:58
  */

object Answer_01 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
		var sc = new SparkContext(sparkConf)
		// 1. 从textFile拿到的数据, 默认就是String类型的. 不用声明变量类型.
		var click = sc.textFile("/Users/bing57592/Documents/SparkData/input/agent.log")
		var clickRDD: RDD[Click] = click.map(x => {
			// 将数据集转换成了对象集 数据==>对象
			var param = x.split(" ")
			new Click(param(0).toLong, param(1).toInt, param(2).toInt, param(3).toInt, param(4).toInt)
		})


		var proAndAdCountRDD: RDD[(String, Int)] = clickRDD.map(click => { // 这个不能指定为RDD[String, Int]类型, 而是RDD[(String, Int)]
			(click.provinceId + "_" + click.adversementId, 1)
		})
		// 目前来看, RDD只有两种类型: RDD[T] 和 RDD[(K, V)]. 后者一定要加括号啊加括号
		// reduceByKey这个函数, 就是根据key, 对value进行聚合. 入参是: func: (v, v) => v
		var proAndAdCountsRDD = proAndAdCountRDD.reduceByKey(_ + _) // 根据key做累加
		// 这个时候, 粒度已经放大了[看起来这里很关键很重要]
		var pro2AdCountsRDD: RDD[(Int, (Int, Int))] = proAndAdCountsRDD.map(item => {
			var param = item._1.split("_")
			(param(0).toInt, (param(1).toInt, item._2)) // (省份ID, (广告ID, 广告数量))
		})

		var pro2AdsRDD: RDD[(Int, Iterable[(Int, Int)])] = pro2AdCountsRDD.groupByKey() //(省份ID, Iterable(广告ID, 广告数量))
		// 这里就看不懂了.
		//def mapValues[U](f: V => U): RDD[(K, U)], 将Iterable(广告ID, 广告数量)按照广告数量排序 -> 取前三个.
		var result = pro2AdsRDD.mapValues(item => {
			item.toList.sortWith(_._2 > _._2).take(3)
		})
		println(result)
		println(result.collect())
		for (elem <- result.collect) {
			println(elem)
		}

		println("----------------------------------------")
		sc.stop()
	}
}