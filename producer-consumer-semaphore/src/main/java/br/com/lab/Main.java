package br.com.lab;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		executorService.submit(producerRunnable);
//		executorService.submit(consumerRunnable);
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
