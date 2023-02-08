package First_assignment;

import java.util.Scanner;

// 2015132076 김광희
// 정수를 입력받아 그 수의 팩토리얼, 1부터 그 정수까지 합 출력
// 0 입력시 프로그램 종료

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
			System.out.print("정수를 입력하세요(0 입력 시 프로그램 종료) : ");
			num = scan.nextInt();
			
			if (num <= 0) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			
			else {
				System.out.println(num + "의 팩토리얼 : " + factorial(num));
				System.out.println("1부터 " + num + "까지의 합 : " + summary(num));
			}
		}
		
	}
	
}
