
import java.util.Scanner;

public class Screen {
	static Scanner scan = new Scanner(System.in);
	static int money;
	static int t_money = 0;
	

	public void show() {
		char exit;

		System.out.println("자판기 프로그램");
		System.out.println("------------------------------------------------");
		System.out.println("1. 콜라(600)  2. 환타(550)  3. 커피(370)  4. 물(420)");
		System.out.println("------------------------------------------------");
		System.out.println();

		money = 0;
		while (true) {
			if (money == 0) {
				money = InputCoin();
			}

			Selector.SelectDrink(money);
			System.out.println("추가 선택 할래????(y/n)");

			exit = scan.next().charAt(0);
			money = t_money;

			if (exit == 'n' || exit == 'N') {
				System.out.println("음료수 선택 종료");
		
				break;
			}
			System.out.println();
		}
	}

	static int InputCoin() {
		System.out.println("금액을 입력하세요 : ");
		money = scan.nextInt();
		money += t_money;
		t_money = money;
		return money;
	}
}

