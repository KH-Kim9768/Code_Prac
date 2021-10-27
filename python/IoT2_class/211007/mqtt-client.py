import paho.mqtt.client as mqtt

# function start

def on_connect(client, userdata, flags, rc):
    print("Connected with result code " + str(rc) )

    # '#'은 전체를 의미
    client.subscribe("$SYS/#")
    # client.subscribe("$SYS/broker/publish/#")
    # client.subscribe("$SYS/+/publish/#")

def on_message(client, userdata, msg):
    print(msg.topic + " " + str(msg.payload))


# function end

client = mqtt.Client()

client.on_connect = on_connect
client.on_message = on_message

client.connect("mqtt.eclipseprojects.io", 1883, 60)
client.loop_forever()