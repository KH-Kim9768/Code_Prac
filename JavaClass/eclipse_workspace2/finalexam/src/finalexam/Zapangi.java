package finalexam;

public class Zapangi {
	
	public static void main(String[] args) {
		final String D1 = "�ݶ�";
	    final String D2 = "ȯŸ"; 
	    final String D3 = "Ŀ��";
	    final String D4 = "��";
	    final int COKE = 600;  
	    final int FANTA = 550; 
	    final int COFFEE = 370;
	    final int WATER = 420; 
		Screen scr = new Screen();
		Changer cha = new Changer();
		Selector select = new Selector();
		int selD = 0;
		boolean keepGo = true;
		
		System.out.println("���Ǳ� On");
		while(keepGo) {
			scr.items();
			System.out.println("���� ������ �ݾ� : " + cha.t_money);
			if (cha.money == 0) {
				System.out.println("���� �־��ּ���.");
				cha.InputCoin();
				continue;
			}
			else {
				selD = select.SelectDrink();
			}
			
			switch (selD) {
            case 1:
                cha.ChangePay(cha.money, COKE, D1);
                break;
            case 2:
                cha.ChangePay(cha.money, FANTA, D2);
                break;
            case 3:
                cha.ChangePay(cha.money, COFFEE, D3);
                break;
            case 4:
               cha.ChangePay(cha.money, WATER, D4);
               break;
            default:
                System.out.println("����ġ �����Դϴ�.");
                break;
            }
			if (cha.re == 1) {
				cha.re = 0;
				continue;
			}
			keepGo = scr.chooseContinue();
		}
		System.out.println("���Ǳ� Off");
		
	}

}
