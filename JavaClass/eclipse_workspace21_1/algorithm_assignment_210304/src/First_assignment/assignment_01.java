package First_assignment;

import java.util.Scanner;

// 2015132076 �豤��
// ������ �Է¹޾� �� ���� ���丮��, 1���� �� �������� �� ���
// 0 �Է½� ���α׷� ����

public class assignment_01 {
	public static int factorial(int n) {
		if (n <= 0) {
			return 1;
		}
		
		else {
			return n * factorial(n-1);
		}
	}
	
	public static int summary(int n) {
		return n*(n+1)/2;
		
	}
	
	public static void main(String[] args) {
		int num;
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("������ �Է��ϼ���(0 �Է� �� ���α׷� ����) : ");
			num = scan.nextInt();
			
			if (num <= 0) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
			
			else {
				System.out.println(num + "�� ���丮�� : " + factorial(num));
				System.out.println("1���� " + num + "������ �� : " + summary(num));
			}
		}
		
	}
	
}
