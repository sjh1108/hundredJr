n = int(input())
sum = 0 + (n-1)*8

list = list(map(int, input().split()))

for t in list:
    sum += t
    
day, hour = divmod(sum, 24)
print(day, hour)