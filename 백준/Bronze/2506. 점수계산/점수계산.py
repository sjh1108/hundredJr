n = int(input())
arr = list(map(int, input().split()))

sum = 0
count = 0
for i in range(n):
    if arr[i] == 0:
        count = 0
    else:
        count += 1
        sum += count
        
print(sum)