import java.util.Scanner;

public class BizUI {
	// ȭ�鸸 ó���ϴ� Ŭ����
	
	private Scanner scan;
	private Service serv;
	String item = null;
	int suryang = 0;
	
	
	public BizUI() {
		scan = new Scanner(System.in);
		serv = new Service();
	}
	
	public void showBiz() {
		
		System.out.println("�ȳ��ϼ���. �Ƶ������Դϴ�. �ֹ��ϼ��� .....");
		System.out.println("1. �ܹ���  2. �����  3. ��Ʈ  4. ����");
		String menu = scan.nextLine();
		if (menu.equals("4")){
			System.out.println("�����մϴ�.");
			return;
		} else {
			getBiz(menu);
		}
		showBiz();
	}
	
	public void getBiz(String menuStr) {
		System.out.println("�� �ֹ��� �ϼ��� : Ű���� �Է�");
		int choice;
		if(menuStr.equals("1")) {
			System.out.println("1. ġ�����  2. �Ұ�����  3. �����̹���  4. ���");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "ġ�����";
				
			} else if (choice == 2) {
				item = "�Ұ�����";
				
			} else if (choice == 3) {
				item = "�����̹���";
				
			} else if (choice == 4) {
				item = "���";
			}
		} else if (menuStr.equals("2")) {
			System.out.println("1. �ݶ�  2. ���̴�  3. ȯŸ  4. ��");
			choice = Integer.parseInt(scan.nextLine());
			if(choice == 1) {
				item = "�ݶ�";
				
			} else if (choice == 2) {
				item = "���̴�";
				
			} else if (choice == 3) {
				item = "ȯŸ";
				
			} else if (choice == 4) {
				item = "��";
			}
		} else if (menuStr.equals("3")) {
			System.out.println(" 1. ġ����� ��Ʈ  2. �Ұ����� ��Ʈ  3. �����̹��� ��Ʈ  4. ��� ��Ʈ");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "ġ����� ��Ʈ";
			} else if (choice == 2) {
				item = "�Ұ����� ��Ʈ";
				
			} else if (choice == 3) {
				item = "�����̹��� ��Ʈ";
				
			} else if (choice == 4) {
				item = "��� ��Ʈ";
			}
		}
		
		System.out.println("������ ������!!");
		suryang = choice = Integer.parseInt(scan.nextLine());
		
		Store newuser = new Store(menuStr, choice, item, suryang);
		serv.order(newuser);
		System.out.println("--------------------UI ȭ���Դϴ�.-----------------");
	}
	
	

}
