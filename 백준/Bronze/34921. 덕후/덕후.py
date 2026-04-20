a, b = map(int, input().split())

res = 10 + 2 * (25 - a + b)
if res < 0:
    res = 0
print(res)