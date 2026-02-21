num = int(input())

prev, cnt = 0, 0
arr = input().split()

for n in arr:
    n = int(n)
    if(prev <= n):
        cnt+=1
    prev = n
print(cnt)