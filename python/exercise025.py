fib1 = 1
fib2 = 2
n = 3
while (True):
    n = n + 1
    fib3 = fib2 + fib1
    if len(str(fib3)) == 1_000:
        print(n)
        exit(0)
    fib1 = fib2
    fib2 = fib3