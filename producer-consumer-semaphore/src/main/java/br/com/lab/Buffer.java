package br.com.lab;

public class Buffer {

	private String content;

	public String getContent() {
		String temp = content;
		this.content = null;
		return temp;
	}

	
	public synchronized void put(String value) throws InterruptedException {
		while (content != null) {
			System.out.println("[buffer] content is full, waiting...");
			wait();
		}
		notifyAll();
		this.content = value;
	}
	
	public synchronized String take() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		String temp = this.content;
		this.content = null;
		notifyAll();
		return temp;
	}
	
	public boolean isEmpty() {
		return this.content == null;
	}
}
