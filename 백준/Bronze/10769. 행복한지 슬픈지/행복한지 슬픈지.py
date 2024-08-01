s = input()

smile, sad = s.count(":-)"), s.count(":-(")

if smile == 0 and sad == 0:
    print("none")
elif smile == sad:
    print("unsure")
elif smile > sad:
    print("happy")
else:
    print("sad")