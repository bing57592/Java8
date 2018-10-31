package com.ysu._09_NIO;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * created by bing57592
 * 2018-10-30 17:06
 */
public class PathTest {

    // Path中的常用方法
    // String toString() ： 返回调用 Path 对象的字符串表示形式
    // boolean startsWith(String path) : 判断是否以 path 路径开始
    // boolean endsWith(String path) : 判断是否以 path 路径结束
    // boolean isAbsolute() : 判断是否是绝对路径
    // Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
    // Path getRoot() ：返回调用 Path 对象的根路径
    // Path getFileName() : 返回与调用 Path 对象关联的文件名
    // int getNameCount() : 返回Path 根目录后面元素的数量
    // Path getName(int idx) : 返回指定索引位置 idx 的路径名称
    // Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
    // Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
    // File toFile(): 将Path转化为File类的对象

    @Test
    public void test2() {
        Path path1 = Paths.get("d:\\", "nio\\nio1\\nio2\\hello.txt");
        Path path2 = Paths.get("hello.txt");
    }


    //如何使用Paths实例化Path
    @Test
    public void test1() {
        Path path1 = Paths.get("d:\\nio\\hello.txt");//new File(String filepath)

        Path path2 = Paths.get("d:\\", "nio\\hello.txt");//new File(String parent,String filename);

        System.out.println(path1);
        System.out.println(path2);

        Path path3 = Paths.get("d:\\", "nio");
        System.out.println(path3);
    }
}
