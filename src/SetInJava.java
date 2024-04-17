import java.util.*;

public class SetInJava {
    public static void main(String[] args) {
        Set<String> setA = new HashSet<String>();
        //Them phan tu vao set
        setA.add("Java");
        setA.add("Python");
        setA.add("Java");
        setA.add("PHP");
        System.out.println("Số phần tử của setA: " + setA.size());
        System.out.println("Các phần tử của setA: " + setA);
        System.out.println("setA có chứa Java không? " + setA.contains("Java"));
        System.out.println("setA có chứa C++ không? " + setA.contains("C++"));

        //Xoa phan tu trong set
        setA.remove("PHP");
        System.out.println("Các phần tử của setA sau khi xóa: ");
        for (String element : setA) {
            System.out.println(element);
        }

        //Xoa tat ca trong set
        setA.clear();
    }
}
