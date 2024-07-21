t = int(input())

for _ in range(t):
    a, b, c = map(int, input().split())

    if (a > b - c):
        print("do not advertise")
    elif (a == b - c):
        print("does not matter")
    else:
        print("advertise")