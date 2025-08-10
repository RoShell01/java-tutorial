import java.util.Arrays;
import java.util.Collections;

public class Descending {

    public static void main(String[] args) {
        
        Integer[] array = {5, 2, 9, 1, 7};

        Arrays.sort(array, Collections.reverseOrder());
        
        System.out.println("Array in descending order:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
