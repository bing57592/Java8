package com.ysu.scala.unit6.base

/**
  *
  * created by bing57592     
  * 2018-09-11 21:07
  */
abstract class Item

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, discount: Double, item: Item*) extends Item

