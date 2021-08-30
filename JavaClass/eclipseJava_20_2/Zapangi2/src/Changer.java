import java.util.Scanner;

public class Changer {

	static Scanner scan;
	static int money = 0;
	static int t_money = 0;
	static Zapangi za;
	static DAO db;
	
	public Changer() {
		scan = new Scanner(System.in);
		za = new Zapangi();
		db = new DAO();
		db.opCoin();
	}
	
	public void doBusiness() {
		while(true) {
			if (money == 0) {
				inputCoin();
			}
			
			za.SelectDrink(money);
			System.out.println("추가 선택 하시겠습니까?(y/n) ");
			char exit = scan.next().charAt(0);
			if(exit == 'n' || exit == 'N') {
				System.out.println("선택을 안합니다.");
				outputCoin();
				break;
			} else if (exit == 'y' || exit == 'Y') {
				money = t_money;
				System.out.println("현재 잔액(doBusiness) : " + money + ", t_money : " + t_money);
				
			}
		}
	}
	
	static void placeOrder(Selector order) {
		if (db.checkAct(order.getName()) == false) {
			za.SelectDrink(money);
		} else {
			System.out.println(order.getName() + "을 주문 하셨습니다. 주문 금액은 " + order.getPrice() + "원 입니다.");
			db.addOrder(order);
		}
		
	}
	
	static void inputCoin() {	
		System.out.print("금액을 입력하세요 : ");
		int s = scan.nextInt();
		if (s < 10) {
			System.out.println("10원 이상의 금액을 입력해 주세요");
			inputCoin();
			return;
		}
		money += s;
		t_money = money;
		System.out.println("현재 잔액 (inputCoin) : " + money + ", t_money : " + t_money);
		db.account(s, 0);	// account에 넣은 돈 추가
	}
	
	static void outputCoin() {	// 새로 추가
		if (t_money <= 0) {
			return;
		} else {
			System.out.println("현재 잔액 (outputCoin) : " + t_money + "원 반환합니다.");
			db.account(0, t_money);
			t_money = 0;
		}
		
	}
	
	static void CheckM(int money, Selector order) {
		char sel;
		if(money < order.getPrice()) {
			System.out.println("잔액이 부족합니다. ");
			System.out.println("금액을 더 넣으시겠습니까? (y/n)");
			sel = scan.next().charAt(0);
			if(sel == 'y' || sel == 'Y') {
				inputCoin();
				money = t_money;
				za.SelectDrink(money);
			} else if (sel == 'n' || sel == 'N') {
				outputCoin();
				System.out.println("자판기 종료");
				System.exit(0);
			}
		} else {
			changePay(money, order);
		}
	}
	
	static void changePay(int money, Selector order) {
		int change = money - order.getPrice();
//		db.account(money, change); // 생략
		db.calCoins(change);
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("뽑으신 음료수 " + order.getName() + "이며 거스름 돈은 " + change + "원 입니다.");
		System.out.print("10000원 : " + db.coins[0] + ", ");
		System.out.print("5000원 : " + db.coins[1] + ", ");
		System.out.print("1000원 : " + db.coins[2] + ", ");
		System.out.print("500원 : " + db.coins[3] + ", ");
		System.out.print("100원 : " + db.coins[4] + ", ");
		System.out.print("50원 : " + db.coins[5] + ", ");
		System.out.print("10원 : " + db.coins[6]);
		System.out.println("-----------------------------------");
		System.out.println();
		
		t_money = change;
		System.out.println("현재 잔액(changePay) : " + change + ", t_money : " + t_money);
	}
}
