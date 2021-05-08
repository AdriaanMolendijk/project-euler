with open('exercise013.txt', 'r') as f:
    numbers = [int(i) for i in f]
sum = 0
for n in numbers:
    sum += n
print(str(sum)[0:10])