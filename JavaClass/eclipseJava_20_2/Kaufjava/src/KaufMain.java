import java.util.Scanner;

public class KaufMain {

	public static void main(String[] args) {
		
		double height = 0;
		double weight = 0;
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ű�� �Է��ϼ��� (m ����) : ");
		height = scan.nextDouble();
		
		System.out.print("�����Ը� �Է��ϼ��� (kg ����) : ");
		weight = scan.nextDouble();
		
		Kauf k = new Kauf();
		
		System.out.print("����� Kauf ������ "+ k.KaufCalc(height, weight) + "�̸� ������´� " + k.bmiResult(k.KaufCalc(height, weight)));
		
		
	}

}
