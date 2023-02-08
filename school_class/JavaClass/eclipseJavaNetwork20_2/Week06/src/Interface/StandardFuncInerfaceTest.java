package Interface;

import java.util.stream.Stream;


public class StandardFuncInerfaceTest {
	
	public interface Cube{	// Function style
		double getCube(double num1);
	}
	
	public interface Five{	// Supplier style
		int printFive();
	}

	public static void main(String[] args) {
		
		Stream<String> s;
		Five f = () -> 5; // Five f = () -> {return 5;};
		Cube c = x -> x * x * x;
		s.map(x -> {return x * x * x;}); // .map 안에는 Function style만 가능하다.
	}

}
