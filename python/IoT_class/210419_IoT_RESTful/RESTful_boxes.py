from flask import Flask, request                 # 서버 구현을 위한 Flask 객체 import
from flask_restx import Api, Resource, fields   # Api 구현을 위한 Api 객체 import


app = Flask(__name__)   # Flask 객체 선언, 파라미터로 어플리케이션 패키지의 이름을 넣어줌
api = Api(app)          # Flask 객체에 Api 객체 등록

model_box = api.model('box', {
    'value' : fields.Integer()
})

'''
@api.route('/hello')  # 데코레이터 이용, '/hello' 경로에 클래스 등록
class HelloWorld(Resource):
    def get(self):  # GET 요청시 리턴 값에 해당 하는 dict를 JSON 형태로 반환
        return {"hello": "world!"}
'''

boxes = { 5 : 200, 9 : 300}

@api.route('/boxes')
class Boxes(Resource):
    def get(self):
        global boxes
        return boxes

@api.route('/boxes/<int:boxId>')
class BoxDetail(Resource):
    def get(self, boxId):   
        return boxes[boxId]

    @api.expect(model_box)  # 데코레이터
    @api.marshal_with(model_box, code=201)
    def post(self, boxId):
        global boxes
        value = request.json['value']
        boxes[boxId] = value
        return 'OK'

    @api.expect(model_box)
    @api.marshal_with(model_box, code=201)
    def put(self, boxId):
        global boxes
        value = request.json['value']
        boxes[boxId] = value
        return 'OK'


    def delete(self, boxId):
        global boxes
        del boxes[boxId]
        # del(boxes[boxId])
        return 'Ok'



if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

