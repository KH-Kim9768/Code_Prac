'''

2021 - 09 - 13
Big Data Class

Python Practice

'''
'''
a = int(input("숫자를 입력하세요 : "))

if a % 2 == 0:
    print("짝수입니다")

else:
    print("홀수입니다")
'''

'''
score = int(input("점수를 입력하세요 : "))
if score >= 90:
    print("성적 : A")
elif score >= 80:
    print("성적 : B")
elif score >= 70:
    print("성적 : C")
elif score >= 60:
    print("성적 : D")
else:
    print("성적 : F")
'''
'''
fruit = ["사과", "배", "딸기", "포도"]
fruit.append("귤")
print(fruit)

if "딸기" in fruit:
    print("딸기")

if "수박" in fruit:
    print("수박이 있네요")

else :
    print("수박은 없네요")

if "수박" not in fruit :
    print("수박이 없네요")
'''

'''
import random as r

numbers = []

for i in range(10):
    numbers.append(r.randrange(0, 10))

print("생성된 리스트", numbers)
for i in range(10):
    if i not in numbers:
        print("숫자", i, "이 없네요.")
'''

