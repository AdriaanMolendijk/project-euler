def max_val(A):
    max_prod = 0
    for i in range(0, 4):
        max_prod = max(max_prod, A[0][i] * A[1][i] * A[2][i] * A[3][i])
        max_prod = max(max_prod, A[i][0] * A[i][1] * A[i][2] * A[i][3])
    max_prod = max(max_prod, A[0][0] * A[1][1] * A[2][2] * A[3][3])
    max_prod = max(max_prod, A[3][0] * A[2][1] * A[1][2] * A[0][3])
    return max_prod


with open('exercise011.txt', 'r') as f:
    grid = [[int(j) for j in i.split(' ')] for i in f]
    
prod = 0
subgrid = [[0 for j in range(4)] for i in range(4)]
for row in range(17):
    for col in range(17):
        for i in range(4):
            for j in range(4):
                subgrid[i][j] = grid[row + i][col + j]
        prod = max(prod, max_val(subgrid))
print(prod)