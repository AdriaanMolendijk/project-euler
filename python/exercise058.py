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
    for i in range(5, int(math.sqrt(n) + 1), 6):
        if n % i == 0 or n % (i+2) == 0:
            return False
    return True


num = 1
term = 2
rad = 100_000
numerator = 0
denominator = 1
for r in range(1, rad + 1):
    for t in range(1, 5):
        num = num + term
        denominator = denominator + 1
        if is_prime(num):
            numerator = numerator + 1
        frac = numerator / denominator

    term = term + 2
    if frac <= 0.10:
        print(2 * r + 1)
        exit(0)