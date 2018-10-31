package com.ysu._09_NIO;


import org.junit.Test;

import java.nio.ByteBuffer;


/**
 * 一、NIO的使用中两个重要的要素：缓冲区(Buffer)、通道(Channel)
 * 缓冲区(Buffer):存储数据的。   ---->byte[] buffer = new byte[1024]
 * 通道(Channel)：代表着数据源与目标节点之间的连接，负责缓冲区的传输。 --->IO流
 * <p>
 * 二者的交互：Java NIO 中的 Buffer 主要用于与 NIO 通道(Channel)进行交互，
 * 数据是从通道读入缓冲区，从缓冲区写入通道中的。
 * <p>
 * <p>
 * 二、缓冲区（Buffer）的结构 (除boolean之外)
 * java.nio.Buffer抽象类
 * |----ByteBuffer
 * |----CharBuffer
 * <p>
 * |----ShortBuffer
 * |----IntBuffer
 * |----LongBuffer
 * |----FloatBuffer
 * |----DoubleBuffer
 * XxxBuffer底层使用xxx[]进行存储。
 * <p>
 * 三、如何实例化缓冲区？调用缓冲区类XxxBuffer的静态方法：allocate(int capacity)
 * 举例：ByteBuffer byteBuffer = ByteBuffer.allocate(10);byte[] hb = new byte[10];
 * 类似：ArrayList list = new ArrayList(10);//Object[] eleData = new Object[10];
 * 说明：方法的形参，决定了底层创建的数组的长度
 * <p>
 * 四、Buffer中的常用属性：
 * capacity:容量，决定了底层数组的长度，表明了最大存储数据的容量
 * limit:限制，默认情况下，limit等于capacity.在读数据模式下，limit<=capacity.表明最大可以读取数据的量
 * position:位置，表明了当前读取或写入数据的位置
 * mark:标记。默认值为-1.
 * <p>
 * 关系式：mark <= position <= limit <= capacity
 * <p>
 * 类比：项目三中TeamService类中的属性：
 * private final int MAX_MEMBER = 5;//相当于capacity
 * private Programmer[] team = new Programmer[MAX_MEMBER];//Buffer底层封装的数组
 * private int total;//相当于limit
 * index:读取、写入数组指定为的索引：position
 * <p>
 * 五、Buffer中的常用方法：
 * 1）最基本的两个方法：put(Xxx xxx) / get()
 * 2）其他方法：见ppt中的表格即可。
 * <p>
 * 六、针对于ByteBuffer来讲，可以创建非直接缓冲区：allocate(int capacity)
 * 直接缓冲区：allocateDirect(int capacity) / FileChannel 的 map()
 * <p>
 * 了解非直接缓冲区 与 直接缓冲区的区别
 *
 * @author shkstart 邮箱：shkstart@126.com
 * @version 创建时间：2017年8月11日  上午10:27:52
 */
public class BufferTest {

    @Test
    public void test3() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("hello".getBytes());

        //array():返回缓冲区底层的数组
        byte[] array = byteBuffer.array();
        System.out.println(array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //isDirect():判断此时的字节缓冲区是否是直接缓冲区
        System.out.println(byteBuffer.isDirect());
    }

    @Test
    public void test2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("hello".getBytes());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.flip();
        byte[] dst = new byte[5];
        byteBuffer.get(dst, 0, 2);//从数组角标0开始，写入两个字节的数组
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("***********mark()***************");
        byteBuffer.mark();//标记当前position的位置

        byteBuffer.get(dst, 2, 2);//从数组角标2开始，写入两个字节的数组
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

//		byteBuffer.rewind();//position = 0;
        //reset():此方法必须要配合着mark()使用。调用此方法其调用mark(),否则抛异常。
        byteBuffer.reset();//position = mark;即为将position置为标记的位置


        if (byteBuffer.hasRemaining()) {//判断是否还有元素没有读取到。
            System.out.println(byteBuffer.remaining());//还有几个没有读取到。
        }
        System.out.println();

        while (byteBuffer.hasRemaining()) {
            System.out.println((char) byteBuffer.get());
        }


    }


    @Test
    public void test1() {
        System.out.println("*********allocate(10)************");
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//		CharBuffer charBuffer = CharBuffer.allocate(10);

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("*********put()************");
        byteBuffer.put("hello".getBytes());//写入长度为5的字节数.每put一个字节，position就+1

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("*********flip()************");
        byteBuffer.flip();//切换为读数据模式。将limit设置为position，position归零

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("*********get()************");
        //方式一：
//		System.out.println((char)byteBuffer.get());//每get一个字节，position也自动+1
//		System.out.println((char)byteBuffer.get());

        //方式二：
        byte[] dst = new byte[3];
        byteBuffer.get(dst);

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());


//		System.out.println("*********rewind()************");
//		byteBuffer.rewind();//重置position
//		System.out.println(byteBuffer.capacity());
//		System.out.println(byteBuffer.limit());
//		System.out.println(byteBuffer.position());


        System.out.println("*********clear()************");
        byteBuffer.clear();//清空.将position归零，limit设置为capacity.数据并未删除。
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println((char) byteBuffer.get());
    }
}