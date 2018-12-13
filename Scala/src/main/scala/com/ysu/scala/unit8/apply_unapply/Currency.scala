package com.ysu.scala.unit8.apply_unapply

/**
  *
  * @Author bing57592 
  * @Date 2018-12-11 01:29
  */
class Currency(val value: Double, val unit: String) {

}

object Currency {

    def apply(value: Double, unit: String): Currency = new Currency(value, unit)

    def unapply(currency: Currency): Option[(Double, String)] = {
        if (currency == null) {
            None
        }
        else {
            Some(currency.value, currency.unit)
        }
    }

}