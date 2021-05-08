num = 1
term = 2
rad = 500
sum = 1
for r in range(1,rad+1):
    for t in range(1,5):
        num += term
        sum += num
    term += 2
print(sum)