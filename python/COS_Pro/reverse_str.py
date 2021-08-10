'''
문자열 s를 거꾸로 출력하려고 합니다
abc -> cba
'''

input_str = input()
for i in range(len(input_str)-1, -1, -1):
    print(input_str[i], end='')