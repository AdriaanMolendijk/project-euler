import math


# This method returns the prime sieve of all numbers up to a certain limit;
# limit the limit of the prime sieve.
# return a boolean[] representing the sieve up to limit.
def prime_sieve(limit):
    # limit >= 1 here
    sieve = [False]
    for i in range(2, limit + 1):
        sieve.append(True)

    for i in range(2, int(math.sqrt(limit)) + 1):
        if sieve[i-1]:
            j = i * i
            while j <= limit:
                sieve[j-1] = False
                j += i
    return sieve


sieve = prime_sieve(100_000)
maximum = 0
for b in range(1, 1_001):
    for a in range(-b, 1_001):
        for n in range(1,500):
            function = n * n + a * n + b
            if function <= 0 or sieve[function - 1] == False:
                if n > maximum:
                    maximum = n
                    print(a * b)
                break