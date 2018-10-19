package com.ysu.scala.unit6

/**
  * 样例类 可以类比为枚举
  * created by bing57592     
  * 2018-09-11 20:52
  */
abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(val value: Double, unit: String) extends Amount

case object Nothing extends Amount
