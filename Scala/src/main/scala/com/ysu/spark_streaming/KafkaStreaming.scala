package com.ysu.spark_streaming

import kafka.api.{OffsetRequest, PartitionOffsetRequestInfo, TopicMetadataRequest}
import kafka.common.TopicAndPartition
import kafka.consumer.SimpleConsumer
import kafka.serializer.StringDecoder
import kafka.utils.ZKGroupTopicDirs
import org.I0Itec.zkclient.ZkClient
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  *
  * @Author bing57592
  * @Date 2018-12-23 12:16
  */
object KafkaStreaming extends App {
	val sparkConf = new SparkConf().setAppName("streaming").setMaster("local[*]")
	val ssc = new StreamingContext(sparkConf, Seconds(5))
	// 可以通过ssc.sparkContext 来访问SparkContext
	// 或者通过已经存在的SparkContext来创建StreamingContext
	val textDStream = ssc.socketTextStream("localhost", 9092) //DStream
	val brokerList = "localhost:9092"
	val zookeeper = "localhost:2181"
	val sourceTopic = "source101"
	val targetTopic = "target101"
	val groupId = "consumer101"
	val kafkaParam = Map[String, String](
		ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokerList,
		ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
		ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
		ConsumerConfig.GROUP_ID_CONFIG -> groupId,
		ConsumerConfig.AUTO_OFFSET_RESET_CONFIG -> "largest"
	)

	// 必须要声明类型, 否则报错. 什么鬼...
	var textKafkaDStream: InputDStream[(String, String)] = null

	//通过groupId 和 sourceTopic, 获取zookeeper中保存当前 group + topic 的路径
	val topicDir = new ZKGroupTopicDirs(groupId, sourceTopic)

	//最终保存offset的节点
	val zkTopicPath = s"${topicDir.consumerOffsetDir}"

	//创建zk客户端(这一步和视频中有些区别, 但似乎问题不大)
	val zkClient = new ZkClient(zookeeper)
	val children = zkClient.countChildren(zkTopicPath)

	if (children > 0) {
		//从ZK中获取Offset，根据Offset来创建连接
		var fromOffsets: Map[TopicAndPartition, Long] = Map()
		//首先获取每一个分区的主节点
		val topicList = List(sourceTopic)
		//向Kafka集群获取所有的元信息， 你随便连接任何一个节点都可以
		val request = new TopicMetadataRequest(topicList, 0)
		val getLeaderConsumer = new SimpleConsumer("localhost", 9092, 100000, 10000, "OffsetLookup")
		//该请求包含所有的元信息，主要拿到 分区 -> 主节点
		val response = getLeaderConsumer.send(request)
		val topicMetadataOption = response.topicsMetadata.headOption
		val partitons = topicMetadataOption match {
			case Some(tm) => tm.partitionsMetadata.map(pm => (pm.partitionId, pm.leader.get.host)).toMap[Int, String]
			case None => Map[Int, String]()
		}
		getLeaderConsumer.close()
		println(s"partition	information	is ${partitons}")
		println(s"children	information	is ${children}")

		for (i <- 0 until children) {
			//先从ZK读取 i 这个分区的offset保存
			val partitionOffset = zkClient.readData[String](s"${topicDirs.consumerOffsetDir}/${i}")
			println(s"partition[${i}] 目前的offset是：${partitionOffset}")

			// 从当前i的分区主节点去读最小的offset，
			val tp = TopicAndPartition(sourceTopic, i)
			val requestMin = OffsetRequest(Map(tp -> PartitionOffsetRequestInfo(OffsetRequest.EarliestTime, 1)))
			val consumerMin = new SimpleConsumer(partitons(i), 9092, 10000, 10000, "getMiniOffset")
			val curOffsets = consumerMin.getOffsetsBefore(requestMin).partitionErrorAndOffsets(tp).offsets
			consumerMin.close()

			//合并这两个offset
			var nextOffset = partitionOffset.toLong
			if (curOffsets.length > 0 && nextOffset < curOffsets.head) {
				nextOffset = curOffsets.head
			}

			println(s"Partition[${i}] 修正后的偏移量是：${nextOffset}")
			fromOffsets += (tp -> nextOffset)
		}

	} else {

	}
	textKafkaDStream = KafkaUtils.createDirectStream[String, String,
			StringDecoder, StringDecoder](ssc, kafkaParam, Set(sourceTopic))

	textKafkaDStream.map(item => {
		"key = " + item._1 + ", value = " + item._2
	}).foreachRDD {
		rdd =>
			rdd.foreachPartition {//对每个分区做操作
				items => {
					// 需要连接池技术
					val pool = KafkaConnPool(brokerList)
					// 创建kafka连接
					val kafkaCoon = pool.borrowObject();
					// 插入数据
					for (item <- items)
						kafkaCoon.send(targetTopic, item)
					// 返回连接
					pool.returnObject(kafkaCoon)
				}
			}
	}

	ssc.start()
	ssc.awaitTermination()
}
