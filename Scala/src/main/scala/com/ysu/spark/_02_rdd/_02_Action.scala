package com.ysu.spark._02_rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * created by bing57592     
  * 2018-09-18 21:14
  */
object _02_Action {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    var sc = new SparkContext(sparkConf)
    var rdd1 = sc.makeRDD(1 to 10)
    var rdd2 = sc.makeRDD(Array((1, 1), (1, 1), (1, 1)))

    // 1 def reduce(f: (T, T) => T): T
    // 规约某个RDD
    var result1 = rdd1.reduce(_ + _)

    // 2 def collect(): Array[T]
    // ==> 以数组的形式, 将数据返回到driver. [生产环境一般不用这个方法]
    rdd1.collect()

    // 3 def count(): Long
    // ==> 返回RDD中元素个数
    var result3 = null

    // 4 def first(): T
    // ==> 返回RDD中的第一个元素
    var result4 = null

    // 5 def take(num: Int): Array[T]
    // ==> 返回RDD中前num个元素
    var result5 = null

    // 6 def takeSample(withReplacement: Boolean, num: Int, seed: Long = Utils.random.nextLong): Array[T]
    // ==> 采样, 返回数组
    var result6 = null

    // 7 def takeOrdered(num: Int)(implicit ord: Ordering[T]): Array[T]
    // ==> 返回排序后的前几个, 如果需要倒叙, 可以利用重写Ordering方法来做
    var result7 = null

    // 8 def aggregate[U: ClassTag](zeroValue: U)(seqOp: (U, T) => U, combOp: (U, U) => U): U
    // ==> 同Transformation的aggregate(没找)
    var result8 = null

    // 9 def fold(zeroValue: T)(op: (T, T) => T): T
    // ==> aggregate()的简化操作
    var result9 = null

    // 10 def saveAsTextFile(path: String): Unit
    // ==> 以文本的方式, 保存到HDFS兼容的文件系统.
    var result10 = null

    // 11 def countByKey(): Map[K, Long]
    // ==> 按key查询数据个数
    var result11 = rdd2.countByKey()


    // 12 def foreach(f: T => Unit): Unit
    // ==> 对数据集中的每一个元素做操作.
    var result12 = rdd1.foreach(_)
    println("--------------------------------------------------")
  }
}
