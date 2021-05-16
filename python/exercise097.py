mersenne = 28433
for i in range(1, 7_830_457 + 1):
    mersenne = mersenne * 2
    mersenne = mersenne % (10 ** 10)
mersenne = mersenne + 1
print(mersenne)