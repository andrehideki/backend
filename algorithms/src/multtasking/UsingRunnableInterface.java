package multtasking;

public class UsingRunnableInterface {

    static class RunnableDemo implements Runnable {
        private String name;
        private Thread thread;

        public RunnableDemo(String name) {
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

        public void start() {
            System.out.println("Starting Thread " +  this.name + " exiting.");
            if (thread == null) {
                thread = new Thread(this, this.name);
                thread.start();
            }
        }
    }
    public static void main(String[] args) {
        RunnableDemo demo1 = new RunnableDemo("Thread-1");
        RunnableDemo demo2 = new RunnableDemo("Thread-2");
        demo1.start();
        demo2.start();

        demo1.start();
    }
}

