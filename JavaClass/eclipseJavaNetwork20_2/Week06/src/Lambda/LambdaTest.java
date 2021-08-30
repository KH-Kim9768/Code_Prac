package Lambda;

import java.util.Scanner;

public class LambdaTest {
	// �� ���� Ű����� �Է¹޾Ƽ� �� ���� �հ� �������� ����ϴ� �ڵ带
	// ���ٽ����� �ۼ��Ͻÿ�
	
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
		
		System.out.print("�� ���� �Է��ϼ��� : ");
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
		Cube c = a -> a * a * a; // 1�� �� �� return�� ���� ����, �Ű������� 1���� �� �Ұ�ȣ ��������
		c.getCube(num1);

	}
	
}
