package advance;

import java.io.*;

public class IO {
    public static void file(){
        // Tạo một đối tượng File đại diện cho một tệp tin
        File file = new File("src/advance/input.txt");

        // Kiểm tra xem tệp tin có tồn tại không
        if (file.exists()) {
            System.out.println("Tệp tin đã tồn tại.");
        } else {
            System.out.println("Tệp tin không tồn tại.");
        }

        // Lấy tên của tệp tin
        String fileName = file.getName();
        System.out.println("Tên của tệp tin là: " + fileName);

        // Lấy đường dẫn tuyệt đối của tệp tin
        String absolutePath = file.getAbsolutePath();
        System.out.println("Đường dẫn tuyệt đối của tệp tin là: " + absolutePath);

        // Tạo một thư mục mới
        File directory = new File("new_directory");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Thư mục đã được tạo thành công.");
            } else {
                System.out.println("Không thể tạo thư mục.");
            }
        } else {
            System.out.println("Thư mục đã tồn tại.");
        }

        // Xóa thư mục
        if (directory.exists()) {
            if (directory.delete()) {
                System.out.println("Thư mục đã được xóa thành công.");
            } else {
                System.out.println("Không thể xóa thư mục.");
            }
        }
    }

    public static void fileWriter(){
        String path = "src/advance/input.txt";

        try (FileWriter fileWriter = new FileWriter(path)) {
            char[] data = {'H', 'e', 'l', 'l', 'o','\n','g','p', 't'};
            fileWriter.write(data);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu vào tệp tin: " + e.getMessage());
        }
    }

    public static void bufferedOutputStream(){
        String path = "src/advance/input.txt";
        String text = "Buffer out";

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))){
            bos.write(text.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileOutputStream() {
        String path = "src/advance/input.txt";
        String text = "你们好";
        try{
            FileOutputStream fos = new FileOutputStream(path);

            fos.write(text.getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    };

    public static void bufferedReader(){
        String fileName = "src/advance/input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin: " + e.getMessage());
        }
    }

    public static void fileReader(){
        String fileName = "src/advance/input.txt";

        try (FileReader fileReader = new FileReader(fileName)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin: " + e.getMessage());
        }
    }

    //Nhanh hon vi su dung bo nho dem
    public static void bufferedInputStream(){
        String fileName = "src/advance/input.txt";

        try (BufferedInputStream buff = new BufferedInputStream(new FileInputStream(fileName))) {
            int data;
            while ((data = buff.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin: " + e.getMessage());
        }
    }

    public static void inputStream (){
        String path = "src/advance/input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            int data;

            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }

            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        inputStream();
//        bufferedInputStream();
//        fileReader();
//        bufferedReader();
//        fileOutputStream();
//        bufferedOutputStream();
//        fileWriter();
        file();
    }
}
