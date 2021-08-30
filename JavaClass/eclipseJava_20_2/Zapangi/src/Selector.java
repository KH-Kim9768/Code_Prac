
import java.util.Scanner;

public class Selector {
	static Scanner scan = new Scanner(System.in);
	final static int COKE = 600;
	final static int FANTA = 550;
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "�ݶ�";
	final static String D2 = "ȯŸ";
	final static String D3 = "Ŀ��";
	final static String D4 = "��";
	
	static int coke_count = 0;
	static int fanta_count = 0;
	static int coffee_count = 0;
	static int water_count = 0;
	

	public static void SelectDrink(int money) {

		int sel;
		System.out.println("������� �����ϼ��� : ");
		sel = (int) (scan.next().charAt(0)) - 48;

		if (sel < 1 || sel > 4) {
			System.out.println("�߸��� ���� : (1 ~ 4) ���� ����");
			SelectDrink(money);
		} else {
			switch (sel) {
			case 1:
				coke_count++; 
				Changer.ChangerPay(money, COKE, D1);
				DrinkDAO.panmae(1, coke_count);
				// �Ǵ� Changer.ChangerPay(money, COKE, D1, 1, coke_count);
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
				System.out.println("���� ����");
				break;
			}

		}

	}
}


