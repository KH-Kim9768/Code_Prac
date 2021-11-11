'''
본인의 2학기 강의 스케쥴을 모델링 해서 다음의 문제를 풀 수 있도록 하자

특정 교수 이름으로 어떤 과목이 어느 요일의 시간대에서 수업을 하는지 출력

특정 요일로 과목명과 교수명, 시간대를 출력

1시간 모델링(코드 없음, 일상 언어)
1시간 코딩(일상 언어 -> 코드 전환)

'''

'''

Actor : 강의, 시간표

class 강의
str 강의명 
str 교수명
dict 강의시간 (key : 요일, 시작교시, 끝교시)

class 시간표
dict index (요일별 index를 변환함)
list matrix (전체 시간표 list)
list 강의목록

'''

class 강의:
    
    def __init__(self, 강의명 = "", 교수명 = "", 강의시간 = {"요일" : "", "시작교시" : 0, "끝교시" : 0}):
        self.강의명 = 강의명
        self.교수명 = 교수명
        self.강의시간 = 강의시간

    def 전체출력(self):
        print("강의명 : %s, 교수명 : %s, 강의시간 : %s요일 %d ~ %d" % (self.강의명, self.교수명, self.강의시간["요일"], self.강의시간["시작교시"], self.강의시간["끝교시"]))


class 시간표:
    index = {
        "월" : 0,
        "화" : 1,
        "수" : 2,
        "목" : 3,
        "금" : 4
    }

    def __init__(self):
        self.matrix = [["공강" for i in range(5)] for j in range(7)]
        self.강의목록 = []


    def 추가(self, 강의):
        self.강의목록.append(강의)
        col_index = 시간표.index[강의.강의시간["요일"]]
        
        for i in range(강의.강의시간["시작교시"] - 1, 강의.강의시간["끝교시"]):
            self.matrix[i][col_index] = 강의.강의명


    def 교수검색(self, 교수명):
        print("교수명 %s 강의정보 검색결과" % 교수명)
        col_count = 1
        for i in self.강의목록:
            if 교수명 == i.교수명:
                print(col_count, end = ". ")
                i.전체출력()
                col_count += 1
        

    def 요일검색(self, 요일):
        row_index = 시간표.index[요일]

        print("%s요일 강의정보 검색결과" % 요일)
        col_count = 1
        for col in self.matrix:
            print(col_count, end = ". ")
            print(col[row_index])
            col_count += 1
            

    def 전체출력(self):
        print("\t%15s\t%15s\t%15s\t%15s\t%15s\t" % ("월", "화", "수", "목", "금"))

        col_count = 1
        for col in self.matrix:
            print(col_count, end = "\t")
            for data in col:
                print("%15s" % data, end = "\t")
            print()
            col_count += 1


# test
MySchedule = 시간표()

IoT응용기술 = 강의("IoT응용기술", "정세일", {"요일" : "목", "시작교시" : 5, "끝교시" : 7})
MySchedule.추가(IoT응용기술)

프로젝트패키징1 = 강의("프로젝트", "이용희", {"요일" : "월", "시작교시" : 1, "끝교시" : 3})
MySchedule.추가(프로젝트패키징1)

프로젝트패키징2 = 강의("프로젝트", "이용희", {"요일" : "수", "시작교시" : 1, "끝교시" : 3})
MySchedule.추가(프로젝트패키징2)

빅데이터 = 강의("빅데이터", "성재경", {"요일" : "월", "시작교시" : 5, "끝교시" : 7})
MySchedule.추가(빅데이터)

IT영어이해 = 강의("IT영어이해", "장종준", {"요일" : "화", "시작교시" : 5, "끝교시" : 7})
MySchedule.추가(IT영어이해)

프레젠테이션실습 = 강의("프레젠테이션", "정미아", {"요일" : "목", "시작교시" : 5, "끝교시" : 7})
MySchedule.추가(프레젠테이션실습)

MySchedule.요일검색("목")
MySchedule.교수검색("정세일")
MySchedule.교수검색("이용희")
MySchedule.전체출력()
