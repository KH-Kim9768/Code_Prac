public class DrinkDAO {
	static int suryang[] = new int[4];
	
	static void panmae(int choice, int count){
		switch (choice) {
		case 1:
			suryang[0] = count;
			break;
		case 2:
			suryang[1] = count;
			break;
		case 3:
			suryang[2] = count;
			break;
		case 4:
			suryang[3] = count;
			break;
			
		default:

			break;
		}
		
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("음료수의 판매 수량은 콜라 : "+suryang[0]+", 환타 : "+suryang[1]+
				                                  ", 커피 : "+suryang[2]+", 물 : "+suryang[3]);
		
		System.out.println();
	}

}