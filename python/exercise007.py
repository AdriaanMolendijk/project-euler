import math


# This method determines whether an integer is prime or not.
# n the number on which to perform the primality test.
# return true iff n is prime.
def is_prime(n):
    if n <= 1:
        return False
    if n == 2 or n == 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    for i in range(5, int(math.sqrt(n)) + 1, 6):
        if n % i == 0 or n % (i+2) == 0:
            return False
    return True


count = 0
for i in range(1,1_000_000):
    if is_prime(i):
        count = count + 1
        if count == 10_001:
            print(i)
            exit(0)
