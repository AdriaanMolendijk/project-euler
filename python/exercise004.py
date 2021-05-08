# This method determines whether a string is palindrome.
# s the string on which to check the palindrome property.
# true iff s is palindrome.
def is_palindrome(s):
    l = len(s)
    if l <= 1:
        return True
    c1 = s[0]
    c2 = s[-1]
    return c1 == c2 and is_palindrome(s[1:-1])

maximum = 0
for a in range(100, 1000):
    for b in range(a, 1000):
        c = a * b
        if c > maximum and is_palindrome(str(c)):
            maximum = c
            print(maximum)