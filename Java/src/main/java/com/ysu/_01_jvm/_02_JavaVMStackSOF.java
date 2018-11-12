package com.ysu._01_jvm;

import com.ysu._00_common.util.MyStringUtils;

/**
 * VM Args: -Xss128k
 *
 * @Author bing57592
 * @Date 2018-11-06 20:50
 */
public class _02_JavaVMStackSOF {
    public int stackLength = 1;

    public static void main(String[] args) {
        _02_JavaVMStackSOF javaVMStackSOF = new _02_JavaVMStackSOF();
        try {

            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyStringUtils.println("虚拟机栈深度为 ? ", new Object[]{javaVMStackSOF.stackLength});
        }

    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
