package exercise;

import java.util.Scanner;

public class NhapSo {
    public static void main(String[] args) {
        int inputMax = 5;
        int number = 9;
        boolean flag = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Tim so dung ngau nhien tu 0-10 \n");


        for (int i = 1; i <= inputMax; i++) {
            System.out.println("Moi ban nhap so: ");
            int inputNumber = scanner.nextInt();

            if(inputNumber == number){
                flag = true;
                break;
            }else {
                System.out.println("So ban nhap khong dung!");
            }
        }

        if (flag) {
            System.out.println("Da nhap chinh xac!");
        } else {
            System.out.println("Da nhap qua so lan cho phep!");
        }

    }
}
