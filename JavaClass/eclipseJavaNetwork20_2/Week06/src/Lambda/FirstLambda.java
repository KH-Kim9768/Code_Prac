package Lambda;

// ���ٽ��� �� ���� �߻�޼ҵ尡 �ϳ�������
// 
public class FirstLambda {
	
	@FunctionalInterface  // << �̰� �� ������ �߻�޼ҵ尡 �ϳ��ۿ� �� �� ����
	public interface BigNumber{
		double getMax(double n1, double n2);
	}
	
	public interface Hello{
		void hi();
	}
	
	public interface Factorial{
		int getFact(int num);
	}
	
	public interface test1{
		int tes(int num);
	}
	
	public static void main(String[] args) {
		Hello h = () -> System.out.println("�ȳ�");
		h.hi();
		
//		// (Ÿ�� �Ű����� ���) -> { ���౸�� ; ���౸��;}
//		
//		BigNumber max = (a, b) -> {
//			if(a>=b)
//				return a;
//			else
//				return b;
//			
//		};
//		System.out.println(max.getMax(2.5, 7.1));
		
		
//		// �������� ������
//		BigNumber max = (a,b) -> (a>=b)? a:b;
//		System.out.println(max.getMax(2.5, 7.3));
		
		
		Factorial f = (x) -> {
			int result = 1;
			for(int i = 1; i<=x; i++)
				result = result *i;
			return result;
		};
		
		System.out.println(f.getFact(5));
		
		test1 t = (x) -> {
			return x;
		};
	}
}
