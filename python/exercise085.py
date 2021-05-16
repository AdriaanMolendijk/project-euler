def get_rectangles(rows, cols):
    total = 0
    for width in range(1, cols + 1):
        for height in range(1, rows + 1):
            number = (cols - width + 1) * (rows - height + 1)
            total = total + number
    return total

best = 2_000_000
limit = 100
for a in range(1, limit + 1):
    for b in range(a, limit + 1):
        curr = get_rectangles(a, b)
        distance = abs(2_000_000 - curr)
        if distance < best:
            best = distance
            print(a * b)