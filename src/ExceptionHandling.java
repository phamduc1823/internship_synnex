public class ExceptionHandling {
    //Khai báo ngoại lệ
    static void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        int result = a / b;
        System.out.println("Kết quả: " + result);
    }

    public static void main(String[] args) {
        try {
            divide(10, 0); // Gọi phương thức và chia cho 0
        } catch (ArithmeticException e) {
            // Xử lý ngoại lệ ArithmeticException
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
