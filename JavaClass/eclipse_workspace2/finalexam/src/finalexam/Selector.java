package finalexam;

import java.util.Scanner;

public class Selector {
	
	Scanner scan = new Scanner(System.in);
	int sel;
	
	public int SelectDrink() { 
		while(true) {

	        System.out.print("���Ḧ �����ϼ���: ");
	        sel = (int) (scan.next().charAt(0)) -48;
	
	        if (sel < 1 || sel > 4) {
	            System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
	            continue;
	        }
	        
	        else {                         
	        	return sel;
	            }
	    }
	}

}
