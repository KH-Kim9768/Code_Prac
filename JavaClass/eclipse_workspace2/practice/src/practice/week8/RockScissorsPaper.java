package practice.week8;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
	
	public static void main(String[] args) {
		/* ���������� ��Ģ 
		 * ������ 1, ������ 2, ���ڱ�� 3�� ���Ѵ�.
		 * ��ǻ�ʹ� ���� Ŭ������ �̿��Ͽ� 1~3������ ���ڸ� ���Ƿ� ���ϰ� ����ڷ� ���� 1~3�� ���ڸ� �Է¹޴´�
		 * �� ���ڸ� ���Ͽ� ��Ģ�� ���� ���и� �����Ѵ�.
		 * ���� ���Ḧ ���ϸ� 0�� �Է��ϰ�, 0~3���� ���ڸ� �Է��ϸ� �ٽ� �Է��Ѵ�.
		 * �߰������� ���� ������ ǥ�����ش�. 
		 */
		
		int win = 0; // ��
		int lose = 0; // ��
		int draw = 0; // ��
		System.out.println("���������� ������ �����մϴ�.");
		
		while(true) {
			
			Random rand = new Random();
			int com = rand.nextInt(3) + 1; // ��ǻ�� 1~3 ���� �����ϰ� ����
			System.out.println("���� ������ " + win + "�� " + draw + "�� " + lose + "�� �Դϴ�.");
			System.out.printf("���� ���� ���� �Է��� �ּ���. (������ 1, ������ 2, ���ڱ�� 3, ����� 0) : ");
			Scanner scan = new Scanner(System.in);
			int user = scan.nextInt();
			
			if (user == 0) {
				System.out.println("������ �����մϴ�.");
				break;
			}
			
			if (com == user) {
				System.out.println("���º� �Դϴ�.");
				draw += 1;
				continue;
				
			}
			
			if (user == 1) {
				if(com == 2) {
					System.out.println("��ǻ�ʹ� �����Դϴ�. ��ǻ�Ͱ� �¸��߽��ϴ�.");
					lose += 1;
					continue;
					
				} else if(com == 3) {
					System.out.println("��ǻ�ʹ� ���ڱ��Դϴ�. ����ڰ� �¸��߽��ϴ�.");
					win += 1;
					continue;
				}
			}
			
			if (user == 2) {
				if(com == 1) {
					System.out.println("��ǻ�ʹ� �����Դϴ�. ����ڰ� �¸��߽��ϴ�.");
					win += 1;
					continue;
					
				} else if(com == 3) {
					System.out.println("��ǻ�ʹ� ���ڱ��Դϴ�. ��ǻ�Ͱ� �¸��߽��ϴ�.");
					lose += 1;
					continue;
				}
			}
			
			if (user == 3) {
				if(com == 1) {
					System.out.println("��ǻ�ʹ� �����Դϴ�. ��ǻ�Ͱ� �¸��߽��ϴ�.");
					lose += 1;
					continue;
					
				}else if (com == 2) {
					System.out.println("��ǻ�ʹ� �����Դϴ�. ����ڰ� �¸��߽��ϴ�.");
					win += 1;
					continue;
					
				}
			}
			
			System.out.println("�Է¿����Դϴ�. �ٽ� �Է��� �ּ���.");
		}

		
		
	}

}
