'''

문제 
네이버 날씨 https://weather.naver.com 의 html 을 문자열로 저장
저장된 문자열에서 특정 영역을 추출함
효율을 위해 파일로 한번 저장 후 구현은 파일로 저장된 html로 코드 진행
오늘 날씨 불러오기

'''
import requests

# function start
# 태그 제거 함수
def remove_tag(line):

    while "<" in line:
        
        s_index = line.find("<")
        e_index = line.find(">")
        line = line.replace(line[s_index:e_index+1], " ")
    
    line = line.strip()
    return line


# 2줄 항목 태그 제거 함수 
def remove_tag_2(line, f):

    result_str = ""

    line = f.readline()
    result_str = remove_tag(line)
    line = f.readline()
    result_str += " " + remove_tag(line)
    return result_str
# function end

# main start
if __name__ == "__main__":
    # url
    url = "https://weather.naver.com"

    # 페이지 정보 불러오기
    main_html = requests.get(url)
    html_file_name = "weather.html"


    # 불러온 페이지 weather.html로 저장
    with open(html_file_name, "w") as f:
        f.writelines(main_html.text)


    # weather.html 읽어 오고 원하는 값 불러오기
    with open(html_file_name, "r") as f:
        html_line = f.readline()
        while html_line != "</html>":

            # 현재온도
            if "현재 온도" in html_line:
                print(remove_tag(html_line))
            
            # 날씨 상태
            if 'class="summary"' in html_line:
                print(remove_tag_2(html_line, f))
                
            # 강수, 습도, 바람, 체감온도
            if 'summary_list' in html_line:
                for i in range(4):
                    print(remove_tag_2(html_line, f))

            # 미세먼지, 초미세먼지, 자외선, 일몰
            if 'ttl_area' in html_line:
                print(remove_tag_2(html_line, f))

            html_line = f.readline()
# main end