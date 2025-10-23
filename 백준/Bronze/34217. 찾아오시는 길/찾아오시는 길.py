a, b = map(int, input().split())
c, d = map(int, input().split())
a = a+c
b = b+d

if a < b:
    print("Hanyang Univ.")
elif a > b: 
    print("Yongdap")
else:
    print("Either")