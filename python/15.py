size = 21
grid = [[0 for i in range(size)] for j in range(size)]
grid[size-1][size-1] = 1
for i in range(size - 1, -1, -1):
    for j in range(size - 1, -1, -1):
        if i + 1 < size:
            grid[i][j] = grid[i + 1][j]
        if j + 1 < size:
            grid[i][j] += grid[i][j + 1]
print(grid[0][0])