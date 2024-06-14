e, f, c = map(int, input().split())

bottle = e + f
bottle_count = 0

while bottle >= c:
    bottle_count += bottle // c
    bottle = bottle % c + bottle // c
    
print(bottle_count)