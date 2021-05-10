def num_solutions(p):
    count = 0
    # we have a <= b <= c and a + b + c = p, thus a <= p/3 and b <= p/2
    for a in range(int(p/3)+1):
        for b in range(int(p/2) + 1):
            c = p - b - a
            if a * a + b * b == c * c:
                count = count + 1
    return count


maxP = 0
maxSol = 0
for p in range(1,1_001):
    numSol = num_solutions(p)
    if numSol > maxSol:
        maxSol = numSol
        maxP = p
print(maxP)

