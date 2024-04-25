package advance;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Thread printingThread = new Thread(() -> {
            int count = 1;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(count++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        printingThread.start();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("s")) {
                printingThread.interrupt();
                break;
            }
        }
    }
}