n = int(input())
liquid = list(map(int, input().split()))

val = 2000000000
l, r = 0, n - 1
x, y = 0, 0

while l<r:
    cur = liquid[l] + liquid[r]
    
    if abs(cur) <= val:
        val = abs(cur)
        x, y = liquid[l], liquid[r]
        
    if cur <= 0:
        l += 1
    else:
        r -= 1
        
print(x, y)