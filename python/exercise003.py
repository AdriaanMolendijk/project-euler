import math


# This method returns the prime factorization of a number.
# l the number to be factorized
# return an ArrayList representing the prime factorization.
def prime_factorization(n):
    factorization = []
    div = 1
    while n != 1:
        div = div + 1
        if n % div == 0:
            factorization.append(div)
            n = n / div
            div = div - 1
            continue

        if div > math.sqrt(n):
            factorization.append(int(n))
            break
    return factorization

n = 600851475143
factorization = prime_factorization(n)
for f in factorization:
    print(f)