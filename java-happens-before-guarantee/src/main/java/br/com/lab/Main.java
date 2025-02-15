package br.com.lab;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		SharedResource r = new SharedResource();
		
		Thread t1 = new Thread(() -> {
			for (int i=0;i<10;i++) {
				System.out.println("[t1] exec...");
				r.increment();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			while (r.getI() == 0) {};
			
			for (int i=0;i<10;i++) {
				System.out.println("[t2] " + r.getI());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
