package br.com.lab;

public class SharedResource {
	
	private int i = 0;
	
	public void increment() {
		this.i++;
	}
	
	public int getI() {
		return this.i;
	}
}
