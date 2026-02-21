for i in range(int(input())):
    li = sorted(map(int, input().split()))
    print(f"Scenario #{i+1}:")
    if li[0]**2 + li[1]**2 == li[2]**2:
        print("yes\n")
    else:
        print("no\n")