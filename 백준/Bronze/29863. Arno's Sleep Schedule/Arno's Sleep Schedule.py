sleep = int(input())
awake = int(input())

if(sleep > 15):
    awake += 24

print(awake - sleep)