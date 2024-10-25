X, K = map(int, input().split())
A = [*map(int, input().split())]
L = [0] * 10001
R = [0] * 10001

for l in range(X) :
    L[A[l]] += 1
    
for r in range(X, 2*X) :
    R[A[r]] += 1
        
res = 0
for l in range(1, K + 1) :
    if L[l] > 0 :
        for r in range(1, K + 1) :
            if l == r : continue
            res += L[l] * R[r]
print(res)