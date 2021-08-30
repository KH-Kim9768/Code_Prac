package Lambda;

import java.util.Scanner;

public class LambdaTest {
	// 두 수를 키보드로 입력받아서 두 수의 합과 나머지를 출력하는 코드를
	// 람다식으로 작성하시오
	
	public interface Sum{
		void getSum(double n1, double n2);
	}
	
	public interface Remainder{
		void getRem(double n1, double n2);
	}
	
	public interface SumRemainder{
		void getSR(double num1, double num2);
	}
	
//	public interface Cube{
//		void getCube(double num1);
//	}
	
	public interface Cube{
		double getCube(double num1);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 수를 입력하세요 : ");
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		
//		Sum s = (a, b) -> System.out.println(a+b);
//		Remainder r = (a, b) -> System.out.println(a%b);
//		
//		
//		s.getSum(num1, num2);
//		r.getRem(num1, num2);
		
		SumRemainder sr = (a, b) -> System.out.println((a+b) +", "+ (a%b));
		sr.getSR(num1, num2);
		
//		Cube c = (a) -> System.out.println(a * a * a);
		Cube c = a -> a * a * a; // 1줄 일 때 return은 생략 가능, 매개변수가 1개일 때 소괄호 생략가능
		c.getCube(num1);

	}
	
}
