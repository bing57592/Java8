package com.ysu._00_common.util;

import java.io.*;

/**
 * 通用的关闭流的操作
 * created by bing57592
 * 2018-10-30 09:51
 */
public class MyIOUtils {
    public static File initFile() {
        return new File("IOStreamFiles/hello.txt");
    }

    public static void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void closeStream(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStream(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStream(Closeable... stream) {
        for (int i = 0; i < stream.length; i++) {
            if (stream != null) {
                try {
                    stream[i].close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
