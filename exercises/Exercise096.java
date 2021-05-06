import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise096 {

    private static int sum;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Exercise096.txt"));

        sum = 0;
        for (int sud = 1; sud <= 50; sud++)
        {
            int[][] sudoku = new int[9][9];
            in.nextLine(); // read header sudoku
            for (int i = 0; i < 9; i++)
            {
                String line = in.nextLine();
                for (int j = 0; j < 9; j++)
                {
                    sudoku[i][j] = line.charAt(j) - '0';
                }
            }
            solveSudoku(sudoku);
            System.out.println();
        }
        System.out.println(sum);
    }

    /**
     * This method prints out the solution to a given sudoku.
     * @param sudoku >an int[,] representing the sudoku.
     */
    public static void solveSudoku(int[][] sudoku)
    {
        int[] indices = getNextEntry(sudoku);

        // sudoku is solved
        if (indices[0] == -1)
        {
            printSudoku(sudoku);
            sum += 100 * sudoku[0][0] + 10 * sudoku[0][1] + sudoku[0][2];
            return;
        }

        int indexRow = indices[0], indexCol = indices[1];
        HashSet<Integer> numbers = getGuesses(sudoku, indexRow, indexCol);
        for (int num : numbers)
        {
            int[][] newSudoku = new int[9][9];
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    newSudoku[i][j] = sudoku[i][j];
                }
            }
            newSudoku[indexRow][indexCol] = num;
            solveSudoku(newSudoku);
        }
    }

    /**
     * This method returns the set of guesses for a sudoku entry at (row,col).
     * @param sudoku an int[,] representing the sudoku.
     * @param row the row index.
     * @param col the col index.
     * @return a Hashset<int> containing the guesses.
     */
    public static HashSet<Integer> getGuesses(int[][] sudoku, int row, int col)
    {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 1; i <= 9; i++) numbers.add(i);

        // remove row and column numbers
        for (int i = 0; i < 9; i++)
        {
            int num = sudoku[row][i];
            if (num != 0) numbers.remove(num);
            num = sudoku[i][col];
            if (num != 0) numbers.remove(num);
        }

        // remove numbers in the same subgrid
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                int num = sudoku[(row / 3) * 3 + r][(col / 3) * 3 + c];
                if (num != 0) numbers.remove(num);
            }
        }

        return numbers;
    }

    /**
     * This method returns the pair of indices of a zero entry in a sudoku.
     * @param sudoku an int[,] representing the sudoku.
     * @return an int[] arrary arr, where arr[0] and arr[1] are the row and column of the zero entry from the sudoku.
     */
    static int[] getNextEntry(int[][] sudoku)
    {
        int[] indices = {-1, -1};
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (sudoku[i][j] == 0)
                {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**
     * This method prints out a sudoku.
     * @param sudoku an int[][] representing the sudoku.
     */
    static void printSudoku(int[][] sudoku)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
