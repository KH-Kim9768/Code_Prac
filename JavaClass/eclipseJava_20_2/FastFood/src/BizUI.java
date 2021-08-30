import java.util.Scanner;

public class BizUI {
	// 화면만 처리하는 클래스
	
	private Scanner scan;
	private Service serv;
	String item = null;
	int suryang = 0;
	
	
	public BizUI() {
		scan = new Scanner(System.in);
		serv = new Service();
	}
	
	public void showBiz() {
		
		System.out.println("안녕하세요. 맥데리아입니다. 주문하세요 .....");
		System.out.println("1. 햄버거  2. 음료수  3. 세트  4. 종료");
		String menu = scan.nextLine();
		if (menu.equals("4")){
			System.out.println("종료합니다.");
			return;
		} else {
			getBiz(menu);
		}
		showBiz();
	}
	
	public void getBiz(String menuStr) {
		System.out.println("상세 주문을 하세요 : 키보드 입력");
		int choice;
		if(menuStr.equals("1")) {
			System.out.println("1. 치즈버거  2. 불고기버거  3. 상하이버거  4. 빅맥");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "치즈버거";
				
			} else if (choice == 2) {
				item = "불고기버거";
				
			} else if (choice == 3) {
				item = "상하이버거";
				
			} else if (choice == 4) {
				item = "빅맥";
			}
		} else if (menuStr.equals("2")) {
			System.out.println("1. 콜라  2. 사이다  3. 환타  4. 물");
			choice = Integer.parseInt(scan.nextLine());
			if(choice == 1) {
				item = "콜라";
				
			} else if (choice == 2) {
				item = "사이다";
				
			} else if (choice == 3) {
				item = "환타";
				
			} else if (choice == 4) {
				item = "물";
			}
		} else if (menuStr.equals("3")) {
			System.out.println(" 1. 치즈버거 세트  2. 불고기버거 세트  3. 상하이버거 세트  4. 빅맥 세트");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "치즈버거 세트";
			} else if (choice == 2) {
				item = "불고기버거 세트";
				
			} else if (choice == 3) {
				item = "상하이버거 세트";
				
			} else if (choice == 4) {
				item = "빅맥 세트";
			}
		}
		
		System.out.println("수량을 고르세요!!");
		suryang = choice = Integer.parseInt(scan.nextLine());
		
		Store newuser = new Store(menuStr, choice, item, suryang);
		serv.order(newuser);
		System.out.println("--------------------UI 화면입니다.-----------------");
	}
	
	

}
