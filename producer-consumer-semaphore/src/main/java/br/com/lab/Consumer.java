package br.com.lab;

public class Consumer implements Runnable {

	private Buffer buffer;

	public Consumer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String content = buffer.take();
				System.out.println("[consumer]: consuming: " + content);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
