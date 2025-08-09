import java.util.Scanner;

public class FlipMatrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

       
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        
        for (int j = 0; j < cols; j++) {
            int temp = matrix[0][j];
            matrix[0][j] = matrix[rows - 1][j];
            matrix[rows - 1][j] = temp;
        }

      
        for (int i = 0; i < rows; i++) {
            int temp = matrix[i][0];
            matrix[i][0] = matrix[i][cols - 1];
            matrix[i][cols - 1] = temp;
        }

        
        System.out.println("\nMatrix after flipping first and last rows and columns:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
