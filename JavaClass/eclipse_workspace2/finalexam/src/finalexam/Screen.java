package finalexam;

import java.util.Scanner;

public class Screen {
	
	char exit;
	Scanner scan = new Scanner(System.in);
	
	
	public void items() {
		System.out.println("-----------------------------------------------");
        System.out.println("1.콜라(600), 2.환타(550), 3.커피(370), 4.물(420)");
        System.out.println("-----------------------------------------------");
        System.out.println();
	}
	
	
	public boolean chooseContinue() {
		
		while (true){
			System.out.print("추가 선택 하시겠습니까(y/n)? ");
	        exit = scan.next().charAt(0);
	        
	        if (exit == 'y' || exit == 'Y') {
	        	return true;
	        }   
	        else if(exit == 'n' || exit == 'N') {
	        	return false;
	        }
	        else {
	        	System.out.println("잘못된 입력입니다. 다시 선택해 주세요.");
	        }
		}
	}
}
