import sys
input = sys.stdin.readline

N = int(input())
bowling = {}

for _ in range(N):
    request = list(map(int, input().split()))
    if (request[0] == 1):
        bowling[request[2]] = request[1]
    else:
        print(bowling[request[1]])