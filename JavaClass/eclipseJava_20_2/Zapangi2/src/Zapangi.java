import java.util.Scanner;

public class Zapangi {

	static Changer biz;
	Selector order;
	Scanner scan;
	
	public Zapangi() {
		scan = new Scanner(System.in);
	}
	
	public void show() {
		System.out.println("���Ǳ� ���α׷�");
		System.out.println("------------------------------------------------");
		System.out.println("1. �ݶ�(600)  2. ȯŸ(550)  3. Ŀ��(370)  4. ��(420)");
		System.out.println("------------------------------------------------");
		System.out.println();
	}
	
	public void SelectDrink(int money) {
		int sel;
		System.out.println("������� �����ϼ���. ");
		sel = (int) (scan.next().charAt(0)) - 48;
		if (sel < 1 || sel > 4) {
			System.out.println("������� ����� ������.(1~4)");
			SelectDrink(money);
		} else {
			order = new Selector(sel);
			biz.placeOrder(order);
			biz.CheckM(money, order);
		}
	}
}
