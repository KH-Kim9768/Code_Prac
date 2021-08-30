
import java.util.Scanner;

public class Zapangi {
    static Scanner scan = new Scanner(System.in);
    final static int COKE = 600;  
    final static int FANTA = 550; 
    final static int COFFEE = 370;
    final static int WATER = 420; 
    final static String D1 = "콜라";
    final static String D2 = "환타"; 
    final static String D3 = "커피";
    final static String D4 = "물";
    static int money;       
    static int t_money=0;   

    public static void main(String args[]) {
        char exit;          // 종료 체킹을 위한 변수
        System.out.println("자판기  테스트");
        System.out.println("-----------------------------------------------");
        System.out.println("1.콜라(600), 2.환타(550), 3.커피(370), 4.물(420)");
        System.out.println("-----------------------------------------------");
        System.out.println();

        money = 0;          

        while (true) {
            if(money==0) {
                money = InputCoin();
            }

            SelectDrink(money);
            System.out.print("추가 선택 하시겠습니까(y/n)? ");
            exit = scan.next().charAt(0);
            money = t_money;

            if (exit == 'n' || exit == 'N') {   

               System.out.println("음료수 선택 종료");
               break;                           
            }
            System.out.println();
      }
    }


   static int InputCoin() {
        System.out.print("금액을 입력하세요: ");
        money = scan.nextInt();     
        money += t_money;   
        t_money = money;    
        //System.out.println(">>Input Coin Money : " + money);
        return money;
  }

   static void SelectDrink(int money) { 
        int sel;
        System.out.print("음료를 선택하세요: ");
        sel = (int) (scan.next().charAt(0)) - 48; 

        if (sel < 1 || sel > 4) {
            System.out.println("Error input select agin 1~4");
            SelectDrink(money);
        }
        
        else {                         

            switch (sel) {
            case 1:
                ChangePay(money, COKE, D1);
                break;
            case 2:
                ChangePay(money, FANTA, D2);
                break;
            case 3:
                ChangePay(money, COFFEE, D3);
                break;
            case 4:
               ChangePay(money, WATER, D4);
                break;
            default:
                System.out.println("Switch error");
                break;
            }
        }
    }



   static void ChangePay(int money, int s, String drink) { 
        int temp;
        int m_1000, m_500, m_100, m_50, m_10;
        char sel;
		
        if (money < s) {      
            System.out.println("Error select money < drink");
            System.out.print("금액을 더 넣으시겠습니까(y/n)? ");
           sel = scan.next().charAt(0);

            if(sel == 'y')                      
                InputCoin();
            else if(sel == 'n') {               
               System.out.println("자판기 종료");
               System.exit(0);
            } 
           else
                SelectDrink(money); 
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
