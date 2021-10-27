# UDP 실습

from socket import *

host = "slogs.dev"
port = 30001

c = socket(AF_INET, SOCK_DGRAM)
msg = "김광희"
c.sendto(msg.encode('utf-8'), (host, port))

c.close()