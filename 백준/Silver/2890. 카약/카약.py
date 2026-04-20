r, c = map(int,input().split())
x = []
result = []
check = []
rank = 1
result_team = []

for i in range(r):
    x.append(list(input()))
for i in range(r):
    cnt = 0
    for j in range(c):
        if x[i][j] != "S" and x[i][j] != "." and x[i][j] != "F":
            del x[i][j]
            cnt += 1
        if cnt == 2:
            break
            
for i in x:
    check.append(len(i))
for i in range (len(check)):
    if check[i] == max(check):
        delete = i
del x[delete]

for i in range(1,c-1):
    cnt = 0
    for j in range(r-1):
        if x[j][-i] != "F" and x[j][-i] != "." and x[j][-i] != "S":
            result.append(rank)
            result_team.append(int(x[j][-i]))
            cnt += 1
    if cnt > 0:
        rank += 1
        
for i in range(1,10):
    print(result[result_team.index(i)])