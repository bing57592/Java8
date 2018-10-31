package com.ysu._09_NIO;

/**
 * created by bing57592
 * 2018-10-30 21:36
 */


import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、java.nio.channels.Channel接口
 * Channel:不负责存储数据，数据存储在Buffer中，Channel负责Buffer的传输
 * <p>
 * 二、
 * java.nio.channels.Channel
 * |-----FileChannel:处理本地文件
 * |-----SocketChannel：TCP网络编程的客户端的Channel
 * |-----ServerSocketChannel:TCP网络编程的服务器端的Channel
 * |-----DatagramChannel：UDP网络编程中发送端和接收端的Channel
 * |-----Pipe.SinkChannel
 * |-----Pipe.SourceChannel
 * <p>
 * 三、如何实例化Channel
 * 方式一：调用相关结构的getChannel()
 * FileInputStream / FileOutputStream / RandomAccessFile ----> FileChannel
 * Socket(TCP) --->SocketChannel
 * ServerSocket ---->ServerSocketChannel
 * DatagramSocket(UDP) --->DatagramChannel
 * 说明：Channel可以是单向的，也可以是双向的。
 * <p>
 * 方式二：XxxChannel的静态方法：open().
 * <p>
 * 方式三：Files工具类的静态方法：newByteChannel() 得到的是字节通道。
 * <p>
 * 说明：方式二和方式三在jdk7.0新增的。
 * <p>
 * 四、Channel的常用方法：读：read(ByteBuffer buffer) / write(ByteBuffer buffer)
 *
 * @author shkstart 邮箱：shkstart@126.com
 * @version 创建时间：2017年8月11日  下午2:38:37
 */
public class ChannelTest {


    @Test
    public void test4() throws Exception {

        RandomAccessFile readRaf = new RandomAccessFile("EclipseKeys.java", "r");
        RandomAccessFile writeRaf = new RandomAccessFile("EclipseKeys1.java", "rw");

        //实例化Channel
        FileChannel inChannel = readRaf.getChannel();
        FileChannel outChannel = writeRaf.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(2048);
        ByteBuffer[] dsts = {buffer1, buffer2};

        inChannel.read(dsts);//分散读取

        //改为可读模式
        buffer1.flip();
        buffer2.flip();
        System.out.println(new String(buffer1.array(), 0, buffer1.limit()));
        System.out.println();
        System.out.println(new String(buffer2.array(), 0, buffer2.limit()));

        //测试聚集写入
        outChannel.write(dsts);


        outChannel.close();
        inChannel.close();
    }

    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("Dilraba.jpg"), StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(Paths.get("mm1.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //transferTo():将数据从可读的Channel中转换到可写的Channel中
//		inChannel.transferTo(0, inChannel.size(), outChannel);
        //transferFrom():将数据从可读的Channel中转换到可写的Channel中
        outChannel.transferFrom(inChannel, 0, inChannel.size());


        inChannel.close();
        outChannel.close();

    }

    //使用Channel实例化的方式二，使用直接缓冲区，实现文件的复制
    @Test
    public void test2() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            long start = System.currentTimeMillis();

//			String srcPath = "Dilraba.jpg";
//			String destPath = "Dilraba3.jpg";


            String srcPath = "C:\\Users\\Administrator\\Desktop\\score\\战狼.mp4";
            String destPath = "C:\\Users\\Administrator\\Desktop\\score\\战狼1.mp4";


            //实例化Channel
            inChannel = FileChannel.open(Paths.get(srcPath), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get(destPath), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            //得到直接缓冲区
            MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());//size():返回操作的文件的大小
            MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

            //数据的读写操作
            byte[] buffer = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(buffer);
            outMappedBuffer.put(buffer);


            long end = System.currentTimeMillis();
            System.out.println("直接缓冲区花费的时间：" + (end - start));//1929-1894


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (outChannel != null) {

                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    //使用Channel实例化的方式一，使用非直接缓冲区，实现文件的复制操作
    @Test
    public void test1() throws Exception {
        // FileChannel inChannel = null;
        // FileChannel outChannel = null;
        // FileInputStream fis = null;
        // FileOutputStream fos = null;
        File file = MyIOUtils.initFile();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file);

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = inChannel.read(buffer);
        while (len != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        MyIOUtils.closeStream(inChannel);
    }
}

