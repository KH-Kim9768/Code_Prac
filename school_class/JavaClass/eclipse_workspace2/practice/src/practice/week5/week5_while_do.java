package practice.week5;

public class week5_while_do {
	
	public static void main(String[] args) {
		
//		int x = 1;
//		
//		
//		while(x <= 9) {
//			int y = 2;
//			
//			while(y <= 9) {
//				System.out.print(y + " X " + x + " = " + x*y +"\t");
//				y++;
//			}
//			System.out.println();
//			x++;
//			
//		}
		
		
		
		int i = 1;
		do {
			int j = 2;
			do {
				System.out.print(j + " X " + i + " = " + i*j + "\t");
				j++;
			}while (j <= 9);
			System.out.println();
			i++;
			
		}while (i <= 9);
		
	}//main

}
