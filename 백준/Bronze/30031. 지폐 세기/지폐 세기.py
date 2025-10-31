n = int(input())

sum = 0

for _ in range(n):
    size = int(list(input().split())[0])
    
    if size == 136:
        sum += 1000
    elif size == 142:
        sum += 5000
    elif size == 148:
        sum += 10000
    elif size == 154:
        sum += 50000
        
print(sum)