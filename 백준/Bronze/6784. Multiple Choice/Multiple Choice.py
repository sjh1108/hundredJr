n = int(input())

ans = []
for _ in range(n):
    ans += input()
    
cnt = 0
for a in ans:
    if a == input():
        cnt+=1
print(cnt)