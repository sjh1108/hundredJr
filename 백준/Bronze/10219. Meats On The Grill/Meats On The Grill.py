T = int(input())

for j in range(T):
    x, y = map(int, input().split())
    
    for i in range(x):
        s = input()
        
        tmp = y-1
        
        while tmp >= 0:
            print(s[tmp], end='')
            tmp -= 1
        print()
    