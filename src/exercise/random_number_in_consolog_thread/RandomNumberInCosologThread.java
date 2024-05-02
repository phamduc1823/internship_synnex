package exercise.random_number_in_consolog_thread;

import java.util.*;

public class RandomNumberInCosologThread extends Thread{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input minute: ");
        float minutes = scanner.nextFloat();
        scanner.close();

        Random rand = new Random();
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                if (count >= minutes * 60) {
                    timer.cancel();
                    setFlag(false);
                }
            }
        };

        timer.schedule(task, 0, 1000);

        while(flag){
            try {
                System.out.println(rand.nextInt(100));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        RandomNumberInCosologThread thread = new RandomNumberInCosologThread();
        thread.start();
    }
}
