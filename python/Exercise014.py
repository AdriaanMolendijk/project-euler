def collatz(n):
    if n == 1:
        return 1
    # n >= 2 here
    if n % 2 == 0:
        return 1 + collatz(n / 2)
    return 1 + collatz((3 * n + 1) / 2)

maxNum = 0
maxIndex = 0
for i in range(1,1_000_001):
    num = collatz(i)
    if (num > maxNum):
        maxNum = num
        maxIndex = i
print(maxIndex)