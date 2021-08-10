# 회문 판별하는 함수
# 예) level, sns 등 

word = input('단어를 입력하세요 : ')

is_palindrome = True

# for i in range(len(word)//2):
#     # if word[i] != word[-1 - i ]:
#     if word[i] != word[len(word) -1 - i]:
#         is_palindrome = False
#         break
i = 0 
while i < (len(word)//2):
    if word[i] != word[-1 -i]:
        is_palindrome = False
        break

    i += 1
    
print(is_palindrome)