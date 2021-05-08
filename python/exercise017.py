singles = ["one", "two", "three", "four", "five","six","seven","eight","nine","ten","eleven","twelve",
            "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]
tenfolds = ["twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]


def letter_count(n):
    if n == 0:
        return 0
    if n < 20:
        return len(singles[n-1])
    if n < 100:
        return len(tenfolds[int(n / 10) - 2]) + letter_count(n % 10)
    if n < 1000:
        if n % 100 == 0:
            return len(singles[ int(n / 100) - 1]) + len("hundred")
        return len(singles[int(n / 100) - 1]) + len("hundredand") + letter_count(n % 100)
    return len("onethousand")

total = 0
for i in range(1,1001):
    total += letter_count(i)
print(total)