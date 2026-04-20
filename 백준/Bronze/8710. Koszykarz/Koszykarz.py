k, w, m = map(int, input().split())
res = (w - k)//m
if (w-k) % m != 0:
    res += 1
print(res)