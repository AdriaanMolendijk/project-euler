count = 0
for i in range(1, 10):
    for pow in range(1, 101):
        val = i ** pow
        if len(str(val)) == pow:
            count = count + 1
print(count)