package exercise.thread.doan_so_thread;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberThread{
    private Random random;
    private Scanner scan;

    public RandomNumberThread(){
        this.random = new Random();
        this.scan = new Scanner(System.in);
    }

    public void threadRandomNumber() {
        System.out.println("Enter my number 0 - 10: ");
        int inputNumber = scan.nextInt();

        Thread thread1 = new Thread(() -> {
            int i = 1;
            while(true){
                int number = random.nextInt(10);
                if(inputNumber == number){
                    System.out.println("So cua ban la " + number + "\nTong so lan doan: " + i);
                    break;
                }else {
                    System.out.println("Thread 1 doan so: " + number);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });

        Thread thread2 = new Thread(() -> {
            int i = 1;
            while(true){
                int number = random.nextInt(10);
                if(inputNumber == number){
                    System.out.println("So cua ban la " + number + "\nTong so lan doan: " + i);
                    break;
                }else {
                    System.out.println("Thread 2 doan so: " + number);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        RandomNumberThread randomNumberThread = new RandomNumberThread();
        randomNumberThread.threadRandomNumber();
    }
}
