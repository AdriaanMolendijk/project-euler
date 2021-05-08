# we have a <= b <= c and a + b + c = 1000, thus a <= 334 and b <= 500
for a in range(1, 335):
    for b in range(a, 501):
        c = 1000 - b - a
        if a * a + b * b == c * c:
            print(a * b * c)
