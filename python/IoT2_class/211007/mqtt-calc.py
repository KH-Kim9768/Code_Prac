import paho.mqtt.client as mqtt

calc_list = ['+', '-', '*', '/']

# function start

def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc) )

    # '#'은 전체를 의미
    client.subscribe("shingu/calc/#")

def on_message(client, userdata, msg):
    print(msg.topic + " " + msg.payload.decode('utf-8'))
    
    # if msg.topic == "shingu/calc/in/2015132076":
    if msg.topic.startswith("shingu/calc/in/"):
        result = 0
        message = msg.payload.decode('utf-8')
        
        for calc in calc_list:
            if calc in message:
                try:
                    result = eval(message)
                    client.publish("shingu/calc/out/2015132076", result, 1, False)
                except:
                    result = 0
                
# function end

client = mqtt.Client()

client.on_connect = on_connect
client.on_message = on_message

client.connect("mqtt.eclipseprojects.io", 1883, 60)
# client.loop_forever()
client.loop_start()

# client.publish("shingu/2015132076", "", 1, True)
# while 
while True:
    # 1 콘솔에서 문자열을 입력받아 출력한다.
    input_str = input("메세지를 입력하세요 : ")
    # print(input_str)

    if input_str == "0":
        break

    # 2 paho.mqtt.client를 이용해 게시 하는 소스 코드
    client.publish("shingu/calc/in/2015132076", input_str, 1, False)

client.loop_stop()