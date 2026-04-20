n = int(input())

p = list(map(int, input().split()))
r = list(map(int, input().split()))

c = 0
for i in range(n):
    if p[i] <= r[i]:
        c += 1
        
print(c)