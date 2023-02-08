import java.util.Scanner;

public class Changer {
	
	static Scanner scan = new Scanner(System.in);
	static void ChangerPay(int money, int s, String drink){ // 또는 ChangerPay(int money, int s, String drink, int choice, int count)
		int temp;
		int m_10000, m_5000, m_1000, m_500, m_100, m_50, m_10;
		char sel;
		
		if (money < s) {
			System.out.println("금액이 부족하다.");
			System.out.println("금액을 더 넣을래????(y/n)");
			sel = scan.next().charAt(0);
			
			if (sel == 'y') {
				Screen.InputCoin();
			} else if(sel == 'n'){
				System.out.println("자판기 종료");
				System.exit(0);
			} else {
				Selector.SelectDrink(money);
			}
		} else {
			money -= s;
			m_10000 = money / 10000;
			temp = money % 10000;
			m_5000 = temp / 5000;
			temp = temp % 5000;
			m_1000 = temp / 1000;
			temp = temp % 1000;
			m_500 = temp / 500;
			temp = temp % 500;
			m_100 = temp / 100;
			temp = temp % 100;
			m_50 = temp / 50;
			temp = temp % 50;
			m_10 = temp / 10;
			

			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("뽑으신 음료수는 " + drink + "이며 거스름돈은 " + money + "원입니다");
			System.out.print(" 거스름돈 : ");
			System.out.print(" 10000 : " + m_10000);
			System.out.print(", 5000 : "+ m_5000);
			System.out.print(", 1000 : "+ m_1000);
			System.out.print(", 500 : "+ m_500);
			System.out.print(", 100 : "+ m_100);
			System.out.print(", 50 : "+ m_50);
			System.out.print(", 10 : "+ m_10);
			System.out.println();
			// 또는  Changer.ChangerPay(money, COKE, D1, 1, coke_count); 로 수정 시 
			//     DrinkDAO.panmae(choice, count);
			Screen.t_money = money;
		}
		
	}
}

