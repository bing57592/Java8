package com.ysu.spark._06_spark_streaming

/**
  *
  * created by bing57592     
  * 2018-09-24 14:58
  */

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket
import java.nio.charset.StandardCharsets

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.receiver.Receiver

//自定义数据接收器需要继承Receiver抽象类
class MyReceiver(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_AND_DISK) {
  //启动的时候运行
  override def onStart(): Unit = {
    new Thread() {
      override def run(): Unit = {
        receive()
      }
    }.start()
  }

  //停止的时候运行
  override def onStop(): Unit = {

  }

  //创建Socket连接到NetCat去获取数据
  private def receive(): Unit = {
    var socket: Socket = null;

    try {
      socket = new Socket(host, port);
      val reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

      var line = reader.readLine()
      while (!isStopped() && line != null) {
        //将接受到的数据传给框架
        store(line)
        line = reader.readLine()
      }
      reader.close()
      socket.close()
    } catch {
      case e: Exception => println("error {}", e.getMessage)
    }

  }


}

object CustomReceiver extends App {

  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Streaming")
  val ssc = new StreamingContext(sparkConf, Seconds(3))

  // 使用自定义的Receiver
  val lines = ssc.receiverStream(new MyReceiver("master01", 9999))

  val result = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

  result.print()

  ssc.start()
  ssc.awaitTermination()

}
