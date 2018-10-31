package com.ysu._08_IOStream;

import com.ysu._00_common.util.MyIOUtils;
import com.ysu._00_common.util.MyStringUtils;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 流的分类:
 * 1. 流的流向: 输入流, 输出流
 * 2. 流中数据单位: 字节流, 字符流
 * 3. 流的角色不同: 节点流, 处理流
 * <p>
 * **********
 * <p>
 * 抽象基类              节点流(或文件流)           缓冲流(处理流的一种)
 * InputStream          FileInputStream          BufferedInputStream
 * OutputStream         FileOutputStream         BufferedOutputStream
 * Reader               FileReader               BufferedReader
 * Writer               FileWriter               BufferedWriter
 * **********
 * <p>
 * created by bing57592
 * 2018-10-30 00:56
 */
public class _01_FileInputOutStreamTest {
    /**
     * FileInputStream 在使用完以后，不关闭流，想二次使用可以怎么操作？
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        File file = MyIOUtils.initFile();
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.mark(0);
        MyIOUtils.readInputStream(fis);
        MyStringUtils.line();


        try {
            bis.reset();
            MyIOUtils.readInputStream(bis);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyIOUtils.closeStream(bis, fis);
        }
    }


    /**
     * 通过byte[5]数组做缓存, 提高效率.
     *
     * @throws Exception
     */
    @Test
    public void testFileOutputStream2() throws Exception {
        //1. 创建一个文件对象
        File file = new File("/Users/bing57592/Documents/code/Java8/Java/src/main/resources/IOStreamFile/hello.txt");
        //2. 将file对象作为参数传递到流的构造器中, 创建一个字节的输入流.
        FileInputStream fis = new FileInputStream(file);
        //3. 创建缓冲区:
        byte[] buffer = new byte[5];
        //4. read(): 读取文件中的下一个字节, 如果到达文件末尾的话, 则返回-1
        int len = fis.read(buffer);
        // 记录每次读入到buffer中字节的个数
        while (len != -1) {
            for (int i = 0; i < len; i++) {
                char c = (char) buffer[i];
                System.out.print(c);
            }
            len = fis.read(buffer);// 进行下一次读取
        }
        System.out.println();
        fis.close();
    }

    /**
     * 从指定文件读取数据到控制台.
     * 1. 要读取的文件一定要存在, 否则报错FileNotFoundException
     * 2. 因为需要保证流的资源关闭, 需要使用try-catch-finally
     *
     * @throws Exception
     */
    @Test
    public void testFileInputStream() throws Exception {
        //1. 创建一个文件对象
        File file = new File("/Users/bing57592/Documents/code/Java8/Java/src/main/resources/IOStreamFile/hello.txt");
        //2. 将file对象作为参数传递到流的构造器中, 创建一个字节的输入流.
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        //3. read(): 读取文件中的下一个字节, 如果到达文件末尾的话, 则返回-1
        int bit = bis.read();
        while (bit != -1) {
            System.out.print((char) bit);
            bit = bis.read();// 进行下一次读取
        }

        System.out.println();
        MyStringUtils.line();
        try {

            bis.reset();
            bit = bis.read();
            while (bit != -1) {
                System.out.print((char) bit);
                bit = bis.read();// 进行下一次读取
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyIOUtils.closeStream(bis, fis);
        }
    }
}
