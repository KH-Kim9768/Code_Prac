package finalexam;

import java.util.Scanner;


public class Changer {
	
    int money;       
    int t_money=0;
    int re = 0;
    Scanner scan = new Scanner(System.in);
    
    public int InputCoin() {
        System.out.print("������ �ݾ��� �Է��ϼ���: ");
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
	            System.out.println("�ݾ��� �����մϴ�.");
	            System.out.print("���� �� �����ðڽ��ϱ�(y/n)? ");
	            sel = scan.next().charAt(0);
	
	            if(sel == 'y') {                      
	                InputCoin();
	                re = 1;
	                break;
	            }
	            else if (sel == 'n'){               
	            	System.out.println("���Ḧ �ٽ� �����ϼ���.");
	            	break;
	            }
	            else {
	            	System.out.println("�߸��� �Է��Դϴ�. �ٽ� �������ּ���.");
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
            System.out.println("������ ������� " + drink +"�̸� �Ž�������  " + money + "�� �Դϴ�.");
            System.out.print("1000�� : " + m_1000 + ", ");
            System.out.print("500�� : " + m_500 + ", ");
            System.out.print("100�� : " + m_100 + ", ");
            System.out.print("50�� : " + m_50 + ", ");
            System.out.println("10�� : " + m_10);
            System.out.println("---------------------------------------- -------");
            System.out.println();
            t_money = money;
      }
    }    
    
}
