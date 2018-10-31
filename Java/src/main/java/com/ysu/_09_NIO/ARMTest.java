package com.ysu._09_NIO;

import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7中新增的 自动资源管理
 * created by bing57592
 * 2018-10-30 17:26
 */
public class ARMTest {


    @Test
    public void test2() throws Exception {
        File file = MyIOUtils.initFile();
        try (FileInputStream fis = new FileInputStream(file);// 创建IO流的操作, 必须要在try()中
             FileOutputStream fos = new FileOutputStream(file)) {
            System.out.println(fis);
            System.out.println(fos);
        } catch (Exception e) {
        }
    }

    /**
     * JDK7 之前, 常规的关闭IO流的try-catch 操作.
     */
    @Test
    public void test1() {
        File file = MyIOUtils.initFile();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
