package Lambda;
// ǥ�� �Լ��� �������̽��� Supplier�� �̿��Ͽ� ������ ���� (�ֻ���)�� ����ϴ� �ڵ带 ���ٽ����� �ۼ��Ͻÿ�.

import java.util.function.Supplier;

public class LambdaAssignment {
	public static void main(String[] args) {
		Supplier a = () -> {
			
			int dice = (int) (Math.random()*6)+1;
			
			return dice;
		};
		
		System.out.println("�ֻ��� : " + a.get());
	}
	
}
