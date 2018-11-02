package com.ysu._08_iostream;

import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * created by bing57592
 * 2018-10-30 09:17
 */
public class _02_FileOutputStreamTest {
    /**
     * 向文件中写入数据
     * 如果文件不存在, 则在输出执行过程中自动创建
     * 如果文件存在, 则会对文件内容进行覆盖
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        File file = new File("IOStreamFiles/hello.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileOutputStream fosAppened = new FileOutputStream(file, true); // 如果带着这个true, 表示在在已有文件上进行添加操作.
        String str = "SBYJ\n";
        fos.write(str.getBytes());
        fosAppened.write(str.getBytes());
        MyIOUtils.closeStream(fos);
        MyIOUtils.closeStream(fosAppened);
    }
}
