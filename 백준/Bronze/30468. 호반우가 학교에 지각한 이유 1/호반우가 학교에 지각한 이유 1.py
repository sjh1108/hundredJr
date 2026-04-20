a, b, c, d, e = map(int, input().split())

result = e*4 - (a+b+c+d)
if result<0:
    print(0)
else:
    print(result)