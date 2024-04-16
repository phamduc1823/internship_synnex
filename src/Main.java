import oop.*;
import oop.animal.*;
import oop.abstraction.*;
import oop.interfacee.*;

public class Main {
    public static void main(String[] args) {
        Polymorphism polymorphism = new Polymorphism();
        //overloading
        int result = polymorphism.tinhTong(1,2, 5);
//        System.out.println(result);

        //overriding && ke thua
        Animal animal = new Animal();
//        animal.animalSound();
        Dog dog = new Dog();
//        dog.animalSound();

        //Truu tuong abstract
        HinhVuong hinhVuong = new HinhVuong(3);
//        hinhVuong.tinhDienTich();
        HinhTamGiac hinhTamGiac = new HinhTamGiac(3, 4);
//        hinhTamGiac.tinhDienTich();

        //Truu tuong interface
        NgoiNha ngoiNha = new NgoiNha();
        ngoiNha.color();
        AoSoMi aoSoMi = new AoSoMi();
        aoSoMi.color();
    }
}

