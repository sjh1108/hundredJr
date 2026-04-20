n = int(input())
d, p = 0, 0

for _ in range(n):
    if input() == "D":
        d += 1
    else:
        p += 1
        
    if d+2 == p:
        print(str(d)+":"+str(p))
        exit()
    elif p+2 == d:
        print(str(d)+":"+str(p))
        exit()
    
print(str(d)+":"+str(p))