package com.ysu.spark._03_rdd_exercise

import java.text.SimpleDateFormat
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * f格式 ：
  * timestamp        province  city     userid   adid
  * 某个时间点        某个省份   某个城市  某个用户  某个广告
  * 1516609143869    9         4        75       18
  *
  * 用户ID范围:          0 - 99
  * 省份、城市 ID相同 ：  0 - 9
  * adid:               0 - 19
  * *
  * 需求：统计每一个省份每一个小时的TOP3广告的ID
  *
  * created by bing57592     
  * 2018-09-20 19:06
  */
object Answer_02 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
		var sc = new SparkContext(sparkConf)
		var click = sc.textFile("/Users/bing57592/Documents/vedio/LocalData/agent.log")

		var clickRDD: RDD[Click] = click.map(x => {
			// 将数据集转换成了对象集 数据==>对象
			var param = x.split(" ")
			new Click(param(0).toLong, param(1).toInt, param(2).toInt, param(3).toInt, param(4).toInt)
		})

		var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH")

		var proAndTimeAndAd2CountRDD: RDD[(String, Int)] = clickRDD.map(click => { // 这个不能指定为RDD[String, Int]类型, 而是RDD[(String, Int)]
			(click.provinceId + "_" + simpleDateFormat.format(click.time) + "_" + click.adversementId, 1)
		})
		var proAndTimeAndAd2CountsRDD = proAndTimeAndAd2CountRDD.reduceByKey(_ + _) //以(省份_小时数_广告id)为key, 每个key的数量
		var timeAndAdPreProCounts = proAndTimeAndAd2CountsRDD.map(item => { // 每个省份, 不同时间段的不同广告的点击量
			var keys = item._1.split("_")
			(keys(1) + "_" + keys(2), (keys(3), item._2))
		}).groupByKey().mapValues(item => {
			item.toList.sortWith(_._2 > _._2).take(3)
		}).map(item => {
			var keys = item._1.split("_")
			(keys(0), (keys(1), item._2))
		}).groupByKey().collect()


	}

}
