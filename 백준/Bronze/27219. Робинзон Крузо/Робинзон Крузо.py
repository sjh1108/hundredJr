n = int(input())

a = ''
for _ in range (n//5):
    a += 'V'
for _ in range (n%5):
    a += 'I'
    
print(a)