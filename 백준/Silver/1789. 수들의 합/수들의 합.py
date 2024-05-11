num = int(input())
sum1 = 0
count = 0

i = 0
while True:
    if sum1 > num:
        count -= 1
        break
    count += 1
    sum1 += count

print(count)