package com.ysu.scala.unit8

import com.ysu.scala.unit8.apply_unapply.Currency

/**
  * 模式匹配:
  * Scala中的模式匹配类似于Java中的switch语法, 但是更加强大.
  *
  * 模式匹配语法中, 采用match关键字声明, 每个分支采用case关键字进行声明. 当需要匹配时, 会从第一个case
  * 分支开始, 如果匹配成功, 那么执行对应的代码逻辑, 如果匹配不成功, 继续执行下一个分支进行判断. 如果
  * 所有case都不匹配, 那么会执行case_分支, 类似于Java中的default语句.
  *
  * 1. 如果所有case都不匹配, 那么会执行case_分支, 类似于Java中的default语句
  * 2. 如果所有acse都不匹配, 又没有写case_分支, 那么会抛出MatchError
  * 3. 每个case中, 不用break语句, 自动中断case
  * 4. 可以在match中使用其他类型, 而不仅仅是字符.
  * 5. => 等价于Java switch的 :
  * 6. => 后面的代码块到下一个case, 是作为一个整体执行, 可以使用{}括起来, 也可以不括
  *
  * @Author bing57592 
  * @Date 2018-12-10 12:18
  */
object Main {
    def main(args: Array[String]): Unit = {
        var v1 = Currency(15.0, "Hello")

        var res = v1 match {
            case Currency(v1) => v1
            case _ => "nothing"
        }
        println(res)
    }

    def method1 = {
        val oper = '#'
        val n1 = 20
        var n2 = 10
        var res = 0
        oper match {
            case '+' => res = n1 + n2
            case '-' => res = n1 - n2
            case '*' => res = n1 * n2
            case '/' => res = n1 / n2
            case _ => println("oper error")
        }

        println("res = " + res)
    }
}
