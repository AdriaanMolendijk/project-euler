fib1 = 1
fib2 = 2
sum = 2
while (True):
    fib3 = fib2 + fib1
    if fib3 > 4_000_000:
        break
    if fib3 % 2 == 0:
        sum += fib3
    fib1 = fib2
    fib2 = fib3
print(sum)