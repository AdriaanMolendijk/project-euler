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


# This method determines whether two integers are permuations of each other.
# n1 the first number.
# n2 the second number.
# return true iff n1 is a permutation of n2.
def are_permutations(n1, n2):
    digits1 = [0 for i in range(10)]
    digits2 = [0 for i in range(10)]
    for c in str(n1):
        digits1[int(c)] = digits1[int(c)] + 1
    for c in str(n2):
        digits2[int(c)] = digits2[int(c)] + 1
    for digit in range(10):
        if digits1[digit] != digits2[digit]:
            return False
    return True


sieve = prime_sieve(9_999)
for n1 in range(1000, 3340):
    n2 = n1 + 3330
    n3 = n2 + 3330
    if sieve[n1 - 1] is True and sieve[n2 - 1] is True and sieve[n3 - 1] is True:
        if are_permutations(n1, n2) and are_permutations(n2, n3):
            print(str(n1) + str(n2) + str(n3))