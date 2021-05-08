def generate(seq):
    global count
    if len(seq) == size + 1:
        count = count + 1
        if count == 1_000_000:
            print(seq)
            exit(0)

    numbers = set()
    for i in range(size+1):
        numbers.add(i)
    for c in seq:
        numbers.remove(int(c))
    for n in numbers:
        generate(seq + str(n))


count = 0
size = 9
generate("")