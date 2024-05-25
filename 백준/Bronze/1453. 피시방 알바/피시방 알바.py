n = int(input())
customer = list(map(int, input().split()))
cnt = 0 
seat = [] 
for i in range(n):
    if customer[i] in seat:         # 앉고 싶어하는 자리에 사람이 있으면
        cnt += 1                    # 거절
    else:                           # 없으면
        seat.append(customer[i])    # 자리에 앉음
print(cnt)