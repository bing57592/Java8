package com.ysu._08_iostream;

import com.ysu._00_common.util.MyIOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * FileReader 和 FileWriter的使用: 用来处理文本文件.
 * <p>
 * FileInputStream 和 FileOutputStream 适合处理非文本文件
 * created by bing57592
 * 2018-10-30 09:58
 */
public class _03_FileReaderWriterTest {

    @Test
    public void testFileWriter() throws Exception {
        File file = new File("IOStreamFiles/hello.txt");
        FileWriter fw = new FileWriter(file, true);
        String str = "热爱祖国, 热爱人民, 热爱中国共产党\n";
        fw.write(str);
        MyIOUtils.closeStream(fw);
    }

    @Test
    public void testFileReader() throws Exception {
        File file = new File("IOStreamFiles/hello.txt");
        FileReader fr = new FileReader(file);
        char[] buffer = new char[10];
        int read = fr.read();
        System.out.println(read);
        int len = fr.read(buffer);
        while (len != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
            len = fr.read(buffer);
        }
        MyIOUtils.closeStream(fr);
    }
}
