package com.ysu.spark._03_rdd_exercise

import java.text.SimpleDateFormat
import org.apache.spark.{SparkConf, SparkContext}

/**
  * |某个时间点 	   |某个省份   |某个城市   |某个用户    |某个广告
  * 1516609239711  5          3          70          27
  *
  * 需求：统计每一个省份每一个小时的TOP3广告的ID
  *
  * @Author bing57592 
  * @Date 2018-12-15 22:31
  */
object Answer_04 {
	def main(args: Array[String]): Unit = {
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
		var sc = new SparkContext(sparkConf)
		// 1. 从textFile拿到的数据, 默认就是String类型的. 不用声明变量类型.
		var click = sc.textFile("/Users/bing57592/Documents/SparkData/input/agent.log")
		val rdd_click = click.map(item => {
			val param = item.split(" ")
			Click(param(0).toLong, param(1).toInt, param(2).toInt, param(3).toInt, param(4).toInt)
		})

		val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH")

		// click => (省份_广告_小时, 数量) (对最小粒度的统计)
		val rdd_minParticle = rdd_click.map(item => {
			val hour = (item.time / (60 * 60)) % 24
			((item.provinceId + "_" + item.adversementId + "_" + simpleDateFormat.format(item.time)), 1)
		}).reduceByKey(_ + _)


		// (省份_广告_小时, 数量) => ((省份_小时), (广告, 数量))
		val rdd_adIdAndCount_pre_pidAndTime = rdd_minParticle.map(item => {
			val param = item._1.split("_")
			val count = item._2
			val provinceId = param(0)
			val advertiseId = param(1)
			val time = param(2)
			((provinceId + "_" + time), (advertiseId, count))
		})
		val rdd_count = rdd_adIdAndCount_pre_pidAndTime.groupByKey().mapValues(item => {
			item.toList.sortWith(_._2 > _._2).take(3)
		})

		for (elem <- rdd_count.collect) {
			println(elem)
		}

		println("------------")
		val rdd_countPreProvince = rdd_count.map(item => {
			val param = item._1.split("_")
			val provinceId = param(0)
			val time = param(1)
			(provinceId, (time, (item._2)))
		}).groupByKey()


		for (elem <- rdd_countPreProvince.collect) {
			println(elem)
		}


		sc.stop()
	}
}
