public class TestThrow {
    static void validate(int age) {
        try{
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Tuổi không hợp lệ!");
            }
            if (age < 18) {
                throw new ArithmeticException("Chưa đủ tuổi!");
            }else{
                System.out.println("Chào mừng");
            }
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        validate(220);
    }
}
