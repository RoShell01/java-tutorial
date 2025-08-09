
import java.util.HashSet;
import java.util.Set;
class Common {
    public static void main(String[] args) {
       
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        
        printCommonElements(array1, array2);
    }

    public static void printCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

      
        for (int num : arr1) {
            set1.add(num);
        }

        
        for (int num : arr2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }

     
        if (common.isEmpty()) {
            System.out.println("No common elements found.");
        } else {
            System.out.println("Common elements:");
            for (int num : common) {
                System.out.println(num);
            }
        }
    }
}