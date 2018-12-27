package com.ysu._15_zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author bing57592
 * @Date 2018-12-24 21:44
 */
public class Main {
	public static int OUTTIME = 200000;
	public static String EXERCISE_PATH = "/root";

	public static void main(String[] args) {
		ZooKeeper zk = null;

		Watcher watcher = new Watcher() {
			public void process(WatchedEvent event) {
				System.out.println(event.toString());
			}
		};
		try {
			zk = new ZooKeeper("127.0.0.1:2181", OUTTIME, watcher);
			System.out.println(zk);
			//zk.create(EXERCISE_PATH, "myData2".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
			zk.getData(EXERCISE_PATH, watcher, null);
			zk.setData(EXERCISE_PATH, "1234".getBytes(), -1);
			byte[] data = zk.getData(EXERCISE_PATH, false, null);
			String s = new String(data);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (zk != null) {
				try {
					zk.close();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}



}
