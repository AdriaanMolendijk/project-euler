import math


def get_num_divisors(n):
    primeFactorization = prime_factorization(n)
    primes = {}
    for p in primeFactorization:
        if p in primes:
            primes[p] = primes[p] + 1
            continue
        primes[p] = 1
    prod = 1
    for p in primes:
        prod *= primes[p] + 1
    return prod


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
            n /= div
            div = div - 1
            continue

        if div > math.sqrt(n):
            factorization.append(int(n))
            break
    return factorization


for i in range(1, 1_000_000):
    triangle = int(i * (i + 1) / 2)
    numDivs = get_num_divisors(triangle)
    if numDivs >= 500:
        print(triangle)
        exit()