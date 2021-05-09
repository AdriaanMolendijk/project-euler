size = 15
with open('exercise018.txt', 'r') as f:
    grid = [[int(j) for j in i.split(' ')] for i in f]
path = [[0 for i in range(size)] for j in range(size)]
for col in range(size):
    path[size-1][col] = grid[size-1][col]
for i in range(size - 2, -1, -1):
    for j in range(0, i + 1):
        path[i][j] = grid[i][j] + max(path[i+1][j], path[i+1][j+1])
print(path[0][0])
print(path)