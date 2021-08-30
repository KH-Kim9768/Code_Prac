package kr.ac.shingu.cs.network;

import java.util.Arrays;
import java.util.List;

public class FruitsTest {

	public static void main(String[] args) {
		List<Fruits> fruitsList = Arrays.asList(
				new Fruits("딸기", "빨간색", 20),
				new Fruits("바나나", "노란색", 60),
				new Fruits("귤", "노란색", 35),
				new Fruits("딸기", "빨간색", 22),
				new Fruits("수박", "초록색", 250),
				new Fruits("사과", "빨간색", 90)
				);
		
		int sum = fruitsList.stream()
				.filter(w -> w.getColor() == "빨간색")
				.mapToInt(w -> w.getWeight())
				.sum();
		
		System.out.println(sum);
		
		
		// Q. 빨간색 과일의 개수를 출력하는 프로그램을 작성하시오.
		
		int cnt = (int) fruitsList.stream()
				.filter(w -> w.getColor() == "빨간색")
				.count(); // 카운트의 리턴은 long
		
		System.out.println(cnt);
	}
}
