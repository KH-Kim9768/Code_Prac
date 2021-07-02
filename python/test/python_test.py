from test import *
from test1 import *
import test2
import time
import threading

test1()
test2.test2()

state = True
print(state)
state = not state
print(state)

ii = [0, 1, 2, 3, 4, 5]
for i in ii:
    i = 0
print(ii)

i2 = [{'a1' : 'a1 val1', 'a2' : 'a2 val1'}, {'a1' : 'a1 val2', 'a2' : 'a2 val2'}]
for i in i2:
    print(i['a1'])
    print(i['a2'])
    
