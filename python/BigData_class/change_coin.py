money = int(input("돈을 넣으세요 : "))

change_500 = money // 500
money = money % 500

change_100 = money // 100
money = money % 100

change_50 = money // 50
money = money % 50

change_10 = money // 10
money = money % 10

print("500원짜리 동전 => %d개 \n 100원짜리 동전 => %d개 \n 50원짜리 동전 => %d개\n 10원짜리 동전 => %d개 \n 바꾸지 못한 잔돈 => %d개" % (change_500, change_100, change_50, change_10, money))
