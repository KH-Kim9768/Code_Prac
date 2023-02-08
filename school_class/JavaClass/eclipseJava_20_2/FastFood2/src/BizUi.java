import java.util.Scanner;

public class BizUi {

	private Scanner scan;
	private Service serv;
	public BizUi(){
		scan = new Scanner(System.in);
		serv = new Service();
	}
	
	String item = null;
	int suryang = 0;
	int choice;
	public void showBiz(){
		System.out.println("주문하세요.....");
		System.out.println("1.햄버거  2.음료수  3.세트  4.종료");
		String menu = scan.nextLine();
		if (menu.equals("4") == true) {
			System.out.println("종료합니다.");
			return;
		}else {
			getBiz(menu);
		}
		showBiz();
	}
	
	public void getBiz(String menuStr){
		System.out.println("상세 주문을 하세요:키보드입력  ");
		
		if (menuStr.equals("1") == true) {
			System.out.println("햄버거를 고르세요~~~~");
			System.out.println("1. 치즈버거  2. 불고기버거  3. 상하이버거  4. 빅맥");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "치즈";
			}else if (choice == 2) {
				item = "불고기";
			}else if (choice == 3) {
				item = "상하이";
			}else if (choice == 4) {
				item = "빅맥";
			}
	
		}else if (menuStr.equals("2") == true) {
			System.out.println("음료수를 고르세요~~~~");
			System.out.println("1. 콜라  2. 사이다  3. 환타  4. 물");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "콜라";
			}else if (choice == 2) {
				item = "사이다";
			}else if (choice == 3) {
				item = "환타";
			}else if (choice == 4) {
				item = "물";
			}
	
		}else if (menuStr.equals("3") == true) {
			System.out.println("세트를 고르세요~~~~");
			System.out.println("1. 치즈버거세트  2. 불고기버거세트  3. 상하이버거세트  4. 빅맥세트");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "치즈버거";
			}else if (choice == 2) {
				item = "불고기버거";
			}else if (choice == 3) {
				item = "상하이버거";
			}else if (choice == 4) {
				item = "빅맥";
			}

		}

		System.out.println("수량을 고르세요~~~~");
		int suryang = Integer.parseInt(scan.nextLine());
		Store newuser = new Store(menuStr, choice, item, suryang);
		serv.order(newuser);

		System.out.println("--------------------UI 화면입니다.--------------------------");
	}

}
