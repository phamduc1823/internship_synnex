package oop.abstraction;

public class HinhVuong extends HinhHoc{
    double canh;

    public HinhVuong(double canh) {
        this.canh = canh;
    }

    @Override
    public void tinhDienTich() {
        double dienTich = canh * canh;
        System.out.println("Diện tích hình vuông: " + dienTich);
    }
}
