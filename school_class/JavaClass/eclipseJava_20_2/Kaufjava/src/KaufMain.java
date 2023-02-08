import java.util.Scanner;

public class KaufMain {

	public static void main(String[] args) {
		
		double height = 0;
		double weight = 0;
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("키를 입력하세요 (m 단위) : ");
		height = scan.nextDouble();
		
		System.out.print("몸무게를 입력하세요 (kg 단위) : ");
		weight = scan.nextDouble();
		
		Kauf k = new Kauf();
		
		System.out.print("당신의 Kauf 지수는 "+ k.KaufCalc(height, weight) + "이며 영양상태는 " + k.bmiResult(k.KaufCalc(height, weight)));
		
		
	}

}
