n = int(input())
if n % 7 == 0:
    flag = 1
    while n > 0:
        if n % 10 == 7 : flag = 3
        n //= 10
else:
    flag = 0
    while n > 0:
        if n % 10 == 7 : flag = 2
        n //= 10
print(flag)