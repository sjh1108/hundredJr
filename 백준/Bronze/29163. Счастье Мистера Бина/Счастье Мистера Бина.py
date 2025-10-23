n = int(input())
list = list(map(int, input().split()))

cnt = 0
for i in list:
    if i%2 == 0:
        cnt+=1

if cnt > n//2:
    print("Happy")
else:
    print("Sad")