import sys

w = sys.stdin.read().split()
if w:
    N = int(w[0])
    for s in w[1:]:
        for i in range(0, len(s) - 1, 2):
            c = (ord(s[i]) + ord(s[i+1]) - 194 - N) % 26
            print(chr(c + 97), end='')
        print(' ', end='')