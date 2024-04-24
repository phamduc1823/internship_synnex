package advance;

class RunnableDemo implements Runnable {

    public Thread t;

    private String threadName;

    private Thread previousThread;

    public RunnableDemo(String name, Thread previousThread) {
        threadName = name;
        this.previousThread = previousThread;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        try {
            if (previousThread != null) {
                previousThread.join();
            }
            System.out.println("Running " + threadName);
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Dừng luồng trong 2 giây.
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {

        System.out.println("Starting " + threadName);

        if (t == null) {
            t = new Thread(this, threadName);
            t.setPriority(Thread.NORM_PRIORITY);
            t.start();
        }

    }

    public void setPriority(int priority) {
        if (t != null) {
            t.setPriority(priority);
        }
    }
}

class TestThread {

    public static void main(String args[]) {
        Thread previousThread = null;

        RunnableDemo R1 = new RunnableDemo("Thread-1", previousThread);
        R1.start();
        previousThread = R1.t;
        R1.setPriority(Thread.NORM_PRIORITY);

        RunnableDemo R2 = new RunnableDemo("Thread-2", previousThread);
        R2.start();
        previousThread = R2.t;
        R2.setPriority(Thread.MIN_PRIORITY);

        RunnableDemo R3 = new RunnableDemo("Thread-3", previousThread);
        R3.start();
        previousThread = R3.t;
        R3.setPriority(Thread.MAX_PRIORITY);
    }

}