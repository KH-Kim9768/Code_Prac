package finalexam;

import java.util.Scanner;

public class Screen {
	
	char exit;
	Scanner scan = new Scanner(System.in);
	
	
	public void items() {
		System.out.println("-----------------------------------------------");
        System.out.println("1.�ݶ�(600), 2.ȯŸ(550), 3.Ŀ��(370), 4.��(420)");
        System.out.println("-----------------------------------------------");
        System.out.println();
	}
	
	
	public boolean chooseContinue() {
		
		while (true){
			System.out.print("�߰� ���� �Ͻðڽ��ϱ�(y/n)? ");
	        exit = scan.next().charAt(0);
	        
	        if (exit == 'y' || exit == 'Y') {
	        	return true;
	        }   
	        else if(exit == 'n' || exit == 'N') {
	        	return false;
	        }
	        else {
	        	System.out.println("�߸��� �Է��Դϴ�. �ٽ� ������ �ּ���.");
	        }
		}
	}
}
