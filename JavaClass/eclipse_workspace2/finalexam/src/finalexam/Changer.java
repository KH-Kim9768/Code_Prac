package finalexam;

import java.util.Scanner;


public class Changer {
	
    int money;       
    int t_money=0;
    int re = 0;
    Scanner scan = new Scanner(System.in);
    
    public int InputCoin() {
        System.out.print("투입할 금액을 입력하세요: ");
        money = scan.nextInt();     
        money += t_money;   
        t_money = money;    
        return money;
    }
    
   public void ChangePay(int currentMoney, int s, String drink) { 
        int temp;
        int m_1000, m_500, m_100, m_50, m_10;
        char sel;
        money=currentMoney;
		
        if (money < s) {
        	while(true) {
	            System.out.println("금액이 부족합니다.");
	            System.out.print("돈을 더 넣으시겠습니까(y/n)? ");
	            sel = scan.next().charAt(0);
	
	            if(sel == 'y') {                      
	                InputCoin();
	                re = 1;
	                break;
	            }
	            else if (sel == 'n'){               
	            	System.out.println("음료를 다시 선택하세요.");
	            	break;
	            }
	            else {
	            	System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
	            	continue;
	            }
        	}
        }
        else {                      
            money -= s;
            m_1000 = money / 1000; 
            temp = money % 1000;
            m_500 = temp / 500;    
            temp = temp % 500;
            m_100 = temp / 100;    
            temp = temp % 100;
	        m_50 = temp / 50;    
            temp = temp % 50;
            m_10 = temp / 10;       

            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println("뽑으신 음료수는 " + drink +"이며 거스름돈은  " + money + "원 입니다.");
            System.out.print("1000원 : " + m_1000 + ", ");
            System.out.print("500원 : " + m_500 + ", ");
            System.out.print("100원 : " + m_100 + ", ");
            System.out.print("50원 : " + m_50 + ", ");
            System.out.println("10원 : " + m_10);
            System.out.println("---------------------------------------- -------");
            System.out.println();
            t_money = money;
      }
    }    
    
}
