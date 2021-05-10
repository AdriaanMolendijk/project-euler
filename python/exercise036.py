# This method determines whether a string is palindrome.
# s the string on which to check the palindrome property.
# return true iff s is palindrome.
def is_palindrome(s):
    l = len(s)
    if l <= 1:
        return True
    c1 = s[0]
    c2 = s[-1]
    return c1 == c2 and is_palindrome(s[1:-1])


sum = 0
for i in range(1_000_000):
    if is_palindrome(str(i)):
        if is_palindrome(format(i,'b')):
            sum += i
print(sum)