package baseball;

import java.util.Random;

public class Pitcher {
	
	int[] pitcher = new int[9];
	
	
	public void pitch(){
		
		Random rand = new Random();
		
		for (int i = 0; i < pitcher.length; i++) {  
			pitcher[i] = i + 1; 
		}

		for (int i = 0; i < 100; i++) {  
			int j = (int) (Math.random() * 9); 
			int temp = pitcher[0];
			pitcher[0] = pitcher[j];
			pitcher[j] = temp;
		
		}
	}

}
