import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {2, 1, 4, 3};

//        sortArray(arr, 1);
//        addArray(arr, 5);
//        removeArray(arr, 3);

    }

    //Thêm phần tử vào mảng
    public static void addArray(Integer[] arr, Integer newValue){
        // Chuyển mảng thành ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));

        // Thêm phần tử mới vào ArrayList
        arrayList.add(newValue);

        // Chuyển đổi lại ArrayList thành mảng
        arr = arrayList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
    }

    //Xóa phần tử trong mảng
    public static void removeArray(Integer[] arr, Integer numberRemove){
        //Xóa phần tử trong mảng theo giá trị
        Integer[] newArr = new Integer[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] != numberRemove) {
                newArr[k] = arr[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    //sắp xếp từ bé đến lớn và ngược lại
    public static void sortArray(Integer[] arr, int number){
        switch (number){
            case 1:
                //Sắp xếp từ bé đến lớn
                Arrays.sort(arr);
                System.out.println(Arrays.toString(arr));
                break;
            case 2:
                //Sắp xếp từ lớn đến bé
                Arrays.sort(arr, Comparator.reverseOrder());
                System.out.println(Arrays.toString(arr));
                break;
            default:
                System.out.println("Sai tham số!");
                break;
        }
    }
}
