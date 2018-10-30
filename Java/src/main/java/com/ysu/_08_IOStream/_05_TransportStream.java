package com.ysu._08_IOStream;

import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.*;

/**
 * 转换流: 能够实现字节和字符的相互转换
 * ** InputStreamReader:   字节流 --> 字符流  ==>  解码的过程
 * ** OutputStreamReader:  字符流 --> 字节流  ==>  编码的过程
 * *********
 * ** 编码的过程:
 * ** 解码的过程:
 * created by bing57592
 * 2018-10-30 11:21
 */
public class _05_TransportStream {

    /**
     * 以GBK的方式将文件读取到内存中, 然后以UTF-8的方式将文件保存下来
     *
     * @throws Exception
     */
    @Test
    public void testGBK2UTF8() throws Exception {
        File file = new File("IOStreamFiles/hello_gbk.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        FileOutputStream fos = new FileOutputStream(MyIOUtils.initFile());
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

        char[] cbuf = new char[1024];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        MyIOUtils.closeStream(osw, fos, isr, fis);
    }

    @Test
    public void testInputStreamReader() throws Exception {
        File file = MyIOUtils.initFile();
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//默认编码集: UTF-8
        char[] charBuffer = new char[1024];
        while ((len = isr.read(charBuffer)) != -1) {
            String str = new String(charBuffer, 0, len);
            System.out.println(str);
        }
        MyIOUtils.closeStream(isr);
        MyIOUtils.closeStream(fis);

    }
}
