package practice.week4;
import java.util.Scanner;


public class week4 {
	public static void main(String[] args) {
		/*
		int score = 93;
		if(score >= 90) {
			System.out.println("점수가 90보다 크다.");
			System.out.println("등급은 A");
			
		} else {
			System.out.println("점수가 90보다 작다");
			System.out.println("등급은 A가 아니다.");
		}
		System.out.println("종료");
		*/
		
		/*
		System.out.println("정수 1개 입력 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if ( num % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
	
		System.out.println((num % 2 == 0) ?"짝수" : "홀수");
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
		
		System.out.println("정수 1개 입력 : ");
		Scanner str1 = new Scanner(System.in);
		int score = str1.nextInt();
		//int score = (int)(Math.random()*100); 랜덤함수
		System.out.println("점수 : " + score);
		
		if (score >= 90) {
			if (score > 100) {
				System.out.println("잘못 입력된 점수 입니다.");
			}else {
				System.out.println("점수가 90이상 입니다.");
				System.out.println("등급은 A");
			}
		}else if (score >= 80) {
			System.out.println("점수가 80이상 입니다.");
			System.out.println("등급은 B");
		}else if (score >= 70) {
			System.out.println("점수가 70이상 입니다.");
			System.out.println("등급은 C");
		}else {
			System.out.println("재수강");
		}
		
		switch (score) {
		case 1:
			System.out.println("1번");
			break;
		case 2:
			System.out.println("2번");
			break;
		case 3:
			System.out.println("3번");
			break;
		case 4:
			System.out.println("4번");
			break;
		case 5:
			System.out.println("5번");
			break;
		default:
			System.out.println("6번");
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
