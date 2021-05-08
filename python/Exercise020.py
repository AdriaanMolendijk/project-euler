def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n-1)

sum = 0
num = factorial(100)
for c in str(num):
    sum += int(c)
print(sum)