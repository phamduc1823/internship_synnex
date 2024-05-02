package exercise.tinh_tien_dien;

import java.util.Scanner;

public class TinhTienDien {
    public static void main(String[] args) {
        System.out.println("Tinh tien dien");
        System.out.println("Moi nhap so dien:");

        Scanner sc = new Scanner(System.in);
        int soDien = sc.nextInt();
        int tienDien;

        if (soDien <= 100) {
            tienDien = soDien * 1000;
        } else if (soDien <= 150) {
            tienDien = 100 * 1000 + (soDien - 100) * 1500;
        } else {
            tienDien = 100 * 1000 + 50 * 1500 + (soDien - 150) * 2000;
        }

        System.out.println("Tien dien can thanh toan: " + tienDien + " VND!");
    }
}
