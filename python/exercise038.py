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


for i in range(10_000):
    concat = ""
    for n in range(1,7):
        prod = i * n
        concat += str(prod)
        if len(concat) > 9:
            break
        if are_permutations(concat, 123_456_789):
            print(concat)