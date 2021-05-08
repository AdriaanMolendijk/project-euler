def is_abundant(n):
    sum = 0
    for i in range(1, n):
        if n % i == 0:
            sum += i
    return sum > n


maxAbundant = 28123
abundants = []
numbers = []

for i in range(1, maxAbundant + 1):
    numbers.append(i)
    if is_abundant(i):
        abundants.append(i)

pairSum = 0
for i in abundants:
    for j in abundants:
        pairSum = i + j
        if pairSum <= maxAbundant:
            numbers[pairSum - 1] = 0

sum = 0
for n in numbers:
    sum += n
print(sum)