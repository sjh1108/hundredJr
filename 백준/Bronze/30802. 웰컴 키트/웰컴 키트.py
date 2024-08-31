n = int(input())
T = list(map(int, input().split()))
t, p = map(int, input().split())

sum = 0
for i in T:
    if i==0:
        continue
    elif i<=t:
        sum+=1
    elif i%t==0:
        sum+=i//t
    else:
        sum+=i//t+1

pen=n//p
p=n%p

print(sum)
print(f'{pen} {p}')