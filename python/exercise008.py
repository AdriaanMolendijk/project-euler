with open('exercise008.txt', 'r') as f:
    number = ""
    for num in f:
        number += str(int(num))


def get_prod(num):
    prod = 1
    for c in num:
        prod *= int(c)
    return prod


numLength = 13
l = len(number)
maxProd = 0
for i in range(0, l - numLength):
    prod = get_prod(number[i:i+numLength])
    maxProd = max(maxProd, prod)
print(maxProd)