public class IfElse {
    public static void main(String[] args) {
        int x = 5;
        //If else
        if(x < 6){
            System.out.println("So " + x + " nho hon 6");
        }else {
            System.out.println("So " + x + " lon hon 6");
        }

        for (int i = 0; i <= 5; i++){
            System.out.println(i + " ");
        }

        //while nếu điều kiện sai sẽ không chạy chương trình
        while (x < 10){
            x++;
            System.out.println(x);
        }

        //do-while nếu điều kiện sai sẽ chạy 1 lần rồi mới dừng chương trình
        do {
            x++;
            System.out.println(x);
        }while (x < 10);

        int number = 3;

        switch (number){
            case 1:
                System.out.println("Số 1");
                break;
            case 2:
                System.out.println("Số 2");
                break;
            default:
                System.out.println("Số bạn nhập không hợp lệ!");
                break;
        }
    }
}
