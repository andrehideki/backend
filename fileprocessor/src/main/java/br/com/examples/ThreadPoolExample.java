package br.com.examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExample {
	
	public static class Task implements Runnable {
		private String name;
		public static final int ITERATION_TIMES = 5;
		public Task(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			for (int i=0; i<ITERATION_TIMES;i ++) {
				String value = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
				if (i == 0) {
					System.out.printf("Initialization[%s]: %s\n", this.name, value);
				} else {
					System.out.printf("Executing[%s]: %s\n", this.name, value);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Completed");
		}
	}
	
	public static void main(String[] args) {
		Runnable t1 = new Task("Task 1");
		Runnable t2 = new Task("Task 2");
		Runnable t3 = new Task("Task 3");
		Runnable t4 = new Task("Task 4");
		Runnable t5 = new Task("Task 5");
		
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
//		threadPool.execute(t1);
//		threadPool.execute(t2);
//		threadPool.execute(t3);
//		threadPool.execute(t4);
//		threadPool.execute(t5);
		
		Future<?> submit = threadPool.submit(t1);
		Future<?> submit2 = threadPool.submit(t2);
		Future<?> submit3 = threadPool.submit(t3);
		Future<?> submit4 = threadPool.submit(t4);
		Future<?> submit5 = threadPool.submit(t5);
		System.out.println(submit);
	}
}
