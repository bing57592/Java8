package com.ysu.scala.unit6

/**
  *
  * created by bing57592     
  * 2018-09-11 13:17
  */
object SquareSeq {
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(",")) else None //卧槽, 你不是缺心眼吧!!!
  }
}
