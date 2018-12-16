package com.ysu.spark._03_rdd_exercise

import org.apache.spark.{SparkConf, SparkContext}


/**
  * 100.79.121.48 HIT 33 [15/Feb/2017:00:00:46 +0800] "GET http://cdn.v.abc.com.cn/videojs/video.js HTTP/1.1" 200 174055 "http://www.abc.com.cn/" "Mozilla/4.0+(compatible;+MSIE+6.0;+Windows+NT+5.1;+Trident/4.0;)"
  * ----
  * IP:           命中率   响应时间   请求时间
  * 100.79.121.48 HIT     33        [15/Feb/2017:00:00:46 +0800]
  *
  * 请求方法   请求URL    							   请求协议
  * "GET      http://cdn.v.abc.com.cn/videojs/video.js HTTP/1.1"
  *
  * 响应码   响应大小   referer
  * 200     174055    "http://www.abc.com.cn/"
  *
  * 用户代理 (user-agent)
  * "Mozilla/4.0+(compatible;+MSIE+6.0;+Windows+NT+5.1;+Trident/4.0;)"
  *
  * 需求:
  * 1. 计算每个IP访问的 次数 ==> IP: 100.79.121.48; 访问次数: 9999)
  * 2. 计算每个视频访问的 IP次数 ==> 视频: abc.mp4; 独立IP数: 9999
  * 3. 计算每小时CDN的流量 ==> 0时; CDN流量: 14G
  *
  * @Author bing57592 
  * @Date 2018-12-16 14:40
  */
object Answer_CDN {
	def main(args: Array[String]): Unit = {
		// 获取spark操作对象, 获取rdd算子.
		var sparkConf = new SparkConf().setMaster("local[*]").setAppName("clickcount")
		var sc = new SparkContext(sparkConf)
		var rdd_requests = sc.textFile("/Users/bing57592/Documents/SparkData/input/cdn.txt")

		var rdd_ip_counts = rdd_requests.map(item => {
			val params = item.split(" ")
			(params(0), 1)
		}).reduceByKey(_ + _)

		/**
		  * (视频_IP, 计数)
		  */
		val rdd1 = rdd_requests.filter(item => { // 过滤掉非MP4文件
			val params = item.split(" ")
			val url = params(6)
			url.endsWith(".mp4")
		})

		val rdd2 = rdd1.map(item => { // 元数据 => (视频名称_IP)
			val params = item.split(" ")
			val url = params(6)
			val ip = params(0)
			println(ip)
			val vedioName = url.split("/").last
			(vedioName + "_" + ip)
		}).distinct()

		val rdd3 = rdd2.map(item => { // (去重) (视频名称_IP => (视频名称, IP))
			val params = item.split("_")
			println(params)
			(params(0), params(1))
		}).groupByKey()

		val rdd4 = rdd3.map(item => {// [对key聚集] (视频名称, IP) => 视频名称, List(IP)
			println(item)
			(item._1, item._2.toList.size)
		})
		sc.stop()

	}
}
