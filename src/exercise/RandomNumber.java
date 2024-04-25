package exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber extends Thread {
    /*
    * Viết 1 chương trình chạy real-time, ghi các số nguyên random ra file output.txt.
    * Dừng chương trình khi gõ lệnh stop trên cửa sổ chương trình.
    */

    @Override
    public void run() {
        String path = "src/exercise/output.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Random rand = new Random();

        while (true){
            int number = rand.nextInt(100);

            try {
                fos.write(String.valueOf(number+" ").getBytes());
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        RandomNumber rn = new RandomNumber();
        rn.start();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Nhap 'stop' de dung chuong trinh: ");
            String text = sc.next();

            if (text.equals("stop")){
                System.out.println("Da dung chuong trinh!");
                System.exit(0);
            }
        }
    }
}
