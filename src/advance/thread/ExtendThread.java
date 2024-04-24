package advance.thread;

public class ExtendThread extends Thread{

    public ExtendThread(String threadName) {
        // Gọi constructor của lớp cha để đặt tên cho luồng
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + getName());
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + getName() + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrupted.");
        }
        System.out.println("Thread " + getName() + " exiting.");
    }

    public static void main(String[] args) {
        ExtendThread thread1 = new ExtendThread("Thread-1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        ExtendThread thread2 = new ExtendThread("Thread-2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}