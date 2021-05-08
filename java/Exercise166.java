import java.util.HashSet;

public class Exercise166 {

    private static int size = 4;
    private static int[][] targets =
    {
        {0, 0}, {1,1}, {2,2}, {3,3},
        {3,0}, {2,1}, {1,2}, {0,3},
        {0,1}, {0,2},
        {1,3}, {2,3},
        {1,0}, {2,0},
        {3,1}, {3,2}
    };
    private static int target;
    private static int count;

    public static void main(String[] args)
    {
        int sum = 0;
        for (int t = 0; t <= 9 * size; t++)
        {
            target = t;
            int[][] grid = new int[size][size];
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    grid[i][j] = -1;
                }
            }

            count = 0;
            generate(grid);
            System.out.println(t + ": " + count);
            sum += count;
        }
        System.out.println(sum);
    }

    static void generate(int[][] grid)
    {
        // PrintMatrix(grid);
        int[] indices = getNextEntry(grid);

        // if grid is fully generated
        if (indices[0] == -1)
        {
            count++;
            return;
        }

        int indexRow = indices[0], indexCol = indices[1];
        HashSet<Integer> guesses = getGuesses(grid, indexRow, indexCol);
        for (int guess : guesses)
        {
            int[][] newGrid = new int[size][size];
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    newGrid[i][j] = grid[i][j];
                }
            }

            newGrid[indexRow][indexCol] = guess;
            if (isWrongRowGuess(newGrid, indexRow, indexCol))
            {
                // Console.WriteLine(guess + " at (" + (indexRow + 1) + "," + (indexCol + 1) + ") wrong, violating row.");
                // Console.WriteLine();
                continue;
            }
            if (isWrongColGuess(newGrid, indexRow, indexCol))
            {
                // Console.WriteLine(guess + " at (" + (indexRow + 1) + "," + (indexCol + 1) + ") wrong, violating col.");
                // Console.WriteLine();
                continue;
            }
            if (IsWrongLeftDiagGuess(newGrid))
            {
                // Console.WriteLine(guess + " at (" + (indexRow + 1) + "," + (indexCol + 1) + ") wrong, violating left diagonal.");
                // Console.WriteLine();
                continue;
            }
            if (isWrongRightDiagGuess(newGrid))
            {
                // Console.WriteLine(guess + " at (" + (indexRow + 1) + "," + (indexCol + 1) + ") wrong, violating right diagonal.");
                // Console.WriteLine();
                continue;
            }
            generate(newGrid);
        }
    }

    public static HashSet<Integer> getGuesses(int[][] grid, int row, int col)
    {
        int rowSum = 0, colSum = 0;
        for (int i = 0; i < size; i++)
        {
            int num = grid[row][i];
            rowSum += sign(num) * num;
            num = grid[i][col];
            colSum += sign(num) * num;
        }
        HashSet<Integer> output = new HashSet<>();
        int bound = Math.min(9, target - Math.max(rowSum, colSum));
        for (int i = 0; i <= bound; i++) output.add(i);
        return output;
    }

    public static boolean IsWrongLeftDiagGuess(int[][] grid)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            int num = grid[i][i];
            if (num < 0) return false;
            sum += num;
        }
        return sum != target;
    }

    public static boolean isWrongRightDiagGuess(int[][] grid)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            int num = grid[i][size - i - 1];
            if (num < 0) return false;
            sum += num;
        }
        return sum != target;
    }

    public static boolean isWrongColGuess(int[][] grid, int row, int col)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            int num = grid[i][col];
            if (num < 0) return false;
            sum += num;
        }
        return sum != target;
    }

    public static boolean isWrongRowGuess(int[][] grid, int row, int col)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            int num = grid[row][i];
            if (num < 0) return false;
            sum += num;
        }
        return sum != target;
    }

    static int[] getNextEntry(int[][] grid)
    {
        for (int i = 0; i < targets.length; i++)
        {
            if (grid[targets[i][0]][targets[i][1]] == -1)
            {
                int[] found = { targets[i][0], targets[i][1] };
                return found;
            }
        }

        int[] indices = { -1, -1 };
        return indices;
    }

    static int sign(int n)
    {
        if (n >= 0) return 1;
        return 0;
    }

}
