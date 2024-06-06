n, p = map(int, input().split())
l = []
a = n
while True:
    r = (a*n)%p
    if r in l:
        print(len(l) - l.index(r)) 
        # 리스트 길이에서 반복된 숫자 인덱스를 빼준다.
        break
    l.append(r)
    a = r