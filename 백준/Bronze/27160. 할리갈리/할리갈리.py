import sys

input = sys.stdin.readline

N = int(input())

fruits = {
    "STRAWBERRY": 0,
    "BANANA": 0,
    "LIME": 0,
    "PLUM": 0
}

for _ in range(N):
    fruit, count = input().split()
    fruits[fruit] += int(count)
    
for count in fruits.values():
    if(count == 5):
        print("YES")
        exit(0)
print("NO")
