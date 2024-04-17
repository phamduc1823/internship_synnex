import java.util.*;

public class ListInJava {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();

        LinkedList<String> list2 = new LinkedList<>();

        list1.add("Java");
        list1.add("PHP");
        list1.add("C++");

        list2.add("C#");
        list2.add("PHP");
        list2.add("Cake PHP");

        System.out.println("Phan tu co index = 2 la: " + list1.get(2));

        String[] arr = {"Python", "PHP", "Cake PHP"};

        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(arr));

//        for (String item : list3) {
//            System.out.println(item);
//        }

        ListIterator<String> listIterator = list1.listIterator();
        //Duyet cac phan tu tu dau den cuoi
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }

        //Duyet cac phan tu tu cuoi ve dau
//        while (listIterator.hasPrevious()) {
//            System.out.println(listIterator.previous());
//        }

        //Duyet mang voi for
//        for(int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i));
//            System.out.print(", ");
//        }

        //Sap xep mang
        // Collections.sort(list1);

        //Chuyen mang ArrayList thanh array
//        String[] arr1 = new String[list1.size()];
//        list1.toArray(arr1);

        //Chuyen mang array sang ArrayList

    }
}
