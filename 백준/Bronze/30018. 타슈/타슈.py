import sys

input_data = sys.stdin.read().split()

N = int(input_data[0])
a = [int(x) for x in input_data[1:N+1]]
b = [int(x) for x in input_data[N+1:]]

moves = 0
for i in range(N):
    if b[i] > a[i]:
        moves += (b[i] - a[i])
        
print(moves)