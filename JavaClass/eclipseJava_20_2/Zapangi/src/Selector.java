
import java.util.Scanner;

public class Selector {
	static Scanner scan = new Scanner(System.in);
	final static int COKE = 600;
	final static int FANTA = 550;
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "콜라";
	final static String D2 = "환타";
	final static String D3 = "커피";
	final static String D4 = "물";
	
	static int coke_count = 0;
	static int fanta_count = 0;
	static int coffee_count = 0;
	static int water_count = 0;
	

	public static void SelectDrink(int money) {

		int sel;
		System.out.println("음료수를 선택하세요 : ");
		sel = (int) (scan.next().charAt(0)) - 48;

		if (sel < 1 || sel > 4) {
			System.out.println("잘못된 선택 : (1 ~ 4) 사이 선택");
			SelectDrink(money);
		} else {
			switch (sel) {
			case 1:
				coke_count++; 
				Changer.ChangerPay(money, COKE, D1);
				DrinkDAO.panmae(1, coke_count);
				// 또는 Changer.ChangerPay(money, COKE, D1, 1, coke_count);
				break;
			case 2:
				fanta_count += 1;
				Changer.ChangerPay(money, FANTA, D2);
				DrinkDAO.panmae(2, fanta_count);
				break;
			case 3:
				coffee_count += 1;
				Changer.ChangerPay(money, COFFEE, D3);
				DrinkDAO.panmae(3, coffee_count);
				break;
			case 4:
				water_count += 1;
				Changer.ChangerPay(money, WATER, D4);
				DrinkDAO.panmae(4, water_count);
				break;

			default:
				System.out.println("선택 에러");
				break;
			}

		}

	}
}


