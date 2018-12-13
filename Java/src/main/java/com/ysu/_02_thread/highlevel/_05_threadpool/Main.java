package com.ysu._02_thread.highlevel._05_threadpool;

import com.ysu._00_common.util.MyMathUtils;
import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Java进行多线程操作的第四种方式: 线程池ThreadPool
 * Collections, Arrays, Executors
 * <p>
 * created by bing57592
 * 2018-11-04 17:39
 */

public class Main {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>();

		Future<String> future = executorService.submit(() -> "");
		String str = future.get();

		executorService.submit(() -> {
		});
		ExecutorCompletionService completionService = new ExecutorCompletionService(executorService);
		Future<Integer> submit = null;
		try {
			for (int i = 0; i < 10; i++) {
				final int index = i;
				/**
				 * 虽然这里用多线程实现了功能, 但是本质还是串行的.
				 */
				submit = completionService.submit(() -> {
					MyStringUtils.print("当前线程: ? ", new Object[]{Thread.currentThread().getName()});
					MyThreadUtils.sleep(MyMathUtils.randomInt(1000, 2000));
					return MyMathUtils.randomInt(10, 20);
				});
				System.out.println(submit.get());
			}
			for (int i = 0; i < 10; i++) {
				completionService.poll();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}
