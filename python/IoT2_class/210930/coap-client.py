from coapthon.client.helperclient import HelperClient

client = HelperClient(server=("127.0.0.1", 5683))
response_hello = client.get("hello-world/")
print(response_hello.payload)

client = HelperClient(server=("127.0.0.1", 5683))
response_ping = client.get("ping/")
print(response_ping.payload)

client = HelperClient(server=("127.0.0.1", 5683))
response_ping = client.get("weather/")
print(response_ping.payload)

client.stop()