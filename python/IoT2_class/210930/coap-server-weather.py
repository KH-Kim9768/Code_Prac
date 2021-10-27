'''
CoAP를 통해 
네이버 날씨 불러오기


'''
from coapthon.server.coap import CoAP
from coapthon.resources.resource import Resource
import requests

# 전역변수
html_file_name = "weather.html"


class HelloWorldResource(Resource):
    def __init__(self, name="hello-world", coap_server=None):
        super(HelloWorldResource, self).__init__(name, coap_server, visible=True, observable=True, allow_children=True)

        self.payload = "Get a friendly getting!"

    def render_GET(self, request):
        self.payload = "Hello World from CoAPthon!"
        return self


class PingResource(Resource):
    def __init__(self, name="ping", coap_server = None):
        super(PingResource, self).__init__(name, coap_server, visible=True, observable=True, allow_children=True)

    def render_GET(self, request):
        self.payload = "pong!"
        return self

class WeatherResource(Resource):
    def __init__(self, name="weather", coap_server = None):
        super(WeatherResource, self).__init__(name, coap_server, visible=True, observable=True, allow_children=True)
    
    def render_GET(self, request):
        self.payload = get_weather_information()
        return self


class CoAPServer(CoAP):
    def __init__(self, host, port):
        CoAP.__init__(self, (host, port))
        self.add_resource('hello-world/', HelloWorldResource())
        self.add_resource("ping/", PingResource())
        self.add_resource("weather/", WeatherResource())


# 날씨 관련
# 태그 제거함수
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

# 날씨 데이터 불러와서 파일에 저장
def get_html_data():
    # url
    url = "https://weather.naver.com"

    # 페이지 정보 불러오기
    main_html = requests.get(url)
    

    # 불러온 페이지 weather.html로 저장
    with open(html_file_name, "w") as f:
        f.writelines(main_html.text)

# 날씨 데이터에서 정보 추출
def get_weather_information():
    
    # 날씨 정보 최신화
    get_html_data()

    data = ""

    with open(html_file_name, "r") as f:
        html_line = f.readline()
        while html_line != "</html>":

            # 현재온도
            if "현재 온도" in html_line:
                data += remove_tag(html_line) + "\n"
                # print(remove_tag(html_line))
            
            # 날씨 상태
            if 'class="summary"' in html_line:
                data += remove_tag_2(html_line, f) + "\n"
                # print(remove_tag_2(html_line, f))
                
            # 강수, 습도, 바람, 체감온도
            if 'summary_list' in html_line:
                for i in range(4):
                    data += remove_tag_2(html_line, f) + "\n"
                    # print(remove_tag_2(html_line, f))

            # 미세먼지, 초미세먼지, 자외선, 일몰
            if 'ttl_area' in html_line:
                data += remove_tag_2(html_line, f) + "\n"
                # print(remove_tag_2(html_line, f))

            html_line = f.readline()
        
        return data


if __name__ == "__main__":
    server = CoAPServer("0.0.0.0", 5683)
    try:
        print("Server Started.")
        server.listen(10)

    except KeyboardInterrupt:
        print("Server Shutdown")
        server.close()
        print("Exiting...")
