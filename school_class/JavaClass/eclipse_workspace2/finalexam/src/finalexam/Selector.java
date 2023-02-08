package finalexam;

import java.util.Scanner;

public class Selector {
	
	Scanner scan = new Scanner(System.in);
	int sel;
	
	public int SelectDrink() { 
		while(true) {

	        System.out.print("음료를 선택하세요: ");
	        sel = (int) (scan.next().charAt(0)) -48;
	
	        if (sel < 1 || sel > 4) {
	            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	            continue;
	        }
	        
	        else {                         
	        	return sel;
	            }
	    }
	}

}
