n = int(input())

arr = input().split()

for i in range(n):
    arr[i] = int(arr[i])

for i in range(1, len(arr)): # n 
    print(arr[i] - arr[i-1], end = ' ')