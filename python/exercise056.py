def digit_sum(n):
    sum = 0
    for c in str(n):
        sum = sum + int(c)
    return sum

maxSum = 0
for a in range(100):
    for b in range(100):
        num = a ** b
        sum = digit_sum(num)
        maxSum = max(maxSum, sum)
print(maxSum)