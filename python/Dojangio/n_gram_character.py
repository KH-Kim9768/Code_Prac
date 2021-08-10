# text = 'Hello'
word = input("단어를 입력하세요 : ")
gram = int(input("단위를 입력하세요 : "))

for i in range(len(word) - (gram - 1)):
    # print(text[i], text[i+1], sep= '')

    for j in range(gram):
        print(word[i+j], sep='', end='')
    
    print()

i = 0
while i < len(word) - (gram - 1):
    j = 0
    while j < gram:
        print(word[i+j], sep='', end='')
        j += 1
    print()
    i += 1