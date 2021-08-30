package Lambda;

// 람다식을 쓸 때는 추상메소드가 하나여야함
// 
public class FirstLambda {
	
	@FunctionalInterface  // << 이걸 써 놓으면 추상메소드가 하나밖에 올 수 없음
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
		Hello h = () -> System.out.println("안녕");
		h.hi();
		
//		// (타입 매개변수 목록) -> { 실행구문 ; 실행구문;}
//		
//		BigNumber max = (a, b) -> {
//			if(a>=b)
//				return a;
//			else
//				return b;
//			
//		};
//		System.out.println(max.getMax(2.5, 7.1));
		
		
//		// 삼항조건 연산자
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
