package com.ysu._01_jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * created by bing57592
 * 2018-10-15 13:52
 */
public class _01_HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
            list.add(new OOMObject());
        }
    }
}
