package com.ysu._14_seat;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author bing57592
 * @Date 2018-11-20 08:19
 */
public class HttpUrl {
    public static void main(String[] args) {

        String str = "http://202.206.242.87/ClientWeb/pro/ajax/reserve.aspx?" +
                "dialogid=" +
                "&dev_id=101439505" + //101440371
                "lab_id=&kind_id=" +
                "&room_id=" +
                "&type=dev" +
                "&prop=" +
                "&test_id=" +
                "&term=" +
                "&test_name=" +
                "&start=2018-11-20+12%3A10" +
                "&end=2018-11-20+22%3A20" +
                "&start_time=1210&end_time=2220" +
                "&up_file=" +
                "&memo=" +
                "&act=set_resv" +
                "&_=1542673098915";

        String str2 = "ASP.NET_SessionId=mjt1vs45u13nko45nbrjpzng";
        str.notify();
        str.notifyAll();


        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
