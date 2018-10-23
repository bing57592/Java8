/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu._02_thread.lock;

import com.ysu._00_common.util.MyLogUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by 陈宪东 on 2018/10/23 14:42
 */
public class LockDemo {

    @Test
    public void testLog() {
        Logger logger = MyLogUtils.getLogger();
        logger.info("hello");
    }

    @Test
    public void test1() throws Exception {
        UnReentrantLock unReentrantLock = new UnReentrantLock();
        unReentrantLock.lock();
    }

    private void dosome() {
        System.out.println("");
    }
}
