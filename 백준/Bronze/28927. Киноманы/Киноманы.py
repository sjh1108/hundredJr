t1, e1, f1 = map(int, input().split())
t2, e2, f2 = map(int, input().split())

t1 *= 3
t2 *= 3
e1 *= 20
e2 *= 20
f1 *= 120
f2 *= 120

a = t1+e1+f1
b = t2+e2+f2

if a > b:
    print("Max")
elif a==b:
    print("Draw")
else:
    print("Mel")