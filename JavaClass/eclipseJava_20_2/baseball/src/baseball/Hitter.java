package baseball;

import java.util.Scanner;

public class Hitter {

//	int[] pitcher = new int[9];
	int[] player = new int[3];
	int counter = 0;
	
	
	
	public void hit(int[] pitcher){
		
		System.out.println("�߱����� : �ڸ����� ��ȣ�� ������ ��Ʈ����ũ! ��ȣ�� ������ ��!");
		System.out.println("�� 3���� �Է��Ͽ� ��ǻ�Ͱ� ���� ���ڸ� �ڸ������� ��Ȯ�ϰ� ���߸� �ƿ�!");
		System.out.println();
		System.out.println("�߱� ������ ����!");
		System.out.println();

		while (true) { 

			int strike = 0, ball = 0;
			Scanner scanner = new Scanner(System.in); 
			for (int i = 0; i < 3; i++) {
					System.out.print("�Է�: ");
					player[i] = scanner.nextInt(); 
					if (player[i] > 10 || player[i] < 0) { 
						System.out.println("1~9�� ������ �Է��ϼ���");
					}
			} 

			for (int i = 0; i < 3; i++) { 
				for (int j = 0; j < player.length; j++) {
					if (pitcher[i] == player[j] && i == j) { 
						strike++; 
					} 
					else if (pitcher[i] == player[j] && i != j) { 
						ball++;
					}
				}
			}
			System.out.println(strike + " ��Ÿ����ũ " + ball + " ��");
			if (strike == 3) {
				break;
			}
			counter++; 

		} 
		System.out.println("Ƚ�� : " + counter); 
		System.out.println("Game Over");

	}
}
