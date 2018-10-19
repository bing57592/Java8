package com.ysu.spark._02_rdd

import org.apache.spark._

/**
  *
  * created by bing57592     
  * 2018-09-16 16:22
  */
object _01_Transformation_01 {
  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    var sc = new SparkContext(sparkConf)
    //一: RDD的创建
    // 1. makeRDD:  -- param1: 集合; param2: 分片数
    var rdd1 = sc.makeRDD(Array(1, 2, 3, 4, 5))
    var rdd2 = sc.makeRDD(1 to 100, 10)
    //    println(rdd2.partitions.size) //分区数, 分片数, 并行度.
    //
    // 2.parallelize: -- param1: 集合; param2: 分片数
    var rdd3 = sc.parallelize(Array(1, 2, 3, 4), 10)
    println("--------------------------------------------------")

    //二: RDD的转换 -- spark核心: 数据的转换(数据转换之后依然是一个RDD)
    // 01. def map[U: ClassTag](f: T => U): RDD[U]
    // ==> 映射, 将一种类型的数据, 转换成另一种类型
    var result1 = rdd2.map(_ + "a").collect

    // 02. def filter(f: T => Boolean): RDD[T]
    // ==> 返回满足条件的数据
    var result2 = rdd2.filter(_ % 3 == 0).collect

    // 03. def flatMap[U: ClassTag](f: T => TraversableOnce[U]): RDD[U]
    // ==> 将一个数据结构 转换为一个可迭代的数据结构, 然后将数据压平
    var rdd4 = sc.makeRDD(Array("c n m", "d s b", "h r r"))
    var result3_1 = rdd4.map(_.split(" "))
    var result3_2 = rdd4.flatMap(_.split(" "))

    // 04. def mapPartitions[U: ClassTag](f: Iterator[T] => Iterator[U], preservesPartitioning: Boolean = false): RDD[U]
    // ==> 对每一个分区执行一次函数, 它的执行效率比map高
    var result4_1 = rdd2.mapPartitions(x => x.map(x => x + "a")).collect // var result4 = rdd2.mapPartitions(_.map(_ + "a")).collect; 这两个是一样的
    // 需求, 每个分区输出一个字符串
    // 这个是错的: var result4_2 = rdd2.mapPartitions(x => x.map(x.mkString("|"))).collect, 因为x.mkString("|")不是一个Interator
    var result4_2 = rdd2.mapPartitions(x => Iterator(x.mkString("|")))

    // 05. def mapPartitionsWithIndex[U: ClassTag](f: (Int, Iterator[T]) => Iterator[U], preservesPartitioning: Boolean = false): RDD[U]
    // ==>  与(4)基本相同, 但同时这个lambda表达式中, 可以将分区的索引作为形参传入.
    // ===> 前边的那个变量, 就被认为是分区的索引(标识)
    var result5_1 = rdd2.mapPartitionsWithIndex((index, v) => Iterator(index + ":" + v.mkString("|")))

    // 06. def sample(withReplacement: Boolean, fraction: Double, seed: Long = Utils.random.nextLong): RDD[T]
    // ==> 对rdd进行采样, 主要用于观察大数据集分布情况
    var result6 = rdd2.sample(false, 0.3)

    // 07. def union(other: RDD[T]): RDD[T]
    // ==> 和另外一个rdd联合(1, 2) union (2, 3) = (1, 2, 2, 3)
    var result7 = rdd1.union(rdd2).collect()

    // 08. def intersection(other: RDD[T]): RDD[T]
    // ==> 取两个数据集的交集(1, 2) union (2, 3) = (2)
    var result8 = rdd1.intersection(rdd2).collect()

    // 09. def distinct(numPartitions: Int)(implicit ord: Ordering[T] = null): RDD[T]
    // ==> 去重,
    var rdd5 = sc.makeRDD(Array(1, 2, 2, 3))
    var result9 = rdd5.distinct().collect()

    // TODO: 这个数据做了partitionBy操作之后, 具体变成什么样了, 还没能明白.
    // 10. def partitionBy(partitioner: Partitioner): RDD[(K, V)]
    // ==> 对key - value 结构的rdd 重新进行分区. [PS]partitioner: 定义key对应的是哪个分区. ==> new HashPartitioner(5): 定义五个HashPartitioner分区
    var rdd6 = sc.makeRDD(1 to 100, 10).map((_, 1))
    var result10 = rdd6.partitionBy(new HashPartitioner(5)).collect()
  }
}
