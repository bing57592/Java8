package com.ysu.scala.unit6.base

/**
  *
  * created by bing57592     
  * 2018-09-11 13:09
  */
object Square {
  //  def unapply(number: Double): Option[Double] = None
  def unapply(number: Double): Option[Double] = Some(math.sqrt(number))
}
