package practice.week5;

public class week5_for {
	
	public static void main(String[] args) {
		
		/*
		for (int x = 2; x <= 9; x++) {
			System.out.println("*****" + x + "´Ü *****");
			for (int y = 1; y <= 9; y++) {
				System.out.println(x + " X " + y + " = " + x*y);
			}
		}
		*/
		
		for (int x = 0; x <= 9; x++) {
			for (int y = 2; y <= 9; y++) {
				if (x==0) {
					
					System.out.print("****" + y + "´Ü****" + "\t");
				}else {
					System.out.print(y + " X " + x + " = " + x*y + "\t");
				}
			}
			System.out.println();
		}
	}

}
