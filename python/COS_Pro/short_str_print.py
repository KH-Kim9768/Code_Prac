'''
표준 입력으로 문자열 두 개를 입력받아, 두 문자열 중 더 짧은 문자열을 출력해 주세요
'''

s1 = input()
s2 = input()

if len(s1) < len(s2):
    print(s1)

elif len(s2) < len(s1):
    print(s2)

else:
    print("Same")