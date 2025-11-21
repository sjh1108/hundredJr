a, b = map(int, input().split())

print(min(a, b+1) + min(a-1,b))