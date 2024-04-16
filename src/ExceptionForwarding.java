import java.io.IOException;

//Chuyển tiep ngoại lệ
public class ExceptionForwarding {
    public void method1() throws IOException {
        System.out.println("Method 1 đang thực thi.");
        method2();
        System.out.println("Method 1 hoàn thành.");
    }

    public void method2() throws IOException {
        System.out.println("Method 2 đang thực thi.");
        method3();
        System.out.println("Method 2 hoàn thành.");
    }

    public void method3() throws IOException {
        System.out.println("Method 3 đang thực thi.");

        throw new IOException("Lỗi xử lý tệp.");
    }

    public static void main(String[] args) {
        ExceptionForwarding example = new ExceptionForwarding();
        try {
            example.method1();
        } catch (IOException e) {
            System.out.println("Xảy ra lỗi: " + e.getMessage());
        }
    }
}
