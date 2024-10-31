package multtasking;

public class VolatileTest {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int localCounter = counter;
            while (localCounter < 10) {
                if (localCounter != counter) {
                    System.out.println("t1 local counter changed: " + counter);
                }
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        Thread t2 = new Thread(() -> {
            int localCounter = counter;
            while (localCounter < 10) {
                System.out.println("t2: " + localCounter);
                counter = ++localCounter;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        t1.start();
        t2.start();
    }
}
