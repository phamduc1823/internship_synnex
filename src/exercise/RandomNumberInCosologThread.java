package exercise;

import java.util.Random;

public class RandomNumberInCosologThread extends Thread{
    @Override
    public void run() {
        Random rand = new Random();

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(rand.nextInt(100));
        }
    }
}

class Main{
    public static void main(String[] args) {
        RandomNumberInCosologThread thread = new RandomNumberInCosologThread();
        thread.start();
    }
}
