package br.com.lab;

import java.util.UUID;

public class Producer implements Runnable {
	
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String content = UUID.randomUUID().toString();
				buffer.put(content);
				System.out.println("[producer] producing content: " + content);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
