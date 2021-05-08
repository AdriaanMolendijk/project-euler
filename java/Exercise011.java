import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise011 {

    private static int[][] grid = new int[20][20];

    public static void main(String[] args) throws FileNotFoundException {

        String[] numbers;
        Scanner in = new Scanner(new File("Exercise011.txt"));
        for (int row = 0; row < 20; row++)
        {
            String line = in.nextLine();
            numbers = line.split(" ");
            for (int col = 0; col < 20; col++)
            {
                grid[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        int[][] subGrid = new int[4][4];
        int prod = 0;
        for (int row = 0; row < 17; row++)
        {
            for (int col = 0; col < 17; col++)
            {
                // calculate subgrid
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        subGrid[i][j] = grid[row + i][col + j];
                    }
                }
                prod = Math.max(prod, maxVal(subGrid));
            }
        }
        System.out.println(prod);
    }

    static int maxVal(int[][] A)
    {
        int m = A.length;
        if (m != 4) throw new IllegalArgumentException("Size of subgrid must be 4 (rows)");
        int n = A[0].length;
        if (n != 4) throw new IllegalArgumentException("Size of subgrid must be 4 (cols)");

        // m, n = 4 here.
        int maxProd = 0, prod;
        for (int i = 0; i < 4; i++)
        {
            maxProd = Math.max(maxProd, A[0][i] * A[1][i] * A[2][i] * A[3][i]);
            maxProd = Math.max(maxProd, A[i][0] * A[i][1] * A[i][2] * A[i][3]);
        }
        maxProd = Math.max(maxProd, A[0][0] * A[1][1] * A[2][2] * A[3][3]);
        maxProd = Math.max(maxProd, A[0][3] * A[1][2] * A[2][1] * A[3][0]);
        return maxProd;
    }

}
