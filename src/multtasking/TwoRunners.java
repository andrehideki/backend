package multtasking;

public class TwoRunners {

    public static class Runner implements Runnable {
        private boolean winner;
        private final String name;
        private final Race race;
        private Thread thread;

        public Runner(String name, Race race) {
            this.name = name;
            this.race = race;
        }


        @Override
        public void run() {
            if ("stoped".equals(this.race.state)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if ("started".equals(this.race.state)) {
                this.race.finishRace();
            }

            if ("finished".equals(this.race.state)) {
                winner = false;
            }
        }

        public void start() {
            thread = new Thread(this);
            thread.start();
        }
    }

    public static class Race implements Runnable {
        private String state;

        @Override
        public void run() {
            this.state = "started";
            notifyAll();
        }

        public void start() {
            Thread thread = new Thread(this);
            thread.start();
        }

        public void finishRace() {
            this.state = "finished";

        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        Runner runner1 = new Runner("Runner-1", race);
        Runner runner2 = new Runner("Runner-1", race);
    }
}
