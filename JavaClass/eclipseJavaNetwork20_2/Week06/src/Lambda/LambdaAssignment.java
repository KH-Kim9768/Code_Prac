package Lambda;
// 표준 함수적 인터페이스인 Supplier를 이용하여 임의의 난수 (주사위)를 출력하는 코드를 람다식으로 작성하시오.

import java.util.function.Supplier;

public class LambdaAssignment {
	public static void main(String[] args) {
		Supplier a = () -> {
			
			int dice = (int) (Math.random()*6)+1;
			
			return dice;
		};
		
		System.out.println("주사위 : " + a.get());
	}
	
}
