print("Type=portforward # Do not modify")
print("Version=1.0.0 # Do not modify")
print("lang=utf-8 # Do not modify")
print()
# [10]
# enable=1
# {
# protocol=tcpudp
# extern_port=10010-10010
# local_port=22-22
# local_ip=192.168.0.10
# }


for i in range (2, 10):
    print("[%d]" % i)
    print("enable=1")
    print("{")
    print("protocol=tcpudp")
    print("extern_port=%d-%d" % (10000+i, 10000+i))
    print("local_port=22-22")
    print("local_ip=192.168.0.%d" % i)
    print("}")

