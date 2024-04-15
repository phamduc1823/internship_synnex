import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {2, 1, 4, 3};

//        sortArray(arr, 1);
//        addArray(arr, 5);
//        removeArray(arr, 3);
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
    }

    //Sắp xếp chèn
    public static void insertionSort(Integer[] arr) {
        int arrLength = arr.length;
        for(int i = 1; i < arrLength; i++){
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Sắp xếp chọn
    public static void selectionSort(Integer[] arr) {
        int arrLength = arr.length;

        //{2, 1, 4, 3}
        for (int i = 0; i < arrLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrLength; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;

                    int temp = arr[minIndex];
                    arr[minIndex] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Sắp xếp kiểu nổi bọt
    public static void bubbleSort(Integer[] arr){
        Integer arrLength = arr.length;
        int temp; // Biến tạm
        boolean is_sorted;

        for (int i = 0; i < arrLength; i++) {

            is_sorted = true;

            //Vòng lặp từ phần tử thứ 2 đến cuối
            for (int j = 1; j < (arrLength - i); j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    is_sorted = false;
                }
            }

            if (is_sorted) break;

            System.out.println(Arrays.toString(arr));
        }
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
