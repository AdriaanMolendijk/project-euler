import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise067 {

    public static void main(String[] args) throws FileNotFoundException {
        int size = 100;
        int[][] grid = new int[size][size];

        Scanner in = new Scanner(new File("Exercise067.txt"));
        for (int row = 0; row < size; row++)
        {
            String[] line = in.nextLine().trim().split(" ");
            for (int col = 0; col <= row; col++)
            {
                grid[row][col] = Integer.parseInt(line[col]);
            }
        }

        // initialize matrix
        int[][] path = new int[size][size];
        for (int col = 0; col < size; col++) path[size - 1][col] = grid[size - 1][col];

        for (int i = size - 2; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                path[i][j] = grid[i][j] + Math.max(path[i + 1][j], path[i + 1][j + 1]);
            }
        }
        System.out.println(path[0][0]);
    }
}
