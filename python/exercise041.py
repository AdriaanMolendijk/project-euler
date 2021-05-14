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


oneToNine = "123456789"
for i in range(10_000_000):
    if are_permutations(i, oneToNine[0:len(str(i))]):
        if is_prime(i):
            print(i)
