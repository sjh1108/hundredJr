import sys

input = sys.stdin.read().splitlines()

N = int(input[0])

for i in range(1, N + 1):
    words = input[i].split()
    reversed_words = ' '.join(words[::-1])
    print(f"Case #{i}: {reversed_words}")