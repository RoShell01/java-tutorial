 import java.util.Scanner;
 class UnSorted {
    public static void main(String[] args) {
        
        int[] numbers = {45, 22, 78, 13, 89, 5, 67, 34};

        
        if (numbers.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        
        int min = numbers[0];
        int max = numbers[0];

        
        for (int num : numbers) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        
        System.out.println("Smallest element: " + min);
        System.out.println("Largest element: " + max);
    }
}
