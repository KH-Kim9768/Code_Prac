from flask import Flask                 # 서버 구현을 위한 Flask 객체 import
from flask_restx import Api, Resource   # Api 구현을 위한 Api 객체 import

app = Flask(__name__)   # Flask 객체 선언, 파라미터로 어플리케이션 패키지의 이름을 넣어줌
api = Api(app)          # Flask 객체에 Api 객체 등록


@api.route('/hello')  # 데코레이터 이용, '/hello' 경로에 클래스 등록
class HelloWorld(Resource):
    def get(self):  # GET 요청시 리턴 값에 해당 하는 dict를 JSON 형태로 반환
        return {"hello": "world!"}

@api.route('/led')
class GetLedState(Resource):
    def get(self):
        return {"Response" : 3}

@api.route('/led/<int:state>')  # /led/3 -> 복수개의 LED에서 ID가 3인 LED의 상태를 질의
class SetLedSTate(Resource):
    def get(self, state):   # 원래는 값을 변경하는 것이기 때문에 RESTful - 'PUT'으로 해야함
        return {"Response" : state}

@api.route('/reset')
class Reset(Resource):
    def get(self):
        return {"Response" : "OK"}

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

