
import java.util.Scanner;

public class Screen {
	static Scanner scan = new Scanner(System.in);
	static int money;
	static int t_money = 0;
	

	public void show() {
		char exit;

		System.out.println("���Ǳ� ���α׷�");
		System.out.println("------------------------------------------------");
		System.out.println("1. �ݶ�(600)  2. ȯŸ(550)  3. Ŀ��(370)  4. ��(420)");
		System.out.println("------------------------------------------------");
		System.out.println();

		money = 0;
		while (true) {
			if (money == 0) {
				money = InputCoin();
			}

			Selector.SelectDrink(money);
			System.out.println("�߰� ���� �ҷ�????(y/n)");

			exit = scan.next().charAt(0);
			money = t_money;

			if (exit == 'n' || exit == 'N') {
				System.out.println("����� ���� ����");
		
				break;
			}
			System.out.println();
		}
	}

	static int InputCoin() {
		System.out.println("�ݾ��� �Է��ϼ��� : ");
		money = scan.nextInt();
		money += t_money;
		t_money = money;
		return money;
	}
}

