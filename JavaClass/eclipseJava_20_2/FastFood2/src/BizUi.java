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
		System.out.println("�ֹ��ϼ���.....");
		System.out.println("1.�ܹ���  2.�����  3.��Ʈ  4.����");
		String menu = scan.nextLine();
		if (menu.equals("4") == true) {
			System.out.println("�����մϴ�.");
			return;
		}else {
			getBiz(menu);
		}
		showBiz();
	}
	
	public void getBiz(String menuStr){
		System.out.println("�� �ֹ��� �ϼ���:Ű�����Է�  ");
		
		if (menuStr.equals("1") == true) {
			System.out.println("�ܹ��Ÿ� ������~~~~");
			System.out.println("1. ġ�����  2. �Ұ�����  3. �����̹���  4. ���");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "ġ��";
			}else if (choice == 2) {
				item = "�Ұ��";
			}else if (choice == 3) {
				item = "������";
			}else if (choice == 4) {
				item = "���";
			}
	
		}else if (menuStr.equals("2") == true) {
			System.out.println("������� ������~~~~");
			System.out.println("1. �ݶ�  2. ���̴�  3. ȯŸ  4. ��");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "�ݶ�";
			}else if (choice == 2) {
				item = "���̴�";
			}else if (choice == 3) {
				item = "ȯŸ";
			}else if (choice == 4) {
				item = "��";
			}
	
		}else if (menuStr.equals("3") == true) {
			System.out.println("��Ʈ�� ������~~~~");
			System.out.println("1. ġ����ż�Ʈ  2. �Ұ����ż�Ʈ  3. �����̹��ż�Ʈ  4. ��Ƽ�Ʈ");
			choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				item = "ġ�����";
			}else if (choice == 2) {
				item = "�Ұ�����";
			}else if (choice == 3) {
				item = "�����̹���";
			}else if (choice == 4) {
				item = "���";
			}

		}

		System.out.println("������ ������~~~~");
		int suryang = Integer.parseInt(scan.nextLine());
		Store newuser = new Store(menuStr, choice, item, suryang);
		serv.order(newuser);

		System.out.println("--------------------UI ȭ���Դϴ�.--------------------------");
	}

}
