class Node:
    def __init__(self):
        self.data = None
        self.link = None


node1 = Node()
node2 = Node()

top = node1
rear = node1

print(rear)
print(top)

rear = rear.link
print(rear)
node3 = Node()

