N, Q = map(int, input().split())
list = []

for i in range(N):
    p, k, c = map(int, input().split())
    
    time = Q // k
    if Q%k == 0:
        time -= 1
    
    money = ((time*(time+1)) // 2)*c + p
    list.append(int(money))

tmp = min(list)
print(list.index(tmp) + 1, tmp)
