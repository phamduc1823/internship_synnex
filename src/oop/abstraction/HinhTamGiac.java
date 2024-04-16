package oop.abstraction;

public class HinhTamGiac extends HinhHoc{
    double chieuCao;
    double canh;

    public HinhTamGiac(double canh, double chieuCao) {
        this.canh = canh;
        this.chieuCao = chieuCao;
    }

    @Override
    public void tinhDienTich() {
        double dienTich = 0.5 * canh * chieuCao;
        System.out.println("Diện tích hình tam giác: " + dienTich);
    }
}
