package com.ysu.spark_streaming

import java.util.Properties
import org.apache.commons.pool2.impl.{DefaultPooledObject, GenericObjectPool}
import org.apache.commons.pool2.{BasePooledObjectFactory, PooledObject}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

//创建一个类用来代理Kafka连接的创建等工作
class KafkaProxy(brokers: String) {
	private val pros: Properties = new Properties();
	pros.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
	pros.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
	pros.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

	private val kafkaConn = new KafkaProducer[String, String](pros)

	/**
	  * 提供一个send方法. ProducerRecord是kafka发送异步消息时的消息实体.
	  *
	  * @param topic
	  * @param key
	  * @param value
	  */
	def send(topic: String, key: String, value: String): Unit = {
		kafkaConn.send(new ProducerRecord[String, String](topic, key, value))
	}

	/**
	  * key为null的消息实体.
	  *
	  * @param topic
	  * @param value
	  */
	def send(topic: String, value: String): Unit = {
		kafkaConn.send(new ProducerRecord[String, String](topic, value))
	}

	def close(): Unit = {
		kafkaConn.close()
	}
}

//创建一个负责生成KafkaProxy的工厂类
/**
  * BasePooledObjectFactory: 基础-池对象-工厂
  *
  * @param brokers
  */
class KafkaProxyFactory(brokers: String) extends BasePooledObjectFactory[KafkaProxy] {
	//创建KafkaProxy的实例
	override def create(): KafkaProxy = {
		new KafkaProxy(brokers)
	}

	//包装KafkaProxy的实例为Pool中的对象
	override def wrap(proxy: KafkaProxy): PooledObject[KafkaProxy] = {
		new DefaultPooledObject[KafkaProxy](proxy)
	}
}


/**
  * 将kafka连接, 基础-池对象-工厂中. 然后将(基础-池对象-工厂)传入 通用-对象-池 中(GenericObjectPool)
  *	这里边大部分的代码, 都是为了实现单利.
  */
object KafkaConnPool {
	// 代表连接池
	private var kafkaProxyPool: GenericObjectPool[KafkaProxy] = null

	def apply(brokers: String): GenericObjectPool[KafkaProxy] = {
		if (null == kafkaProxyPool) {
			KafkaConnPool.synchronized {
				if (null == kafkaProxyPool) {
					kafkaProxyPool = new GenericObjectPool[KafkaProxy](new KafkaProxyFactory(brokers))
				}
			}
		}
		kafkaProxyPool
	}

}
