import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    public static void Scanner(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();

        System.out.println("Nhap tuoi: ");
        int age = scanner.nextInt();

        System.out.println("Nhap chieu cao: ");
        double height = scanner.nextDouble();

        System.out.println("Ten: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Chieu cao: " + height);

        scanner.close();
    }

    public static void BufferedRender() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nhap ten:" );
        String name = reader.readLine();

        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(reader.readLine());

        System.out.println("Nhap chieu cao: ");
        double height = Double.parseDouble(reader.readLine());

        System.out.println("Ten la: " + name);
        System.out.println("Tuoi la: " + age);
        System.out.println("Chieu cao: " + height);

        reader.close();
    }

    public static void Console(){
        Console console = System.console();

        if (console == null) {
            System.out.print("Console khong san sang");
            return;
        }

        System.out.println("Nhap mat khau: ");
        char[] passwordChars = console.readPassword();

        String password = String.valueOf(passwordChars);
        System.out.println("Mat khau la: " + password);
    }

    public static void main(String[] args) throws IOException {
//        Scanner();
//        BufferedRender();
//        Console();
    }
}
