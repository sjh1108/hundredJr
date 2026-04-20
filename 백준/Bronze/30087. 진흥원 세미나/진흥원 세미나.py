N,lst = int(input()),[]

seminal_dic = {

    "Algorithm": 204,

    "DataAnalysis": 207,

    "ArtificialIntelligence": 302,

    "CyberSecurity": "B101",

    "Network": 303,

    "Startup": 501,

    "TestStrategy": 105

}

for i in range(N):

    seminal = input()

    if seminal in seminal_dic.keys():

        lst.append(seminal_dic[seminal])

        print(lst[i])