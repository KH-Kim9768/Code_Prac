'''
표준 입력으로 두 개의 숫자 A, B를 입력받아, A를 B로 나눈 몫을 출력해 주세요.
단, 숫자 B로 0이 입력된 경우 나눗셈이 불가능하므로 몫 대신 "error"를 출력해 주세요.
'''

n, m = map(int, input().split())

if m == 0:
    print("error")

else:
    print(n % m)
    