import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4, 3};

        SortArray(arr, 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void SortArray(Integer[] arr, int number){
        switch (number){
            case 1:
                //Sắp xếp từ bé đến lớn
                Arrays.sort(arr);
                break;
            case 2:
                //Sắp xếp từ lớn đến bé
                Arrays.sort(arr, Comparator.reverseOrder());
                break;
            
        }
    }
}
