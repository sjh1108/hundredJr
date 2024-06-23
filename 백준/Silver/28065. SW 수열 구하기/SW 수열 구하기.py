n = int(input())

num = 1
for i in range(1, n+1):
    print(num, end=' ')
    if(i % 2 == 0): num -= n - i
    else: num += n - i