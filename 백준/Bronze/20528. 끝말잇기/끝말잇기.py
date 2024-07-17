n = int(input())
arr = list(input().split())

start = arr[0][0]
for i in range(1, n):
    if arr[i][0] != start:
        print("0")
        exit()
print("1")