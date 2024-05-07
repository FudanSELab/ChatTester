with open("./INFO_compile.text", 'r', encoding='utf-8') as f:
    file_cont = f.read()

pp = file_cont.split("####################\n\n")
print(len(pp))
print(pp[-2])
print("#################")
lines = pp[-2].split("\n")
for lin in lines:
    print(lin)