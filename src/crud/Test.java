package crud;

import java.util.Scanner;

public class Test {
    private Scanner sc = new Scanner(System.in);

    public void SetAge() throws AgeException{
        System.out.print("Nhap tuoi: ");

        int age = sc.nextInt();

        if(age < 18){
            throw new AgeException("Chua du 18 tuoi!");
        }

        System.out.println("Da du 18 tuoi!");
    }

    public static void main(String[] args) throws AgeException {
        Test t = new Test();
        t.SetAge();
    }
}
