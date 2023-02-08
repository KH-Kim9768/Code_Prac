import java.util.Scanner;

public class Zapangi {

	static Changer biz;
	Selector order;
	Scanner scan;
	
	public Zapangi() {
		scan = new Scanner(System.in);
	}
	
	public void show() {
		System.out.println("자판기 프로그램");
		System.out.println("------------------------------------------------");
		System.out.println("1. 콜라(600)  2. 환타(550)  3. 커피(370)  4. 물(420)");
		System.out.println("------------------------------------------------");
		System.out.println();
	}
	
	public void SelectDrink(int money) {
		int sel;
		System.out.println("음료수를 선택하세요. ");
		sel = (int) (scan.next().charAt(0)) - 48;
		if (sel < 1 || sel > 4) {
			System.out.println("음료수를 제대로 고르세요.(1~4)");
			SelectDrink(money);
		} else {
			order = new Selector(sel);
			biz.placeOrder(order);
			biz.CheckM(money, order);
		}
	}
}
