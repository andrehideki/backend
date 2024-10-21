package multtasking;

public class UsingThreadExtension {

    static class ThreadDemo extends Thread {
        private String name;

        public ThreadDemo(String name) {
            this.name = name;
            System.out.println("Creting thread: " + name);
        }

        @Override
        public void run() {
            System.out.println("Running thread: " + this.name);
            try {
                for(int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + this.name + ", " + i);
                    // Let the thread sleep for a while.
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " +  this.name + " interrupted.");
            }
            System.out.println("Thread " +  this.name + " exiting.");
        }

        @Override
        public void start() {
            System.out.println("Starting Thread " +  this.name + " exiting.");
            super.start();
        }
    }
    public static void main(String[] args) {
        ThreadDemo demo1 = new ThreadDemo("Thread-1");
        ThreadDemo demo2 = new ThreadDemo("Thread-2");
        demo1.start();
        demo2.start();
    }
}

