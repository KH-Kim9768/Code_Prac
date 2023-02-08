package practice.week5;

public class week5_assignment {
	
	public static void main(String[] args) {
		
		for(int i = 2; i <= 9; i++) {
			if(i%2 == 0) {
				continue;
			}
			System.out.println();
			for(int j = 1; j < i; j++) {
				System.out.print(i + " X " + j + " = " + i*j + "\t");
			}
			System.out.println();
			
		}
		
	}

}
