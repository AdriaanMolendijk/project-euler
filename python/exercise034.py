def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1)


def sum_digits_fac(n):
    sum = 0
    for c in str(n):
        sum += factorial(int(c))
    return sum


sum = 0
for i in range(10, 1_000_000):
    if i == sum_digits_fac(i):
        sum += i
print(sum)