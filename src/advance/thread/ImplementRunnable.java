package advance.thread;

public class ImplementRunnable implements Runnable {
    private Thread thread;

    private String threadName;

    public ImplementRunnable(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);

            if (threadName.equals("Thread-1")) {
                thread.setPriority(Thread.MAX_PRIORITY);
            }

            if (threadName.equals("Thread-2")) {
                thread.setPriority(2);
            }

            thread.start();
        }
    }
}

class TestThread {

    public static void main(String args[]) {
        ImplementRunnable R1 = new ImplementRunnable("Thread-1");
        R1.start();

        ImplementRunnable R2 = new ImplementRunnable("Thread-2");
        R2.start();
    }
}
