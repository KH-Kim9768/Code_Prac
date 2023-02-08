package practice.week8;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
	
	public static void main(String[] args) {
		/* 가위바위보 규칙 
		 * 가위는 1, 바위는 2, 보자기는 3을 뜻한다.
		 * 컴퓨터는 랜덤 클래스를 이용하여 1~3까지의 숫자를 임의로 정하고 사용자로 부터 1~3의 숫자를 입력받는다
		 * 두 숫자를 비교하여 규칙에 따라 승패를 결정한다.
		 * 게임 종료를 원하면 0을 입력하고, 0~3외의 숫자를 입력하면 다시 입력한다.
		 * 추가적으로 현재 전적을 표시해준다. 
		 */
		
		int win = 0; // 승
		int lose = 0; // 패
		int draw = 0; // 무
		System.out.println("가위바위보 게임을 시작합니다.");
		
		while(true) {
			
			Random rand = new Random();
			int com = rand.nextInt(3) + 1; // 컴퓨터 1~3 숫자 랜덤하게 생성
			System.out.println("현재 전적은 " + win + "승 " + draw + "무 " + lose + "패 입니다.");
			System.out.printf("가위 바위 보를 입력해 주세요. (가위는 1, 바위는 2, 보자기는 3, 종료는 0) : ");
			Scanner scan = new Scanner(System.in);
			int user = scan.nextInt();
			
			if (user == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			if (com == user) {
				System.out.println("무승부 입니다.");
				draw += 1;
				continue;
				
			}
			
			if (user == 1) {
				if(com == 2) {
					System.out.println("컴퓨터는 바위입니다. 컴퓨터가 승리했습니다.");
					lose += 1;
					continue;
					
				} else if(com == 3) {
					System.out.println("컴퓨터는 보자기입니다. 사용자가 승리했습니다.");
					win += 1;
					continue;
				}
			}
			
			if (user == 2) {
				if(com == 1) {
					System.out.println("컴퓨터는 가위입니다. 사용자가 승리했습니다.");
					win += 1;
					continue;
					
				} else if(com == 3) {
					System.out.println("컴퓨터는 보자기입니다. 컴퓨터가 승리했습니다.");
					lose += 1;
					continue;
				}
			}
			
			if (user == 3) {
				if(com == 1) {
					System.out.println("컴퓨터는 가위입니다. 컴퓨터가 승리했습니다.");
					lose += 1;
					continue;
					
				}else if (com == 2) {
					System.out.println("컴퓨터는 바위입니다. 사용자가 승리했습니다.");
					win += 1;
					continue;
					
				}
			}
			
			System.out.println("입력오류입니다. 다시 입력해 주세요.");
		}

		
		
	}

}
