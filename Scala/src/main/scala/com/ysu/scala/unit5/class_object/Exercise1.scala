package com.ysu.scala.unit5.class_object

/**
  * 1. 在Frock类中声明私有的静态属性currentNum，初始值为100000，作为衣服出厂的序列号起始值。
  * 2. 声明公有的静态方法getNextNum，作为生成上衣唯一序列号的方法。每调用一次，将currentNum增加100，并作为返回值。
  * 3. 在TestFrock类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。
  * 4. 在Frock类中声明serialNumber(序列号)属性，并提供对应的get方法；
  * 5. 在Frock类的构造器中，通过调用getNextNum方法为Frock对象获取唯一序列号，赋给serialNumber属性。
  * 6. 在TestFrock类的main方法中，分别创建三个Frock 对象，并打印三个对象的序列号，验证是否为按100递增。
  *
  * @Author bing57592
  * @Date 2018-12-06 23:02
  *
  */
object Exercise {
  def main(args: Array[String]): Unit = {
    var frock1 = new Frock(Frock.getNextNum())
    var frock2 = new Frock(Frock.getNextNum())
    var frock3 = new Frock(Frock.getNextNum())

    var frockApply = Frock(123);

    println(Array(frock1, frock2, frock3).mkString(", "))
  }
}


