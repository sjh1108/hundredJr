import sys

input_data = sys.stdin.read().split()

if input_data:
    d1 = int(input_data[0])
    d2 = int(input_data[1])
    x = int(input_data[2])

    if d1 > d2:
        d1, d2 = d2, d1

    p = (100 - x) / x

    result = (p + 1) / (p * d2 / d1 + 1) * d2

    print(f"{result:.6f}")