import paho.mqtt.client as mqtt

'''

1. 콘솔에서 문자열을 입력받아 출력한다. 입력 -> print(message)
2. 구글링을 해서 paho.mqtt.client를 이용해 게시(publish) 하는 
    소스코드를 획득한다.
3. 클라이언트 코드를 참고해서 키보드로 입력된 값을 ("shingu/학번", 입력된 메시지)로 게시한다

'''

# function start

def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc) )

    # '#'은 전체를 의미
    # client.subscribe("$SYS/#")
    # client.subscribe("$SYS/broker/publish/#")
    # client.subscribe("$SYS/+/publish/#")
    client.subscribe("shingu/#")

def on_message(client, userdata, msg):
    print(msg.topic + " " + msg.payloade.decode('utf-8'))


# def on_publish(client, userdata, mid):
#     print("Publish complete, mid = ", mid)


# function end


# mqtt Client
client = mqtt.Client()

client.on_connect = on_connect
client.on_message = on_message
# client.on_publish = on_publish

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
    client.publish("shingu/2015132076", input_str, 1, False)

client.loop_stop()