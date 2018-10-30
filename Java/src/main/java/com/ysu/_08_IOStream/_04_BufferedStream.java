package com.ysu._08_IOStream;

import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 使用缓冲流, 包裹在节点外面, 提高处理速度.
 * 缓冲流是处理流的一种.
 * 类:
 * **BufferedInputStream
 * **BufferedOutputStream
 * **BufferedReader
 * **BufferedWriter
 * <p>
 * created by bing57592
 * 2018-10-30 10:29
 */
public class _04_BufferedStream {

    @Test
    public void testBufferedInputStream() throws Exception {
        File file = MyIOUtils.initFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        char[] buffer = new char[10];
        int len = br.read(buffer);
        while (len != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
            len = br.read(buffer);
        }
        MyIOUtils.closeStream(br);
        MyIOUtils.closeStream(fr);
    }
}
