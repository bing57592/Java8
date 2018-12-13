package com.ysu.scala.unit5.class_object

/**
  * 伴生类和伴生对象
  *
  * @Author bing57592 
  * @Date 2018-12-06 22:52
  */
/**
  * object User 是伴生对象
  * 从语法角度来讲, 所谓的伴生对象其实就是类的静态方法和成员 (属性?) 的集合.
  * scala没有生成静态的内容, 只是伴生对象生成了一个新的类, 实现属性的get方法调用
  */
object Child {
  /**
    * 伴生对象中声明的方法, 类比成静态方法, 可以通过 伴生类.方法名称 来调用
    */
  def objectMethod(): Unit = {
    println("objectMethod")
  }
}

/**
  * class User 是伴生类
  */
class Child extends Father with Trait1 with Trait2 with Trait3 {
  /**
    * 伴生类中声明的方法, 只能通过 对象.方法名称 来调用
    */
  def classMethod(): Unit = {
    println("classMethod")
  }
}
