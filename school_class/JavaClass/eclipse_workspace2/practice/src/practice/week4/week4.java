package practice.week4;
import java.util.Scanner;


public class week4 {
	public static void main(String[] args) {
		/*
		int score = 93;
		if(score >= 90) {
			System.out.println("������ 90���� ũ��.");
			System.out.println("����� A");
			
		} else {
			System.out.println("������ 90���� �۴�");
			System.out.println("����� A�� �ƴϴ�.");
		}
		System.out.println("����");
		*/
		
		/*
		System.out.println("���� 1�� �Է� : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if ( num % 2 == 0) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
	
		System.out.println((num % 2 == 0) ?"¦��" : "Ȧ��");
		*/
		
		/*
		int a = 3, b = 3;
		if(a < 2) 
			if (a < 3)
				b=4;
		else
			b=5;
		System.out.println("b = " + b);
		//dangling else
		 */
		
		System.out.println("���� 1�� �Է� : ");
		Scanner str1 = new Scanner(System.in);
		int score = str1.nextInt();
		//int score = (int)(Math.random()*100); �����Լ�
		System.out.println("���� : " + score);
		
		if (score >= 90) {
			if (score > 100) {
				System.out.println("�߸� �Էµ� ���� �Դϴ�.");
			}else {
				System.out.println("������ 90�̻� �Դϴ�.");
				System.out.println("����� A");
			}
		}else if (score >= 80) {
			System.out.println("������ 80�̻� �Դϴ�.");
			System.out.println("����� B");
		}else if (score >= 70) {
			System.out.println("������ 70�̻� �Դϴ�.");
			System.out.println("����� C");
		}else {
			System.out.println("�����");
		}
		
		switch (score) {
		case 1:
			System.out.println("1��");
			break;
		case 2:
			System.out.println("2��");
			break;
		case 3:
			System.out.println("3��");
			break;
		case 4:
			System.out.println("4��");
			break;
		case 5:
			System.out.println("5��");
			break;
		default:
			System.out.println("6��");
			break;
		}
		
		switch (score / 10) {
		
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
	}
}
