sum = 0
for i in range(1,1_001):
    sum += i ** i
l = len(str(sum))
print(str(sum)[l-10:l])