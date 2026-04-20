n = int(input())

list = list(map(int, input().split()))
min = 1000
max = 0

for i in list:
    if i < min:
        min = i
    if i > max:
        max = i
        
print(max-min)