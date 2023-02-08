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
			System.out.println("�߰� ���� �Ͻðڽ��ϱ�?(y/n) ");
			char exit = scan.next().charAt(0);
			if(exit == 'n' || exit == 'N') {
				System.out.println("������ ���մϴ�.");
				outputCoin();
				break;
			} else if (exit == 'y' || exit == 'Y') {
				money = t_money;
				System.out.println("���� �ܾ�(doBusiness) : " + money + ", t_money : " + t_money);
				
			}
		}
	}
	
	static void placeOrder(Selector order) {
		if (db.checkAct(order.getName()) == false) {
			za.SelectDrink(money);
		} else {
			System.out.println(order.getName() + "�� �ֹ� �ϼ̽��ϴ�. �ֹ� �ݾ��� " + order.getPrice() + "�� �Դϴ�.");
			db.addOrder(order);
		}
		
	}
	
	static void inputCoin() {	
		System.out.print("�ݾ��� �Է��ϼ��� : ");
		int s = scan.nextInt();
		if (s < 10) {
			System.out.println("10�� �̻��� �ݾ��� �Է��� �ּ���");
			inputCoin();
			return;
		}
		money += s;
		t_money = money;
		System.out.println("���� �ܾ� (inputCoin) : " + money + ", t_money : " + t_money);
		db.account(s, 0);	// account�� ���� �� �߰�
	}
	
	static void outputCoin() {	// ���� �߰�
		if (t_money <= 0) {
			return;
		} else {
			System.out.println("���� �ܾ� (outputCoin) : " + t_money + "�� ��ȯ�մϴ�.");
			db.account(0, t_money);
			t_money = 0;
		}
		
	}
	
	static void CheckM(int money, Selector order) {
		char sel;
		if(money < order.getPrice()) {
			System.out.println("�ܾ��� �����մϴ�. ");
			System.out.println("�ݾ��� �� �����ðڽ��ϱ�? (y/n)");
			sel = scan.next().charAt(0);
			if(sel == 'y' || sel == 'Y') {
				inputCoin();
				money = t_money;
				za.SelectDrink(money);
			} else if (sel == 'n' || sel == 'N') {
				outputCoin();
				System.out.println("���Ǳ� ����");
				System.exit(0);
			}
		} else {
			changePay(money, order);
		}
	}
	
	static void changePay(int money, Selector order) {
		int change = money - order.getPrice();
//		db.account(money, change); // ����
		db.calCoins(change);
		
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("������ ����� " + order.getName() + "�̸� �Ž��� ���� " + change + "�� �Դϴ�.");
		System.out.print("10000�� : " + db.coins[0] + ", ");
		System.out.print("5000�� : " + db.coins[1] + ", ");
		System.out.print("1000�� : " + db.coins[2] + ", ");
		System.out.print("500�� : " + db.coins[3] + ", ");
		System.out.print("100�� : " + db.coins[4] + ", ");
		System.out.print("50�� : " + db.coins[5] + ", ");
		System.out.print("10�� : " + db.coins[6]);
		System.out.println("-----------------------------------");
		System.out.println();
		
		t_money = change;
		System.out.println("���� �ܾ�(changePay) : " + change + ", t_money : " + t_money);
	}
}
