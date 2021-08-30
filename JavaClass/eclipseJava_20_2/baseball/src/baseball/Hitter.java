package baseball;

import java.util.Scanner;

public class Hitter {

//	int[] pitcher = new int[9];
	int[] player = new int[3];
	int counter = 0;
	
	
	
	public void hit(int[] pitcher){
		
		System.out.println("야구게임 : 자릿수와 번호가 맞으면 스트라이크! 번호만 맞으면 볼!");
		System.out.println("총 3번을 입력하여 컴퓨터가 던진 숫자를 자릿수까지 정확하게 맞추면 아웃!");
		System.out.println();
		System.out.println("야구 게임을 시작!");
		System.out.println();

		while (true) { 

			int strike = 0, ball = 0;
			Scanner scanner = new Scanner(System.in); 
			for (int i = 0; i < 3; i++) {
					System.out.print("입력: ");
					player[i] = scanner.nextInt(); 
					if (player[i] > 10 || player[i] < 0) { 
						System.out.println("1~9의 정수를 입력하세요");
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
			System.out.println(strike + " 스타라이크 " + ball + " 볼");
			if (strike == 3) {
				break;
			}
			counter++; 

		} 
		System.out.println("횟수 : " + counter); 
		System.out.println("Game Over");

	}
}
