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


def is_circ_prime(n, sieve):
    num = str(n)
    for i in range(len(num) + 1):
        circ = num[i:] + num[0:i]
        if sieve[int(circ) - 1] == False:
            return False
    return True


limit = 1_000_000
sieve = prime_sieve(limit)
count = 0
for n in range(2, limit):
    if is_circ_prime(n, sieve):
        count = count + 1
print(count)