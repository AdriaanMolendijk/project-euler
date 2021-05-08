def sum_divs(n):
    sum = 0
    for i in range(1,n):
        if n % i == 0:
            sum += i
    return sum

sum = 0
for i in range(10_001):
    num = sum_divs(i)
    if i != num and sum_divs(num) == i:
        sum += i
print(sum)