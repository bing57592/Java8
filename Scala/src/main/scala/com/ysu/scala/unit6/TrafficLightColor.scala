package com.ysu.scala.unit6

/**
  *密封类
  *
  * created by bing57592     
  * 2018-09-11 22:03
  */
sealed abstract class TrafficLightColor

case object Red extends TrafficLightColor

case object Yellow extends TrafficLightColor

case object Green extends TrafficLightColor
