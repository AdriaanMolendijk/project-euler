def sum_digits_5(n):
    sum = 0
    for c in str(n):
        digit = int(c)
        sum += digit ** 5
    return sum

sum = 0
for i in range(2,1_000_000):
    if i == sum_digits_5(i):
        sum += i
print(sum)