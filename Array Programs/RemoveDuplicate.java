import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        List<Integer> resultList = new ArrayList<>();
        Set<Integer> seenNonZero = new HashSet<>();

        for (int num : array) {
            if (num == 0 || !seenNonZero.contains(num)) {
                resultList.add(num);
                if (num != 0) {
                    seenNonZero.add(num);
                }
            }
        }

        System.out.println("Array after removing duplicate non-zero elements:");
        for (int num : resultList) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
