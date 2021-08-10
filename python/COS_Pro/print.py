'''
문자열 한 개가 주어졌을 때, 주어진 문자열 양 옆에 작은따옴표를 붙인다
'''

input_str = input()

print("'%s'" % input_str)
print('\'%s\''% input_str)
print('\'' + input_str + '\'')