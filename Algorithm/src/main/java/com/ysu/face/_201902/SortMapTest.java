package com.ysu.face._201902;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * created by bing57592
 * 2019-02-13 12:32
 */


public class SortMapTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("F:/test/source.txt"));
        List<String> lists = new ArrayList<String>(); // 存储过滤后单词的列表
        String readLine = null;
        while ((readLine = br.readLine()) != null) {
            String[] wordsArr1 = readLine.split("[^a-zA-Z]"); // 过滤出只含有字母的
            for (String word : wordsArr1) {
                if (word.length() != 0) { // 去除长度为0的行
                    lists.add(word);
                }
            }
        }

        br.close();

        Map<String, Integer> wordsCount = new TreeMap<String, Integer>(); // 存储单词计数信息，key值为单词，value为单词数

        // 单词的词频统计
        for (String li : lists) {
            if (wordsCount.get(li) != null) {
                wordsCount.put(li, wordsCount.get(li) + 1);
            } else {
                wordsCount.put(li, 1);
            }

        }

        // 对map利用key排序
        Map<String, Integer> resMap = sortMapByKey(wordsCount);

        for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 让 Map按key进行排序
     */
    public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        //Map<String, Integer> sortMap = new TreeMap<String, Integer>();//默认按照字典的升序排序.
        Map<String, Integer> sortMap = new TreeMap<>(new MapKeyComparator());//默认按照字典的升序排序.
        sortMap.putAll(map);
        return sortMap;
    }

    @Test
    public void test() throws Exception{
        Map<String, Integer> sortMap = new TreeMap<String, Integer>((a, b)-> a.compareTo(b));
        System.out.println(sortMap);
    }
}

// 实现一个比较器类

class MapKeyComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s1.compareTo(s2); // 从小到大排序
    }

}
