import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.printf("Element [%d][%d]: ", i, j);
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input matrix 2
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.printf("Element [%d][%d]: ", i, j);
                matrix2[i][j] = scanner.nextInt();
            }
        }

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        
        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();

            scanner.close();
        }

        
    }
}
