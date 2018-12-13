package com.ysu.scala.unit5.class_object

/**
  * 类与对象
  *
  * @Author bing57592 
  * @Date 2018-12-06 22:29
  */
object Main {
  def main(args: Array[String]): Unit = {
    Child.objectMethod() // 伴生类 调用 半生对象中定义的方法(属性)
    var user = new Child
    user.classMethod() // 伴生类的实例 调用 伴生类中定义的方法(属性)


  }
}

