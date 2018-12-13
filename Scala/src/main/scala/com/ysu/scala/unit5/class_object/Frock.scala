package com.ysu.scala.unit5.class_object

/**
  *
  * @Author bing57592 
  * @Date 2018-12-06 23:04
  */
class Frock(n: Int) {
  var serialNumber = n

  def apply(n: Int): Frock = {
    println("伴生类")
    new Frock(n)
  }

  override def toString = s"Frock($serialNumber)"
}

object Frock {
  def apply(n: Int): Frock = {
    println("伴生对象")
    new Frock(n)
  }

  var currentNum: Int = 1000000

  def getNextNum(): Int = {
    currentNum += 100
    currentNum
  }
}