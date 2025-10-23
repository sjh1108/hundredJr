input()
a = list(map(int, input().split()))

sum = 0
for i in a:
    sum += i
    
if sum < 0:
    print("Left")
elif sum == 0:
    print("Stay")
else:
    print("Right")