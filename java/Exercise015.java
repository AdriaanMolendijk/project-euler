public class Exercise015 {

    public static void main(String[] args) {
        int size = 21;
        long[][] grid = new long[size][size];
        grid[size - 1][size - 1]++;

        for (int i = size - 1; i >= 0; i--)
        {
            for (int j = size - 1; j >= 0; j--)
            {
                if (i + 1 < size)
                {
                    grid[i][j] += grid[i + 1][j];
                }
                if (j + 1 < size)
                {
                    grid[i][j] += grid[i][j+1];
                }
            }
        }
        System.out.println(grid[0][0]);
    }
}
